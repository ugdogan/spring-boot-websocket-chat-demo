package com.example.springbootwebsocketchatdemo.model;

import com.example.springbootwebsocketchatdemo.enumeration.MessageType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;
}
