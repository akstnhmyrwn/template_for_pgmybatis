package com.xiangpeng.shsearch.entities;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xiangpeng.shsearch.tools.RecursionUtils;
import com.xiangpeng.shsearch.tools.UtilHandler;
import lombok.Data;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Component
public class BaseEntity implements Serializable {
    public static final Map<String,Object> dataMode;

    static {
        /* 容器初始化 */
        dataMode = new HashMap<>();

        /* 读取配置文件内容 */
        final String classNameChar = "#class:";
        final String jsonStartChar = "#jsonStart";
        final String jsonEndChar = "#jsonEnd";

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        Map<String,String> dataCache = new HashMap<>();
        try {
            Resource[] resources = resolver.getResources("classpath:DataModel");

            for (int i = 0 ;i<resources.length;i++){

                RecursionUtils.recursionFolder(resources[i].getFile(), new UtilHandler() {
                    @Override
                    public void doHadnle(Object[] params) throws Exception {
                        File f = (File)params[0];
                        BufferedReader br = new BufferedReader(new java.io.FileReader(f));

                        String s = null;
                        boolean jsonStart = false;
                        boolean jsonEnd = false;
                        String className = null;
                        StringBuffer sf = new StringBuffer();
                        while((s = br.readLine())!=null){
                            if("".equals(s)&&null == s){
                                continue;
                            }
                            if(s.startsWith(classNameChar)){
                                className = s.substring(classNameChar.length()).trim();
                                continue;
                            }
                            if(s.startsWith(jsonStartChar)){
                                jsonStart = (!jsonEnd)&&true;
                                continue;
                            }
                            if(s.startsWith(jsonEndChar)){
                                jsonEnd = jsonStart&&true;
                                continue;
                            }

                            if(jsonStart&&(!jsonEnd)){
                                sf.append(s);
                            }
                        }
                        dataCache.put(className,sf.toString().trim());

                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* 解析 */

        for (Map.Entry<String,String> entry:dataCache.entrySet()) {
            String className = entry.getKey();

            String value = entry.getValue();


            try {
                Class clazz = Class.forName(className);
                if(value.startsWith("{")){
                    Object objectVlue = JSONObject.parseObject(value,clazz);
                    dataMode.put(className,objectVlue);
                }else if(value.startsWith("[")){
                    List<?> objects = JSONArray.parseArray(value, clazz);
                    dataMode.put(className,objects);
                }
            } catch (ClassNotFoundException e) {
                System.err.println(e.getMessage());
            }
        }

    }



    public Object findModels(){
        return dataMode.get(this.getClass().getName());
    }
}
