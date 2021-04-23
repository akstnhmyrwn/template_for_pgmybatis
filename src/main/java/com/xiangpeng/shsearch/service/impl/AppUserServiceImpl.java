package com.xiangpeng.shsearch.service.impl;

import com.xiangpeng.shsearch.dao.AppUserMapper;
import com.xiangpeng.shsearch.entities.AppUser;
import com.xiangpeng.shsearch.service.AppUserService;
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
