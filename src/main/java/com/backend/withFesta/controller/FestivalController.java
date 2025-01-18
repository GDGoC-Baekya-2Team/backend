package com.backend.withFesta.controller;

import com.backend.withFesta.service.FestivalService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("festival")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class FestivalController {
    private final FestivalService festivalService;

    @GetMapping("/search")
    public String search(String keyword, )
}
