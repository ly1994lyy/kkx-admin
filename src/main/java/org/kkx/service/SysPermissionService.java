package org.kkx.service;

import org.kkx.repository.SysPermissionRepository;
import org.kkx.entity.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SysPermissionService implements BaseService<SysPermission> {

    @Autowired
    private SysPermissionRepository sysPermissionRepository;

    public Page<SysPermission> findAll(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return sysPermissionRepository.findAll(pageRequest);
    }

    @Override
    public SysPermission createOne(SysPermission sysPermission) {
        return sysPermissionRepository.save(sysPermission);
    }

    @Override
    public SysPermission updateOne(SysPermission sysPermission) {
        Optional<SysPermission> permission = findOneById(sysPermission.getPermissionId());
        permission.ifPresent(value -> sysPermission.setPermissionId(value.getPermissionId()));
        return  sysPermissionRepository.save(sysPermission);
    }

    @Override
    public void deleteOneById(Long id) {
        sysPermissionRepository.deleteById(id);
    }

    @Override
    public Optional<SysPermission> findOneById(Long id) {
        return sysPermissionRepository.findById(id);
    }


}
