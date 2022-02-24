package com.ankit.rest.webservices.demo.User;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@Component
public class UserDao {
    private static ArrayList<User> userList=new ArrayList<>();
    static {
        userList.add(new User(1,"ankit",new Date()));
        userList.add(new User(2,"rajiv",new Date()));
        userList.add(new User(3,"vivek",new Date()));
    }
    private static int userId=3;
    public ArrayList<User> getAllUsers(){
        return userList;
    }
    public User getUser(int id){
        for (User user: userList) {
            if (user.getId()==id) return user;
        }
        return null;
    }
    public User saveUser(User user){
        user.setId(++userId);
        userList.add(user);
        return user;
    }
}
