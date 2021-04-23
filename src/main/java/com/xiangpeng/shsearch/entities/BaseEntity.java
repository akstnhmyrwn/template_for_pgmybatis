package com.xiangpeng.shsearch.entities;

import lombok.Data;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class BaseEntity implements Serializable {
    public static final Map<String,Object> dataMode;

    static {
        dataMode = new HashMap<>();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] resources = resolver.getResources("classpath:DataModel");

            System.out.println(resources.length);

            for (int i = 0 ;i<resources.length;i++){
                InputStream inputStream = resources[i].getInputStream();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void getClassName(){
        System.out.println(this.getClass().getTypeName());
    }
}
