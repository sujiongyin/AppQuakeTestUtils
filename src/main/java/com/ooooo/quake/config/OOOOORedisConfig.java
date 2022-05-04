package com.ooooo.quake.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis
 */
@Configuration
public class OOOOORedisConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.redis.user")
    public RedisStandaloneConfiguration userRedisConfig() {
        return new RedisStandaloneConfiguration();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.redis.order")
    public RedisStandaloneConfiguration orderRedisConfig() {
        return new RedisStandaloneConfiguration();
    }

    @Bean("userFactory")
    @Primary
    public LettuceConnectionFactory factory() {
        return new LettuceConnectionFactory(userRedisConfig());
    }

    @Bean("orderFactory")
    public LettuceConnectionFactory factory2() {
        return new LettuceConnectionFactory(orderRedisConfig());
    }


    @Bean("userRedisTemplate")
    @Primary
    public RedisTemplate<String, String> userRedisTemplate(@Qualifier("userFactory") RedisConnectionFactory userFactory) {
        return getStringStringRedisTemplate(userFactory);
    }

    @Bean("orderRedisTemplate")
    public RedisTemplate<String, String> orderRedisTemplate(@Qualifier("orderFactory") RedisConnectionFactory orderFactory) {
        return getStringStringRedisTemplate(orderFactory);
    }

    @Autowired(required = false)
    private RedisTemplate<String, String> getStringStringRedisTemplate(RedisConnectionFactory factory2) {
        StringRedisTemplate template = new StringRedisTemplate(factory2);
        RedisSerializer stringSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringSerializer);
        template.setValueSerializer(stringSerializer);
        template.setHashKeySerializer(stringSerializer);
        template.setHashValueSerializer(stringSerializer);
        return template;
    }

    @Autowired
    private RedisTemplate redisTemplate;

}
