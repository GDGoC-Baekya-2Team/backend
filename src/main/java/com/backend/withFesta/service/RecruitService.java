package com.backend.withFesta.service;

import com.backend.withFesta.repository.RecruitRepository;
import com.backend.withFesta.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RecruitService {

    private final RecruitRepository recruitRepository;
    private final UserRepository userRepository;


}
