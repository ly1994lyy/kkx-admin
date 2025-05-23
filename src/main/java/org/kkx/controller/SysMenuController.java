package org.kkx.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.kkx.entity.SysMenu;
import org.kkx.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "菜单模块")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("menu")
    public Page<SysMenu> getRoles(@PathParam("page") int page, @PathParam("size") int size) {
        return sysMenuService.findAll(page,size);
    }
}
