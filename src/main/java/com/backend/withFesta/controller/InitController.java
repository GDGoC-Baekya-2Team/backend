package com.backend.withFesta.controller;

import com.backend.withFesta.common.response.ApiResponse;
import com.backend.withFesta.common.status.SuccessStatus;
import com.backend.withFesta.service.InitUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class InitController {
    private final InitUtil initUtil;

    @GetMapping("/init")
    public ResponseEntity<ApiResponse<String>> init() {
        initUtil.init();
        return ApiResponse.success(SuccessStatus.OK);
    }
}
