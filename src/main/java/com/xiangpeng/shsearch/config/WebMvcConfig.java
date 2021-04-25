package com.xiangpeng.shsearch.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /***
     * 解决fastjson返回结果出错的问题
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 1.定义一个converters转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        // 2.添加fastjson的配置信息，比如: 是否需要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
        // 3.配置选用
        fastJsonConfig.setSerializerFeatures(
                // 输出格式整理
                SerializerFeature.PrettyFormat,
                // 输出key时是否使用双引号
                SerializerFeature.QuoteFieldNames,
                // 是否输出值为null的字段
                SerializerFeature.WriteMapNullValue,
                // List字段如果为null,输出为[],而非null
                SerializerFeature.WriteNullListAsEmpty,
                // 字符类型字段如果为null,输出为”“,而非null
                SerializerFeature.WriteNullStringAsEmpty,
                // 数字类型字段如果为null,输出为0,而非null
                SerializerFeature.WriteNullNumberAsZero

        );
        // 4.在converter中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        // 5.将converter赋值给HttpMessageConverter
        HttpMessageConverter<?> converter = fastConverter;
        // 6.返回HttpMessageConverters对象
        return new HttpMessageConverters(converter);
    }

    /***
     * 解决跨域问题
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST","GET","PUT","DELETE")
                .allowedHeaders("*")
                .exposedHeaders(
                        "access-control-allow-headers",
                        "access-control-allow-methods",
                        "access-control-allow-origin",
                        "access-control-max-age",
                        "X-Token"
                )
                .allowCredentials(false)
                .maxAge(3600);
    }

}
