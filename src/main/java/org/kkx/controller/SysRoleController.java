package org.kkx.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.kkx.entity.SysRole;
import org.kkx.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Tag(name = "角色模块")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("role")
    public Page<SysRole> getRoles(@PathParam("page") int page, @PathParam("size") int size) {
        return sysRoleService.findAll(page,size);
    }

    @PostMapping("role")
    public SysRole saveRole(@RequestBody SysRole role) {
        return sysRoleService.saveRole(role);
    }
}
