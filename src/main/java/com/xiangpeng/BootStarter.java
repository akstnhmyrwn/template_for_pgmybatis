package com.xiangpeng;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiangpeng.dao")
public class BootStarter {

    public static void main(String[] args) {
        SpringApplication.run(BootStarter.class, args);
    }

}
