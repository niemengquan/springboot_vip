package com.tuling;

import com.tuling.support.anno.EnableAngleDistributedTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@SpringBootApplication
@Slf4j
@EnableAngleDistributedTransactional
public class AngleProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngleProductApplication.class, args);
	}

	@Bean
	public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		log.info("加载RedisTemplate到容器中");
		RedisTemplate<Object, Object> template = new RedisTemplate<>();
		template.setDefaultSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}

}
