package edu.hawaii.its.api.configuration;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
                new ConcurrentMapCache("default"),
                new ConcurrentMapCache("campusesAll"),
                new ConcurrentMapCache("campusesActualAll"),
                new ConcurrentMapCache("campusesById"),
                new ConcurrentMapCache("messages")));
        return cacheManager;
    }

}
