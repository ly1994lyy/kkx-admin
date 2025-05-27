package org.kkx.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "sys_menu")
public class SysMenu extends BaseEntity {
    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "path")
    private String path;

    @Column()
    private String icon;

    @Column(nullable = false)
    private String component;

    @Column()
    private String description;

    @ManyToMany(mappedBy = "menus")
    private List<SysRole> roles;

}