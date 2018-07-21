package com.base.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/***
 * 1.MapperScan 基于注解的接口的位置扫描
 * 2.EnableCaching 基于注解的缓存
 * 3.EnableRabbit 基于注解的消息(监听)
 * 4.EnableAsync 基于注解的异步任务
 * 5.EnableScheduling 基于注解的定时任务
 */
@MapperScan("com.base.springboot.mapper")
@EnableCaching
@EnableRabbit
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
