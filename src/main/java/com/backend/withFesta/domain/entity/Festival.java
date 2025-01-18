package com.backend.withFesta.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Entity
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long festivalId;
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

    @OneToMany(mappedBy = "festival", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Recruit> recruits;

    public void update(String fstvlName,String number,String location,String mnnstNm,String rdnmadr){
        this.fstvlName=fstvlName;
        this.number=number;
        this.location=location;
        this.mnnstNm=mnnstNm;
        this.rdnmadr=rdnmadr;
    }

}