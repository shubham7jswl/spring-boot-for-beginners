package com.sj.springbootforbeginners.repository;

import com.sj.springbootforbeginners.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    
    @Query("{name:'?0'}")
    User findItemByName(String name);
    
    @Query(value="{city:'?0'}", fields="{'name' : 1, 'phoneNumber' : 1}")
    List<User> findAll(String category);
    
    public long count();

}