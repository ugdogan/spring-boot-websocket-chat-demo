package com.example.springbootwebsocketchatdemo.model;

import com.example.springbootwebsocketchatdemo.enumeration.MessageType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageWithTime {
    private MessageType type;
    private String content;
    private String sender;
    @JsonFormat(pattern="HH:mm")
    private Date time = new Date();
}
