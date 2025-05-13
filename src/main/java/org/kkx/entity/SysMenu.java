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
@Table(name = "sys_menu")
public class SysMenu {
    @Id
    @Column(name = "menu_id", nullable = false)
    private Integer menuId;

    @Column(name = "menu_name", nullable = false, length = Integer.MAX_VALUE)
    private String menuName;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "path", length = Integer.MAX_VALUE)
    private String path;

    @ColumnDefault("now()")
    @Column(name = "create_time")
    private OffsetDateTime createTime;

    @ColumnDefault("now()")
    @Column(name = "update_time")
    private OffsetDateTime updateTime;

}