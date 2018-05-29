package com.xxwy.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.*;


/**
 * 1.开启注解缓存
 * 2.标记缓存注解ok
 *  @EnableCaching ；开启注解缓存
 *  @Cacheable   ：某一个方法是可以缓存的
 *  @CacheConfig ：
 *	@CacheEvict :缓存清除
 *	@CachePut
 *	@Caching
 *
 */


@MapperScan(value = "com.xxwy.cache.mapper")
@SpringBootApplication
@EnableCaching
public class Springboot01CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot01CacheApplication.class, args);
	}
}
