package com.backend.withFesta.controller;

import com.backend.withFesta.domain.dto.RecruitRequestDto;
import com.backend.withFesta.domain.dto.RecruitResponseDto;
import com.backend.withFesta.service.RecruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController // @RestController로 변경하여 JSON 반환 자동 처리
@RequestMapping("/api/recruits")
public class RecruitApiController {

    private final RecruitService recruitService;

    // 특정 구인글 조회 (GET /api/recruits/{recruitId})
    @GetMapping("/{recruitId}")
    public ResponseEntity<RecruitResponseDto> getRecruitById(@PathVariable Long recruitId) {
        RecruitResponseDto recruit = recruitService.findById(recruitId);
        return ResponseEntity.ok(recruit);
    }

    // 전체 구인글 조회 (GET /api/recruits)
    @GetMapping
    public ResponseEntity<List<RecruitResponseDto>> getAllRecruits() {
        List<RecruitResponseDto> recruits = recruitService.findAll();
        return ResponseEntity.ok(recruits);
    }

    // 구인글 생성 (POST /api/recruits)
    @PostMapping
    public ResponseEntity<Long> createRecruit(@RequestBody RecruitRequestDto recruitRequestDto) {
        Long recruitId = recruitService.save(recruitRequestDto);
        return ResponseEntity.ok(recruitId);
    }
}
