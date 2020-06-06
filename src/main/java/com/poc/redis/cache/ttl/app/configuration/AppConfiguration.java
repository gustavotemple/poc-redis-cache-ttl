package com.poc.redis.cache.ttl.app.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

import java.time.Duration;

@EnableCaching
@Configuration
public class AppConfiguration {

    @Primary
    @Bean
    public RedisCacheManager cacheManager(final RedisConnectionFactory connectionFactory) {
        final RedisCacheWriter redisCacheWriter = RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
        final SerializationPair valueSerializationPair = SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());

        final RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration
                .defaultCacheConfig()
                .disableCachingNullValues()
                .serializeValuesWith(valueSerializationPair);

        return RedisCacheManager.builder(redisCacheWriter)
                .cacheDefaults(cacheConfiguration)
                .transactionAware()
                .build();

    }

    @Bean(name = "myCacheManager1")
    public RedisCacheManager myCacheManager1(final RedisConnectionFactory connectionFactory) {
        final RedisCacheWriter redisCacheWriter = RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
        final SerializationPair valueSerializationPair = SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());

        final RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration
                .defaultCacheConfig()
                .disableCachingNullValues()
                .entryTtl(Duration.ofMinutes(1))
                .serializeValuesWith(valueSerializationPair);

        return RedisCacheManager.builder(redisCacheWriter)
                .cacheDefaults(cacheConfiguration)
                .transactionAware()
                .build();
    }

    @Bean(name = "myCacheManager2")
    public RedisCacheManager myCacheManager2(final RedisConnectionFactory connectionFactory) {
        final RedisCacheWriter redisCacheWriter = RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
        final SerializationPair valueSerializationPair = SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());

        final RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration
                .defaultCacheConfig()
                .disableCachingNullValues()
                .entryTtl(Duration.ofSeconds(50))
                .serializeValuesWith(valueSerializationPair);

        return RedisCacheManager.builder(redisCacheWriter)
                .cacheDefaults(cacheConfiguration)
                .transactionAware()
                .build();
    }

}
