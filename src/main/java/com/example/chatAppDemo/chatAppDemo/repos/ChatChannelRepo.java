package com.example.chatAppDemo.chatAppDemo.repos;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.chatAppDemo.chatAppDemo.models.Channel;

public interface ChatChannelRepo extends ReactiveMongoRepository<Channel, String>{

}
