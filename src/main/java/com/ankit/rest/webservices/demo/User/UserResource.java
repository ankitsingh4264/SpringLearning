package com.ankit.rest.webservices.demo.User;


import com.ankit.rest.webservices.demo.Exception.ExceptionResponse;
import com.ankit.rest.webservices.demo.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    //AutoWired will inject the instance of userDao here
    @Autowired
    private UserDao userService;

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User findOne(@PathVariable int id) throws UserNotFoundException {
        User user=userService.getUser(id);
        if (user==null){
            throw new UserNotFoundException("id-"+id + "not found change id");
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> saveUser(@RequestBody  User user){
       User saved= userService.saveUser(user);
       URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
