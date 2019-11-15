package com.shen.springboot_cache.config;


import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;


@Configuration
public class CacheConfig {



    @Bean("myGenerator")
    public KeyGenerator setKeyGenertor(){
        return  new KeyGenerator(){
            @Override
            public Object generate(Object target, Method method, Object... params) {
                System.out.println("这里是自定义的keyGenerator");
                return params[0];
            }
        };
    }

}
