package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNameExitException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNameOrPasswordErrorException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<User> users = initUsers();

    private List<User> initUsers(){
        List<User> userList = new ArrayList<>();
        userList.add(new User(1,"Mike","888888","1@qq.com"));
        userList.add(new User(2,"Jack","888888","1@qq.com"));
        return userList;
    }

    public void registerUser(User user) {
        for (User user1 : users){
            if (user.getUserName().equals(user1.getUserName())){
                throw new UserNameExitException("用户已存在");
            }
        }
        users.add(new User(users.size()+1,user.getUserName(),user.getPassword(),user.getEmail()));
    }

    public List<User> getUsers() {
        return users;
    }

    public User login(String userName, String password) {
        for (User user : users){
            if (user.getUserName().equals(userName)&&user.getPassword().equals(password)){
                return user;
            }
        }
        throw new UserNameOrPasswordErrorException("用户名或密码错误");
    }
}
