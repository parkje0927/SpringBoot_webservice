package com.jh.webservice.domain;

import lombok.Getter;
import org.apache.tomcat.jni.Local;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    /**
     * 모든 Entity 들의 상위 클래스가 되어 Entity 들의 createdDate, modifiedDate 를 자동으로 관리하는 역할
     * - @MappedSuperclass
     *  + JPA Entity 클래스들이 BaseTimeEntity 를 상속할 경우 필드들(createdDate, modifiedDate) 도 컬럼으로 인식하도록 한다.
     * - @EntityListeners(AuditingEntityListener.class)
     *  + BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다.
     *
     * - @CreatedDate
     *  + Entity 가 생성되어 저장될 때 시간이 자동 저장된다.
     * - @LastModifiedDate
     *  + 조회한 Entity 의 값을 변경할 때 시간이 자동 저장된다,
     */

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
