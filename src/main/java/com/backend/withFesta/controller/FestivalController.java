package com.backend.withFesta.controller;
import com.backend.withFesta.dto.FestivalDTO;
import com.backend.withFesta.service.FestivalService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("festivals")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class FestivalController {
    private final FestivalService festivalService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<FestivalDTO>> findByFestivalId(@PathVariable Long id) {
        FestivalDTO festivalDto = festivalService.findByFestivalId(id);
        return ApiResponse.success(SuccessStatus.OK, festivalDto);
    }
}