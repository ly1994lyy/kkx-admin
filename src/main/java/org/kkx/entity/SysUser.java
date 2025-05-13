package org.kkx.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "sys_user")
public class SysUser {
    @Id
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "user_name", nullable = false, length = Integer.MAX_VALUE)
    private String userName;

    @ColumnDefault("now()")
    @Column(name = "update_time")
    private OffsetDateTime updateTime;

    @ColumnDefault("now()")
    @Column(name = "create_time")
    private OffsetDateTime createTime;

}