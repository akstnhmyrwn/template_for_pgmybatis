package com.xiangpeng.service.impl;

import com.xiangpeng.dao.AppUserMapper;
import com.xiangpeng.entities.AppUser;
import com.xiangpeng.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    public AppUserMapper appUserMapper;

    @Override
    public AppUser getUserById(Long id) {
        return appUserMapper.selectByPrimaryKey(id);
    }
}
