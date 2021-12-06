package com.ajay.chatapp.message.repo;

import com.ajay.chatapp.message.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {

    @Query("select m from Message m where m.senderId = :senderId")
    List<Message> findAllBySenderId(Long senderId);

    @Query("delete from Message m where m.senderId = :senderId")
    List<Message> deleteAllBySenderId(Long senderId);
}
