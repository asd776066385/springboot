package com.base.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/***
 * 1.MapperScan配置扫描接口的位置
 * 2.EnableCaching 开启基于注解的缓存
 */
@MapperScan("com.base.springboot.mapper")
@EnableCaching
@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
