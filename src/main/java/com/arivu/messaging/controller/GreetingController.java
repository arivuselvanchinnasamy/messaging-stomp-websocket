package com.arivu.messaging.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.arivu.messaging.model.Greeting;
import com.arivu.messaging.model.Message;

@Controller
public class GreetingController {
	@MessageMapping("/message")
	@SendTo("/topic/greetings")
	public Greeting greeting(Message message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return new Greeting("Hello, " + message.getName() + "!");
	}
}
