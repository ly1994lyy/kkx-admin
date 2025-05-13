package org.kkx.repository;

import org.kkx.entity.SysUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SysUserRepository extends PagingAndSortingRepository<SysUser, Integer> {
}