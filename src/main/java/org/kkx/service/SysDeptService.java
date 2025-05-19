package org.kkx.service;

import org.kkx.entity.SysDept;
import org.kkx.entity.SysMenu;
import org.kkx.repository.SysDeptRepository;
import org.kkx.repository.SysMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SysDeptService {
    @Autowired
    private SysDeptRepository sysDeptRepository;

    public Page<SysDept> findAll(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return sysDeptRepository.findAll(pageRequest);
    }

    public SysDept saveDept(SysDept sysDept) {
        return sysDeptRepository.save(sysDept);
    }
}
