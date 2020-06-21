package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.exception.UserException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNotFoundException;
import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@RequestMapping
@CrossOrigin
@Validated
public class LoginControl {
    private final LoginService loginService;

    @Autowired
    public LoginControl(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid User user) throws UserException {
        loginService.addUser(user);
    }

    @GetMapping("/login")
    public User login(String name, String pwd) throws UserNotFoundException {
        User user = loginService.login(name, pwd);
        if(user == null){
            throw new UserNotFoundException("用户名或密码错误");
        }
        return loginService.login(name, pwd);
    }


}
