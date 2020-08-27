package com.dyn.springbootdemo.dao;

import com.dyn.springbootdemo.entity.TUserDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<TUserDO,Integer> {
}
