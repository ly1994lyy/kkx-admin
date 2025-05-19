package org.kkx.service;

import org.kkx.entity.SysMenu;
import org.kkx.repository.SysMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SysMenuService {
    @Autowired
    private SysMenuRepository sysMenuRepository;

    public Page<SysMenu> findAll(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return sysMenuRepository.findAll(pageRequest);
    }
}
