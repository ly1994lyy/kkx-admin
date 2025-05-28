package org.kkx.service;

import org.kkx.entity.SysUser;
import org.kkx.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SysUserService implements BaseService<SysUser> {
    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public Page<SysUser> findAll(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return sysUserRepository.findAll(pageRequest);
    }

    @Override
    public SysUser createOne(SysUser sysUser) {
        return sysUserRepository.save(sysUser);
    }

    @Override
    public SysUser updateOne(SysUser sysUser) {
        Optional<SysUser> user = findOneById(sysUser.getUserId());
        user.ifPresent(value -> sysUser.setUserId(value.getUserId()));
        return  sysUserRepository.save(sysUser);
    }

    @Override
    public void deleteOneById(Long id) {
        sysUserRepository.deleteById(id);
    }

    @Override
    public Optional<SysUser> findOneById(Long id) {
        return sysUserRepository.findById(id);
    }

}
