package com.it.shiro.controller;

import com.it.shiro.mapper.Sys_usersMapper;
import com.it.shiro.pojo.Sys_users;
import com.it.shiro.service.Sys_usersService;
import com.it.shiro.utils.result.JsonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author 王文龙
 * @Date 2019-11-27 17:05
 */
@RestController
@RequestMapping("/sys_users")
public class Sys_usersController {

    @Resource
    private Sys_usersService sys_usersService;
    @Resource
    private Sys_usersMapper sys_usersMapper;

    @RequestMapping("/insert")
    public JsonResult insert(@RequestBody Sys_users sys_users) {
        try {
            boolean insert = sys_usersService.insert(sys_users);
            if (insert) {
                return new JsonResult<>(201, "新增用户成功", true, 1);
            } else {
                return new JsonResult<>(110, "新增用户失败", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult<>(120, "信息失败", false);
        }
    }


}
