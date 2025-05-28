package org.kkx.service;

import org.kkx.entity.SysDept;
import org.kkx.repository.SysDeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SysDeptService implements BaseService<SysDept> {
    @Autowired
    private SysDeptRepository sysDeptRepository;

    @Override
    public Page<SysDept> findAll(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return sysDeptRepository.findAll(pageRequest);
    }

    @Override
    public SysDept createOne(SysDept sysDept) {
        return sysDeptRepository.save(sysDept);
    }

    @Override
    public SysDept updateOne(SysDept sysDept) {
        Optional<SysDept> dept = findOneById(sysDept.getDeptId());
        dept.ifPresent(value -> sysDept.setDeptId(value.getDeptId()));
        return  sysDeptRepository.save(sysDept);
    }

    @Override
    public Optional<SysDept> findOneById(Long id) {
        return sysDeptRepository.findById(id);
    }

    @Override
    public void deleteOneById(Long id) {
        sysDeptRepository.deleteById(id);
    }

}
