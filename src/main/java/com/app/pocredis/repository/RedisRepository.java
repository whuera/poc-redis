package com.app.pocredis.repository;

import com.app.pocredis.dto.User;

import java.util.Map;

public
interface RedisRepository {
    Map <String, User > findAll();
    User findById(String id);
    void save(User user);
    void delete(String id);
}
