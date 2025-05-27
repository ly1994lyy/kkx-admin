package org.kkx.service;

import org.kkx.repository.SysPermissionRepository;
import org.kkx.entity.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SysPermissionService {
    @Autowired
    private SysPermissionRepository sysPermissionRepository;

    public Page<SysPermission> findAll(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return sysPermissionRepository.findAll(pageRequest);
    }
}
