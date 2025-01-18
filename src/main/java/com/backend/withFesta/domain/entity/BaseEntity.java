package com.backend.withFesta.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Column(name="created_date",nullable=false)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name="modified_date",nullable=false)
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}