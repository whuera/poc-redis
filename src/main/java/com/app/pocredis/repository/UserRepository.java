package com.app.pocredis.repository;

import com.app.pocredis.dto.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.UUID;

@Repository
public class UserRepository implements RedisRepository {
    private static final String KEY = "User";

    private RedisTemplate<String, User > redisTemplate;
    private HashOperations hashOperations;

    public
    UserRepository (RedisTemplate<String, User > redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<String, User > findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public
    User findById(String id) {
        return (User) hashOperations.get( KEY, id);
    }

    @Override
    public void save(User user) {
        hashOperations.put( KEY, UUID.randomUUID().toString(), user );
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY, id);
    }
}
