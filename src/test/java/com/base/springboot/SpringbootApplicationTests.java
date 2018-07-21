package com.base.springboot;

import com.base.springboot.mapper.UserDao;
import com.base.springboot.model.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

	@Autowired
	private UserDao userDao;


	// 字符串类型
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	// key-values
	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 保存对象序列化默认使用jdk的序列化工具
	 *
	 */
	@Test
	public void testRedisCaache() {
		stringRedisTemplate.opsForValue().append("springboot-test1","testmessage");
		String meaasge = stringRedisTemplate.opsForValue().get("springboot-test1");
		System.out.println(meaasge);

		List<UserVO> list = userDao.getList();
		redisTemplate.opsForValue().set("testlist",list);

		System.out.println(redisTemplate.opsForValue().get("testlist"));

	}




}
