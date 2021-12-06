package com.ajay.chatapp.message.service;

import com.ajay.chatapp.message.model.Message;
import com.ajay.chatapp.message.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private MessageRepository repository;

    @Autowired
    public  MessageService(MessageRepository repository){
        this.repository = repository;
    }

    public Message sendMessage(Message message) {
        return repository.save(message);
    }

    public Message getMessage(Long id) {
        return repository.getById(id);
    }

    public List<Message> getAllMessagesBySenderId(Long senderId) {
        return repository.findAllBySenderId(senderId);
    }

    public void deleteAllMessagesBySenderId(Long senderId) {
        repository.deleteAllBySenderId(senderId);
    }


}
