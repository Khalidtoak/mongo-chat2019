package com.example.chatAppDemo.chatAppDemo.repos;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.chatAppDemo.chatAppDemo.models.User;
@Repository
public interface UserRepo extends ReactiveMongoRepository<User, String>{
	
}
