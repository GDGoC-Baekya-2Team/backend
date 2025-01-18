package com.backend.withFesta.controller;

import com.backend.withFesta.domain.entity.Festival;
import com.backend.withFesta.service.FestivalService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("festivals")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class FestivalController {
    private final FestivalService festivalService;

//    @GetMapping("/search") //타이틀로 검색
//    public Page<Festival> search(String keyword, int page, int size){
//        Pageable pageable = PageRequest.of(page, size);
//        Page<Festival> festivals = festivalService.searchTitle(keyword, pageable);
//        return ResponseEntity.ok(festivals);
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<Festival> FindByFestivalId ()
}
