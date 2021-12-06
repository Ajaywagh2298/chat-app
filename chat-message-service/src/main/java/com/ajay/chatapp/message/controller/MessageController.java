package com.ajay.chatapp.message.controller;

import com.ajay.chatapp.message.ChatMessageServiceApplication;
import com.ajay.chatapp.message.model.Message;
import com.ajay.chatapp.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/message")
public class MessageController {
    private MessageService service;

    @Autowired
    public MessageController(MessageService service) {
        this.service = service;
    }

    @PostMapping
    public @ResponseBody Message createUser(@RequestBody Message message) {
        return service.sendMessage(message);
    }

    @GetMapping
    public @ResponseBody List<Message> getAllMessageBySenderId(Long senderId) {
        return service.getAllMessagesBySenderId(senderId);
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Message getMessage(@PathVariable("id") Long id) {
        return service.getMessage(id);
    }
}
