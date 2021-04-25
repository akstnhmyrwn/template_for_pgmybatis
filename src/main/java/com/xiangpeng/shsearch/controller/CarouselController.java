package com.xiangpeng.shsearch.controller;

import com.xiangpeng.shsearch.entities.AppUser;
import com.xiangpeng.shsearch.entities.Carousel;
import com.xiangpeng.shsearch.tools.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carouse")
public class CarouselController {

    @GetMapping
    @ResponseBody
    public Result<Object> getCarouses(){
        Carousel carousel = new Carousel();
        return Result.success(carousel.findModels());
    }
    @GetMapping("getUsers")
    @ResponseBody
    public Result<Object> getUsers(){
        AppUser appUser = new AppUser();
        return Result.success(appUser.findModels());
    }
}
