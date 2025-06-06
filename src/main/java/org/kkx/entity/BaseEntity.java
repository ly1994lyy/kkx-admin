package org.kkx.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * @author LY
 * @date 2025/05/27
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class BaseEntity {
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createTime;

    @CreatedDate
    @Column()
    private LocalDateTime updateTime;

}
