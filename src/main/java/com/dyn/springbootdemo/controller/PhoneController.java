package com.dyn.springbootdemo.controller;

import com.dyn.springbootdemo.dao.PhoneDao;
import com.dyn.springbootdemo.dao.UserDao;
import com.dyn.springbootdemo.entity.PhoneDO;
import com.dyn.springbootdemo.entity.TUserDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/")
@Api(tags = "Phone管理相关接口")
public class PhoneController {



    @Resource
    PhoneDao phoneDao;

    @PostMapping("/addPhone")
    @ApiOperation("添加addPhone")
    public Boolean addPhone(@RequestBody PhoneDO phoneDO){

        PhoneDO save = phoneDao.save(phoneDO);

        return true;
    }

    @GetMapping("/queryPhone")
    @ApiOperation("根据id查询phone的接口")
    public PhoneDO queryPhone(String phoneId){
        PhoneDO phoneDO = phoneDao.findById(phoneId).get();
        return phoneDO;
    }
}
