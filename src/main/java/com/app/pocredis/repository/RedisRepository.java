package com.app.pocredis.repository;

import com.app.pocredis.dto.Student;

import java.util.Map;

public
interface RedisRepository {
    Map <String, Student > findAll();
    Student findById(String id);
    void save(Student student);
    void delete(String id);
}
