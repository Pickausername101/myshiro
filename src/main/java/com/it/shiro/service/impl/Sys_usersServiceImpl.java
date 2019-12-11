package com.it.shiro.service.impl;

import com.it.shiro.mapper.Sys_usersMapper;
import com.it.shiro.mapper.Sys_users_rolesMapper;
import com.it.shiro.pojo.Sys_users;
import com.it.shiro.service.Sys_usersService;
import com.it.shiro.PasswordHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @Author 王文龙
 * @Date 2019-11-27 15:47
 */
@Service
public class Sys_usersServiceImpl implements Sys_usersService {

    @Resource
    private Sys_usersMapper sys_usersMapper;
    @Resource
    private PasswordHelper passwordHelper;
    @Resource
    private Sys_users_rolesMapper sys_users_rolesMapper;

    /**
     * 创建账户
     *
     * @param sys_users 用户表
     * @return true/false
     */
    @Override
    public boolean insert(Sys_users sys_users) {
        //加密密码
        passwordHelper.encryptPassword(sys_users);
        return sys_usersMapper.insert(sys_users);
    }

    /**
     * 修改密码
     *
     * @param id          主键id
     * @param newPassword 密码
     * @return true/false
     */
    @Override
    public boolean changePassword(Integer id, String newPassword) {
        Sys_users sys_users = sys_usersMapper.findById(id);
        sys_users.setPassword(newPassword);
        passwordHelper.encryptPassword(sys_users);
        return sys_usersMapper.update(sys_users);
    }

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return Sys_users
     */
    @Override
    public Sys_users findByUsername(String username) {
        return sys_usersMapper.findByUsername(username);
    }

    /**
     * 添加用户-角色关系
     *
     * @param userId  用户id
     * @param roleIds 角色id
     * @return true/false
     */
    @Override
    public boolean correlationRoles(Integer userId, Integer roleIds) {
        return sys_users_rolesMapper.correlationRoles(userId,roleIds);
    }

    /**
     * 移除用户-角色关系
     *
     * @param userId  用户id
     * @param roleIds 角色id
     * @return true/false
     */
    @Override
    public boolean uncorrelationRoles(Integer userId, Integer roleIds) {
        return sys_users_rolesMapper.uncorrelationRoles(userId, roleIds);
    }

    /**
     * 根据用户名查找其角色
     *
     * @param username 用户名
     * @return []
     */
    @Override
    public Set<String> findRoles(String username) {
        return sys_users_rolesMapper.findRoles(username);
    }

    /**
     * 根据用户名查找其权限
     *
     * @param username 用户名
     * @return []
     */
    @Override
    public Set<String> findPermissions(String username) {
        return sys_users_rolesMapper.findPermissions(username);
    }
}
