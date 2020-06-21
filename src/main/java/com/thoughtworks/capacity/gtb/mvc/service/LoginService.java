package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.exception.UserException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNotFoundException;
import com.thoughtworks.capacity.gtb.mvc.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Service
public class LoginService {
    private HashMap<String, User> userDict;

    public LoginService(){
        userDict = new HashMap<>();
        User user = User.builder().id(1).userName("Michael").userPassword("abcdefg_1")
                            .userEmail("mds@gta.com").build();
        userDict.put(user.getUserName(), user);
    }

    public void addUser(User user){
        if(userDict.containsKey(user.getUserName()))
            throw new UserException("User Already Exists");
        user.setId(userDict.size() + 1);
        userDict.put(user.getUserName(), user);
    }

    public User login(String username, String password){
        User user = userDict.get(username);
        if ((user == null) || !user.getUserPassword().equals(password)){
            throw new UserNotFoundException("用户名或密码不合法");
        }else{
            return user;
        }
    }

}
