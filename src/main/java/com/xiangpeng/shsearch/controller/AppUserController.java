package com.xiangpeng.shsearch.controller;

import com.xiangpeng.shsearch.entities.AppUser;
import com.xiangpeng.shsearch.service.AppUserService;
import com.xiangpeng.shsearch.tools.Result;
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
    public Result getUserById(@PathVariable("id")Long id){
        AppUser aUser = appUserService.getUserById(id);
        return Result.success(aUser);
    }
}
