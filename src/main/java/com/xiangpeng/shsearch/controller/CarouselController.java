package com.xiangpeng.shsearch.controller;

import com.xiangpeng.shsearch.entities.AppUser;
import com.xiangpeng.shsearch.entities.Carousel;
import com.xiangpeng.shsearch.tools.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("carouse")
public class CarouselController {

    @GetMapping
    @ResponseBody
    public Result<Collection> getCarouses(){
        List carouses = new ArrayList<String>();
        carouses.add("https://www.baidu.com");

        Carousel carousel = new Carousel();
        return Result.success(carouses);
    }

}
