package com.base.springboot;

import com.base.springboot.mapper.UserDao;
import com.base.springboot.model.UserVO;
import org.assertj.core.util.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	/**RabbitMQ*/
	@Autowired
	private RabbitTemplate rabbitTemplate;


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


	@Test
	public void testSendRabbitMq(){
		Map<String,String> map = new HashMap<>();
		map.put("asd","123");
		map.put("qwe","456");
		rabbitTemplate.convertAndSend("test.direct","test.direct.queues",map);
		rabbitTemplate.convertAndSend("test.direct","test.direct.queues1",map);
	}

	@Test
	public void testGetRabbitMq(){
		Object o = rabbitTemplate.receiveAndConvert("test.direct.queues");
		System.out.println(o.getClass());
		System.out.println(o);
	}


}
