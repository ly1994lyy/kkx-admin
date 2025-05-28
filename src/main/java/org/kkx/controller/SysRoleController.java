package org.kkx.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.kkx.entity.SysRole;
import org.kkx.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@Tag(name = "角色模块")
@RequestMapping("role")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("role")
    @Operation(summary = "分页获取角色列表")
    public Page<SysRole> getRoles(@PathParam("page") int page, @PathParam("size") int size) {
        return sysRoleService.findAll(page,size);
    }

    @PostMapping("role")
    @Operation(summary = "新增角色")
    public SysRole saveRole(@RequestBody SysRole role) {
        return sysRoleService.createOne(role);
    }

    @PutMapping("")
    @Operation(summary = "更新菜单")
    public SysRole update(SysRole role) {
        return sysRoleService.updateOne(role);
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据ID查询菜单详情")
    public Optional<SysRole> getRoleById(@PathVariable String id) {
        return sysRoleService.findOneById(Long.valueOf(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "根据id删除菜单")
    public void deleteRole(@PathVariable String id) {
        sysRoleService.deleteOneById(Long.valueOf(id));
    }

}
