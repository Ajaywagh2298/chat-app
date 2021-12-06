package com.ajay.chatapp.user.service;

import com.ajay.chatapp.user.model.User;
import com.ajay.chatapp.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User getUser(Long id) {
        return repository.getById(id);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User updateUser(Long id, User user) {
        user.setId(id);
        return repository.save(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public User login(String username, String password) throws Exception {
        User user = repository.getUserByEmail(username);

        if(user.getPassword().equals(password)) {
            return user;
        }
        throw new Exception("invalid username or password");
    }
}
