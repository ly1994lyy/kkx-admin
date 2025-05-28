package org.kkx.service;

import org.kkx.entity.SysRole;
import org.kkx.repository.SysRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SysRoleService implements BaseService<SysRole> {
    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Override
    public Page<SysRole> findAll(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return sysRoleRepository.findAll(pageRequest);
    }

    @Override
    public SysRole createOne(SysRole sysRole) {
        return sysRoleRepository.save(sysRole);
    }

    @Override
    public SysRole updateOne(SysRole sysRole) {
        Optional<SysRole> role = findOneById(sysRole.getRoleId());
        role.ifPresent(value -> sysRole.setRoleId(value.getRoleId()));
        return  sysRoleRepository.save(sysRole);
    }

    @Override
    public void deleteOneById(Long id) {
        sysRoleRepository.deleteById(id);
    }

    @Override
    public Optional<SysRole> findOneById(Long id) {
        return sysRoleRepository.findById(id);
    }

}
