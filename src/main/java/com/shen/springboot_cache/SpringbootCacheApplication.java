package com.shen.springboot_cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

/**
 *
 * 整合mybatis
 *  配置数据源
 *  使用注解版的mybatis
 *     @MapperScan 需要扫描的mapper接口所在的包
 *
 * 使用缓存
 *   开启基于注解的缓存 @EnableCaching
 *   标注缓存注解即可
 *
 *      @Cacheable
 *      @CacheEvict
 *      @CachePut
 *
 * 整合reids
 */


@MapperScan("com.shen.springboot_cache.mapper")
@SpringBootApplication
@EnableCaching
public class SpringbootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCacheApplication.class, args);
    }

}
