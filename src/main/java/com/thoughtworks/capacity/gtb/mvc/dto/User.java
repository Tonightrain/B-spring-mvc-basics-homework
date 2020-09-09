package com.thoughtworks.capacity.gtb.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotNull(message = "用户名不能为空")
    @Size(min = 3,max = 10,message = "用户名不合法")
//    @Pattern(regexp = "^[0-9a-zA-Z_]{1,}$")
    @Pattern(regexp = "^[0-9a-zA-Z_]+$",message = "用户名不合法")
    private String userName;

    @NotNull(message = "密码不能为空")
    @Size(min = 5,max = 12,message = "密码不合法")
    private String password;

    @Email(message = "邮箱不合法")
    private String email;

    public User(String userName,String password){
        this.userName = userName;
        this.password = password;
    }
}
