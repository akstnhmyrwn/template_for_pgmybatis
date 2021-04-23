package com.xiangpeng.shsearch;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiangpeng.shsearch.dao")
public class BootStarter {

    public static void main(String[] args) {
        SpringApplication.run(BootStarter.class, args);
    }

}
