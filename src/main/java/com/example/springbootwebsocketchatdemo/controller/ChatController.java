package com.example.springbootwebsocketchatdemo.controller;

import com.example.springbootwebsocketchatdemo.model.ChatMessage;
import com.example.springbootwebsocketchatdemo.model.ChatMessageWithTime;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private ModelMapper modelMapper;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessageWithTime sendMessage(@Payload ChatMessage chatMessage) {
        return modelMapper.map(chatMessage, ChatMessageWithTime.class);
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
