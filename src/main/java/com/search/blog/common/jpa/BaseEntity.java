package com.search.blog.common.jpa;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseEntity {

    @CreatedDate
    @Column(
            nullable=true,
            updatable=false
    )
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime searchDatetime;

}
