package com.dyn.springbootdemo.controller;

import com.dyn.springbootdemo.dao.UserDao;
import com.dyn.springbootdemo.entity.TUserDO;
import com.dyn.springbootdemo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/")
@Api(tags = "用户管理相关接口")
public class UserController {

    @Resource
    UserDao userDao;

    @Resource
    IUserService userService;

    @GetMapping("/test")
    @ApiOperation("根据id查询用户的接口")
    public TUserDO home() {
        TUserDO tUserEntity = new TUserDO();
        tUserEntity.setfName("aaa");
        tUserEntity.setfPassword("123");
        tUserEntity.setPkUid(1);
        return tUserEntity;
    }

    @GetMapping("/addUser")
    @ApiOperation("添加user")
    public Boolean addUser(TUserDO userDO){

//        TUserDO save = userDao.save(userDO);

        userService.addUser(userDO);
        return true;
    }

    @GetMapping("/queryUser")
    @ApiOperation("根据id查询用户的接口")
    public TUserDO queryUser(Integer userId){
        TUserDO tUserDO = userDao.findById(userId).get();
        return tUserDO;
    }
}
