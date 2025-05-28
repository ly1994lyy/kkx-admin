package org.kkx.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.kkx.entity.SysPermission;
import org.kkx.entity.SysPermission;
import org.kkx.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Tag(name = "权限模块")
@RequestMapping("permission")
public class SysPermissionController {
    @Autowired
    private SysPermissionService sysPermissionService;

    @GetMapping("")
    @Operation(summary = "分页查询权限")
    public Page<SysPermission> getPermissions(@PathParam("page") int page, @PathParam("size") int size) {
        return sysPermissionService.findAll(page,size);
    }

    @PostMapping("")
    @Operation(summary = "新增权限")
    public SysPermission save(@RequestBody SysPermission sysPermission) {
        return sysPermissionService.createOne(sysPermission);
    }

    @PutMapping("")
    @Operation(summary = "更新权限")
    public SysPermission update(@RequestBody SysPermission sysPermission) {
        return sysPermissionService.updateOne(sysPermission);
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据ID查询权限详情")
    public Optional<SysPermission> getPermissionById(@PathVariable String id) {
        return sysPermissionService.findOneById(Long.valueOf(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "根据id删除权限")
    public void deletePermission(@PathVariable String id) {
        sysPermissionService.deleteOneById(Long.valueOf(id));
    }
}
