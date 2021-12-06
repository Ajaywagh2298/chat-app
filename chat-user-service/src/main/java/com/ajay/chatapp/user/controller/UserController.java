package com.ajay.chatapp.user.controller;

import com.ajay.chatapp.user.model.User;
import com.ajay.chatapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping(path = "/register")
    public @ResponseBody User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping
    public @ResponseBody List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody User getUser(@PathVariable("id") Long id) {
        return service.getUser(id);
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody void deleteUser(@PathVariable("id") Long id) {
        service.deleteUser(id);
    }

    @PostMapping("/login")
    public @ResponseBody User login(@RequestParam String username, @RequestParam String password) {
        try {
            return service.login(username, password);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage(), e);
        }
    }

}
