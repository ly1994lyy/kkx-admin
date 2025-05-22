package org.kkx.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.kkx.entity.SysDept;
import org.kkx.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Tag(name = "部门模块")
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;

    @GetMapping("dept")
    @Operation(summary = "获取部门列表")
    public Page<SysDept> getRoles(@PathParam("page") int page, @PathParam("size") int size) {
        return sysDeptService.findAll(page,size);
    }

    @PostMapping("dept")
    @Operation(summary = "新建部门")
    public SysDept saveRole(@RequestBody SysDept dept) {
        return sysDeptService.saveDept(dept);
    }

    @GetMapping("/dept/{id}")
    @Operation(summary = "根据ID查询部门详情")
    public Optional<SysDept> getRoles(@PathVariable String id) {
        return sysDeptService.findOne(Long.valueOf(id));
    }
}
