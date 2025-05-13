package org.kkx.service;

import org.kkx.entity.SysRole;
import org.kkx.repository.SysRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class SysRoleService {
    @Autowired
    private SysRoleRepository sysRoleRepository;

    public Page<SysRole> findAll(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return sysRoleRepository.findAll(pageRequest);
    }
}
