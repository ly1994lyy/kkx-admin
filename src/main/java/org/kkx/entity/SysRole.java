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
@Table(name = "sys_role")
public class SysRole {
    @Id
    @Column(name = "role_id", nullable = false)
    private Integer roleId;

    @Column(name = "role_name", nullable = false, length = Integer.MAX_VALUE)
    private String roleName;

    @ColumnDefault("now()")
    @Column(name = "update_time")
    private OffsetDateTime updateTime;

    @ColumnDefault("now()")
    @Column(name = "create_time")
    private OffsetDateTime createTime;

}