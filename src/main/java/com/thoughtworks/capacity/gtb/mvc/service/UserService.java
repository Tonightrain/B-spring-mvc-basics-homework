package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNameExitException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<User> users = initUsers();

    private List<User> initUsers(){
        List<User> userList = new ArrayList<>();
        userList.add(new User("Mike","888888","1@qq.com"));
        userList.add(new User("Jack","888888","1@qq.com"));
        return userList;
    }

    public void registerUser(User user) {
        for (User user1 : users){
            if (user.getUserName().equals(user1.getUserName())){
                throw new UserNameExitException("用户名重复");
            }
        }
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}
