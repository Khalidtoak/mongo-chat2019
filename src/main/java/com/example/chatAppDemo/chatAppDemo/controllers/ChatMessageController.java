package com.example.chatAppDemo.chatAppDemo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatAppDemo.chatAppDemo.models.Channel;
import com.example.chatAppDemo.chatAppDemo.models.Message;
import com.example.chatAppDemo.chatAppDemo.repos.ChatChannelRepo;
import com.example.chatAppDemo.chatAppDemo.repos.ChatMessageRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpStatus;

@RestController
public class ChatMessageController {
	@Autowired
	ChatChannelRepo chatChannelRepo;
	@Autowired
	ChatMessageRepo chatMessageRepo;
	@PostMapping("/chats")
	 @ResponseStatus(HttpStatus.CREATED)
	public void postChat(@Valid @RequestBody Message chatMessage){	
		 //chatMessageRepo.save(chatMessage).subscribe();
		 chatMessageRepo.insert(chatMessage).subscribe();
	}
	@PostMapping("/channels")
	public Mono<Channel> createChannel(@Valid @RequestBody Channel channel){
		return chatChannelRepo.save(channel);
	}
	@GetMapping(value = "/chats/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Message> streamMessages(@RequestParam String channelId){
		return chatMessageRepo.findWithTailableCursorByChannelId(channelId);
	}
	//5cf301f5a4972f6be462aeba
	//5cf30217a4972f6be462aebb
	//5cf302caa4972f6be462aebe
	/**"message":"Duuh sha  hkjkkkkuiyhjhmg",
	"sender" :"5cf294307b4f31fba4906ea4" ,
	"sendee" : "5cf2945b7b4f31fba4906ea5",
	"channelId": "5cf295f57b4f3103243cef09"**/
}
