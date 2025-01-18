package com.backend.withFesta.service;

import com.backend.withFesta.common.exception.GeneralException;
import com.backend.withFesta.common.status.ErrorStatus;
import com.backend.withFesta.domain.entity.Festival;
import com.backend.withFesta.repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.time.LocalDate;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitUtil {
    private final FestivalRepository festivalRepository;

    @Transactional
    public void init() {
        Workbook workbook = readExcelFile("assets/전국문화축제표준데이터.xls");
        Sheet sheet = readExcelSheet(workbook, 0);

        for (int i = 2; i <= sheet.getLastRowNum(); i++) {

            // read row data
            Row row = sheet.getRow(i);
            if (row == null || isRowEmpty(row)) continue;

            String fstvlName = parseStringCellValue(row,0);
            String location = parseStringCellValue(row, 1);
            String fstvlStart = parseStringCellValue(row, 2);
            String fstvlEnd = parseStringCellValue(row, 3);
            String mnnstNm = parseStringCellValue(row, 5);
            String number = parseStringCellValue(row, 8);
            String rdnmadr = parseStringCellValue(row, 11);

            log.info("start="+fstvlStart+"/end="+fstvlEnd+"/name="+fstvlName);
            Festival festival = Festival.builder()
                    .fstvlName(fstvlName)
                    .location(location)
                    .number(number)
                    .mnnstNm(mnnstNm)
                    .rdnmadr(rdnmadr)
                    .fstvlStart(LocalDate.parse(fstvlStart))
                    .fstvlEnd(LocalDate.parse(fstvlEnd))
                    .build();
            festivalRepository.save(festival);
        }
    }

    private Workbook readExcelFile(String path) {
        try {
            ClassPathResource classPathResource = new ClassPathResource(path);
            InputStream inputStream = classPathResource.getInputStream();
            return new HSSFWorkbook(inputStream);
        } catch (Exception e){
            throw new GeneralException(ErrorStatus.FAILURE_READ_EXCEL_FILE);
        }
    }

    private Sheet readExcelSheet(Workbook workbook, int sheet){
        try{
            return workbook.getSheetAt(sheet);
        } catch (Exception e){
            throw new GeneralException(ErrorStatus.FAILURE_READ_EXCEL_SHEET);
        }
    }

    private String parseStringCellValue(Row row, int cellNum){
        try {
            return row.getCell(cellNum).getStringCellValue();
        } catch (IllegalStateException e) {
            return String.valueOf((int) row.getCell(cellNum).getNumericCellValue());
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isRowEmpty(Row row) {
        if (row == null)
            return true;

        for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
            Cell cell = row.getCell(cellNum);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false; // Row is not empty
            }
        }
        return true; // Row is empty
    }

}
