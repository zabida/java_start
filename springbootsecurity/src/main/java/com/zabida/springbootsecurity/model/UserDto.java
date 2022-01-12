package com.zabida.springbootsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    public static final String SESSION_USER_KEY = "_user";
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
    /*
    用户权限
     */
    private Set<String> authorities;
}
