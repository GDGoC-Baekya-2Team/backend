package com.backend.withFesta.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fstvlName;
    @Column(name = "fstvlStart_date", nullable = false)
    private LocalDateTime fstvlStart;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String mnnstNm; // 주관기관명
    @Column(nullable = false)
    private String rdnmadr; // 도로명주소
    @Column(name = "fstvlStart_date", nullable = false)
    private LocalDateTime fstvlEnd;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="recruit_id")
    private Recruit recruit;

    public void update(String fstvlName,String number,String location,String mnnstNm,String rdnmadr){
        this.fstvlName=fstvlName;
        this.number=number;
        this.location=location;
        this.mnnstNm=mnnstNm;
        this.rdnmadr=rdnmadr;
    }
}
