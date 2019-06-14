package com.example.chatAppDemo.chatAppDemo.repos;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;

import com.example.chatAppDemo.chatAppDemo.models.Message;

import reactor.core.publisher.Flux;
@Repository
public interface ChatMessageRepo extends ReactiveMongoRepository<Message, String> {
	@Tailable
	public Flux<Message> findWithTailableCursorByChannelId(String channelId);
}
