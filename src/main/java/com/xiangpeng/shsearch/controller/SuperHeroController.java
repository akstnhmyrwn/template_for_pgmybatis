package com.xiangpeng.shsearch.controller;

import com.xiangpeng.shsearch.entities.SuperHeroHot;
import com.xiangpeng.shsearch.entities.SuperHeroTrailer;
import com.xiangpeng.shsearch.tools.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("superhero")
public class SuperHeroController {

    @GetMapping("/{type}")
    @ResponseBody
    public Result<Object> getCarouses(@PathVariable("type") String type){
        switch (type){
            case "hot":
                return Result.success(new SuperHeroHot().findModels());
            case "trailer":
                return Result.success(new SuperHeroTrailer().findModels());
            default:
                return Result.failMsg("参数错误，未找到对应的结果");
        }

    }
}
