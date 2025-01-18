package com.backend.withFesta.controller;

import com.backend.withFesta.common.response.ApiResponse;
import com.backend.withFesta.common.status.SuccessStatus;
import com.backend.withFesta.domain.dto.response.FestivalDto;
import com.backend.withFesta.service.FestivalService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/festivals")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class FestivalController {
    private final FestivalService festivalService;

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<FestivalDto.searchDto>>> search(
            @RequestParam(name = "name",  required = false) String name
    ){
        List<FestivalDto.searchDto> response = festivalService.search(name);
        return ApiResponse.success(SuccessStatus.OK, response);
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<FestivalDto.searchDto>>> home(
    ){
        List<FestivalDto.searchDto> response = festivalService.getRecentFestivals();
        return ApiResponse.success(SuccessStatus.OK, response);
    }

}
