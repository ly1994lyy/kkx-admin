package org.kkx.controller;

import jakarta.websocket.server.PathParam;
import org.kkx.entity.SysRole;
import org.kkx.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("role")
    public Page<SysRole> getRoles(@PathParam("page") int page,@PathParam("size") int size) {
        return sysRoleService.findAll(page,size);
    }
}
