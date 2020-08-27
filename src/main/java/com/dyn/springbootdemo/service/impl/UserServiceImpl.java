package com.dyn.springbootdemo.service.impl;

import com.dyn.springbootdemo.dao.UserDao;
import com.dyn.springbootdemo.entity.TUserDO;
import com.dyn.springbootdemo.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    UserDao userDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addUser(TUserDO userDO) {
        TUserDO tUserDO = new TUserDO();
        tUserDO.setfName("testUser");
        userDao.save(userDO);
        this.deleteUser(1);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public    boolean deleteUser(Integer userId) {
        userDao.deleteById(userId);
            throw new RuntimeException();

    }
}
