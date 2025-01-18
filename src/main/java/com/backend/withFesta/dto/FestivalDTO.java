package com.backend.withFesta.dto;
import com.backend.withFesta.domain.Festival;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class FestivalDTO {
    private Long id;
    private String fstvlName; //축제명
    private LocalDateTime fstvlStart; //축제 시작
    private Long number; //전화번호
    private String location; //개최장소
    private String mnnstNm; //주관기관명
    private String rdnmadr; //도로명주소
    private LocalDateTime fstvlEnd; //축제 종료

    public static FestivalDTO from(Festival festival) {
        return FestivalDTO.builder()
                .id(festival.getId())
                .fstvlName(festival.getFstvlName())
                .fstvlStart(festival.getFstvlStart())
                .number(festival.getNumber())
                .location(festival.getLocation())
                .mnnstNm(festival.getMnnstNm())
                .rdnmadr(festival.getRdnmadr())
                .fstvlEnd(festival.getFstvlEnd())
                .build();
    }

}