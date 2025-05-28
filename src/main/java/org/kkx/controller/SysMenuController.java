package org.kkx.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.kkx.entity.SysMenu;
import org.kkx.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Tag(name = "菜单模块")
@RequestMapping("menu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("")
    @Operation(summary = "分页查询菜单")
    public Page<SysMenu> getMenus(@PathParam("page") int page, @PathParam("size") int size) {
        return sysMenuService.findAll(page,size);
    }

    @PostMapping("")
    @Operation(summary = "新增菜单")
    public SysMenu save(SysMenu sysMenu) {
        return sysMenuService.createOne(sysMenu);
    }
    
    @PutMapping("")
    @Operation(summary = "更新菜单")
    public SysMenu update(SysMenu sysMenu) {
        return sysMenuService.updateOne(sysMenu);
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据ID查询菜单详情")
    public Optional<SysMenu> getMenuById(@PathVariable String id) {
        return sysMenuService.findOneById(Long.valueOf(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "根据id删除菜单")
    public void deleteMenu(@PathVariable String id) {
        sysMenuService.deleteOneById(Long.valueOf(id));
    }
    
}
