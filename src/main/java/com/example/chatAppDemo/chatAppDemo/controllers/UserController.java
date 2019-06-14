package com.example.chatAppDemo.chatAppDemo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatAppDemo.chatAppDemo.models.User;
import com.example.chatAppDemo.chatAppDemo.repos.UserRepo;

import reactor.core.publisher.Mono;

@RestController
public class UserController {
	@Autowired 
	UserRepo userRepo;
	@PostMapping("/users")
	public Mono<User> saveUser(@Valid @RequestBody User user){
		return userRepo.save(user);
	}
	@GetMapping("/user/{id}")
	public Mono<ResponseEntity<User>> getUserById(@PathVariable String id){
		return userRepo.findById(id).map(savedUser -> ResponseEntity.ok(savedUser))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
}
