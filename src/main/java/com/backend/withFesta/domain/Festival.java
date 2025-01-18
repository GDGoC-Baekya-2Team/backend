package com.backend.withFesta.domain;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fstvlName; //축제명
    private LocalDateTime fstvlStart; //축제 시작
    private Long number; //전화번호
    private String location; //개최장소
    private String mnnstNm; //주관기관명
    private String rdnmadr; //도로명주소
    private LocalDateTime fstvlEnd; //축제 종료
}