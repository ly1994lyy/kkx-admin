package org.kkx.service;

import org.kkx.entity.SysDept;
import org.kkx.entity.SysMenu;
import org.kkx.repository.SysMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SysMenuService implements BaseService<SysMenu> {
    @Autowired
    private SysMenuRepository sysMenuRepository;

    public Page<SysMenu> findAll(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return sysMenuRepository.findAll(pageRequest);
    }

    @Override
    public SysMenu createOne(SysMenu sysMenu) {
        return sysMenuRepository.save(sysMenu);
    }

    @Override
    public SysMenu updateOne(SysMenu sysMenu) {
        Optional<SysMenu> menu = findOneById(sysMenu.getMenuId());
        menu.ifPresent(value -> sysMenu.setMenuId(value.getMenuId()));
        return  sysMenuRepository.save(sysMenu);
    }

    @Override
    public void deleteOneById(Long id) {
        sysMenuRepository.deleteById(id);
    }

    @Override
    public Optional<SysMenu> findOneById(Long id) {
        return sysMenuRepository.findById(id);
    }
}
