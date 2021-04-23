package com.xiangpeng.controller;

import com.xiangpeng.entities.AppUser;
import com.xiangpeng.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app_user")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;


    @GetMapping("/getUserById/{id}")
    public String getUserById(@PathVariable("id")Long id){
        AppUser aUser = appUserService.getUserById(id);
        return aUser.toString();
    }
}
