package com.dusknode.services;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageSender {

   @Bean
   JedisConnectionFactory connectionFactory() {
     return new JedisConnectionFactory();
   }

   @Bean
   StringRedisTemplate template(JedisConnectionFactory connectionFactory) {
     return new StringRedisTemplate(connectionFactory);
   }

   private static StringRedisTemplate template() {
     AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MessageSender.class);
     return ctx.getBean(StringRedisTemplate.class);
   }

   public static boolean queueObject(String queue,String content) {
     template().boundListOps(queue).rightPush(content);
     return true;
   }

   public static boolean publishMessage(String channel,String content) {
     template().convertAndSend(channel,content);
     return true;
   }

   public static String popObject(String queue) {
     return template().boundListOps(queue).leftPop();
   }
}
