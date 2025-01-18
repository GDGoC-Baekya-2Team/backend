package com.backend.withFesta.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Getter
public class Recruit extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long recruitId;

    @Column(nullable = false)
    private String pay;
    @Column(nullable = false)
    private String job;
    @Column(nullable = false)
    private LocalDateTime days;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="festival_id")
    private Festival festival;

    public void update(String pay,String job,String description){
        this.pay = pay;
        this.job = job;
        this.description = description;
    }
}