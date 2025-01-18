package com.backend.withFesta.service;
import com.backend.withFesta.domain.dto.RecruitRequestDto;
import com.backend.withFesta.domain.dto.RecruitResponseDto;
import com.backend.withFesta.domain.entity.Recruit;
import com.backend.withFesta.repository.RecruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecruitService {

    private final RecruitRepository recruitRepository;

    /* READ - 특정 구인글 조회 */
    @Transactional(readOnly = true)
    public RecruitResponseDto findById(Long recruitId) {
        Recruit recruit = recruitRepository.findById(recruitId)
                .orElseThrow(() -> new IllegalArgumentException("해당 구인글이 존재하지 않습니다. ID: " + recruitId));
        return RecruitResponseDto.fromEntity(recruit);
    }

    /* READ - 전체 구인글 조회 */
    @Transactional(readOnly = true)
    public List<RecruitResponseDto> findAll() {
        List<Recruit> recruits = recruitRepository.findAll();
        return recruits.stream()
                .map(RecruitResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    /* CREATE - 구인글 생성 */
    @Transactional
    public Long save(RecruitRequestDto recruitRequestDto) {
        Recruit recruit = recruitRequestDto.toEntity();
        recruitRepository.save(recruit);
        return recruit.getRecruitId();
    }

    @Transactional(readOnly = true)
    public Page<Recruit> pageLists(Pageable pageable){
        return recruitRepository.findAll(pageable);
    }

}
