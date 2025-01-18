package com.backend.withFesta.domain.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Entity
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fstvl_name")
    private String fstvlName; //축제명
    @Column(name = "location")
    private String location; //개최장소
    @Column(name = "number")
    private String number; //전화번호
    @Column(name = "mnnst_nm")
    private String mnnstNm; //주관기관명
    @Column(name = "rdnmadr")
    private String rdnmadr; //도로명주소
    @Column(name = "fstvl_start")
    private LocalDate fstvlStart; //축제 시작
    @Column(name = "fstvl_end")
    private LocalDate fstvlEnd; //축제 종료

}