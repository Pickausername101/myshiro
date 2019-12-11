package com.it.shiro.service;

import com.it.shiro.pojo.Sys_permissions;

/**
 * @Author 王文龙
 * @Date 2019-11-27 09:52
 */
public interface Sys_permissionService {

    /**
     * 删除
      * @param sys_permissions 实体
     * @return true/false
     */
    boolean insert(Sys_permissions sys_permissions);


    /**
     * 删除
     * @param id 主键
     * @return true/false
     */
    boolean delete(Integer id);
}
