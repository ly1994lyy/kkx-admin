package org.kkx.service;

import org.kkx.entity.SysUser;
import org.kkx.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {
    @Autowired
    private SysUserRepository sysUserRepository;

    public Page<SysUser> findAll(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return sysUserRepository.findAll(pageRequest);
    }

    public SysUser saveDept(SysUser sysUser) {
        return sysUserRepository.save(sysUser);
    }
}
