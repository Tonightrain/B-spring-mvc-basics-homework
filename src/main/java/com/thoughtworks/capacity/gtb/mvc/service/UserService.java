package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<User> users = initUsers();

    private List<User> initUsers(){
        List<User> userList = new ArrayList<>();
        userList.add(new User("小明","888888","1@qq.com"));
        userList.add(new User("小明","888888","1@qq.com"));
        return userList;
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}
