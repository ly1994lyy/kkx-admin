package org.kkx.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.kkx.entity.SysUser;
import org.kkx.entity.SysUser;
import org.kkx.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Tag(name = "用户模块")
@RequestMapping("user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("")
    @Operation(summary = "分页获取用户")
    public Page<SysUser> getRoles(@PathParam("page") int page, @PathParam("size") int size) {
        return sysUserService.findAll(page,size);
    }

    @PostMapping("")
    @Operation(summary = "新增用户")
    public SysUser saveRole(@RequestBody SysUser sysUser) {
        return sysUserService.createOne(sysUser);
    }

    @PutMapping("")
    @Operation(summary = "更新用户")
    public SysUser update(SysUser user) {
        return sysUserService.updateOne(user);
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据ID查询用户详情")
    public Optional<SysUser> getRoleById(@PathVariable String id) {
        return sysUserService.findOneById(Long.valueOf(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "根据id删除用户")
    public void deleteRole(@PathVariable String id) {
        sysUserService.deleteOneById(Long.valueOf(id));
    }
}
