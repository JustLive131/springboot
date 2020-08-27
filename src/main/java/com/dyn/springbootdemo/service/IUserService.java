package com.dyn.springbootdemo.service;

import com.dyn.springbootdemo.entity.TUserDO;
import org.apache.catalina.User;

public interface IUserService {

    boolean addUser(TUserDO userDO);

    boolean deleteUser(Integer userId);
}
