package com.it.shiro.service.impl;

import com.it.shiro.mapper.Sys_permissionMapper;
import com.it.shiro.pojo.Sys_permissions;
import com.it.shiro.service.Sys_permissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author 王文龙
 * @Date 2019-11-27 09:54
 */
@Service
public class Sys_permissionServiceImpl implements Sys_permissionService {

    @Resource
    private Sys_permissionMapper sys_permissionMapper;


    /**
     * 删除
     *
     * @param sys_permissions 实体
     * @return true/false
     */
    @Override
    public boolean insert(Sys_permissions sys_permissions) {
        return sys_permissionMapper.insert(sys_permissions);
    }

    @Override
    public boolean delete(Integer id) {
        return sys_permissionMapper.delete(id);
    }
}
