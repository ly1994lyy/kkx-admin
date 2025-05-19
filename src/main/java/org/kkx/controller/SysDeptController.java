package org.kkx.controller;

import jakarta.websocket.server.PathParam;
import org.kkx.entity.SysDept;
import org.kkx.entity.SysRole;
import org.kkx.service.SysDeptService;
import org.kkx.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;

    @GetMapping("dept")
    public Page<SysDept> getRoles(@PathParam("page") int page, @PathParam("size") int size) {
        return sysDeptService.findAll(page,size);
    }

    @PostMapping("dept")
    public SysDept saveRole(@RequestBody SysDept dept) {
        return sysDeptService.saveDept(dept);
    }
}
