package org.kkx.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.kkx.entity.SysUser;
import org.kkx.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "用户模块")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("user")
    public Page<SysUser> getRoles(@PathParam("page") int page, @PathParam("size") int size) {
        return sysUserService.findAll(page,size);
    }

    @PostMapping("user")
    public SysUser saveRole(@RequestBody SysUser sysUser) {
        return sysUserService.saveDept(sysUser);
    }
}
