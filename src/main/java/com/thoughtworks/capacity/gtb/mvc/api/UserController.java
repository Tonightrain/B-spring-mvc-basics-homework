package com.thoughtworks.capacity.gtb.mvc.api;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody @Valid User user){
        userService.registerUser(user);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/users")
    public ResponseEntity getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/login")
    public ResponseEntity login(@RequestParam(required = true) @Size(min = 3,max = 10,message = "用户名不合法") @Pattern(regexp = "^[0-9a-zA-Z_]+$",message = "用户名不合法")String userName,
                                @RequestParam(required = true) @Size(min = 5,max = 12,message = "密码不合法") String password){
        return ResponseEntity.ok(userService.login(userName,password));
    }
}
