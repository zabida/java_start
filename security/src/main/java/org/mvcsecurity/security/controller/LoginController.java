package org.mvcsecurity.security.controller;

import org.mvcsecurity.security.model.AuthenticationRequest;
import org.mvcsecurity.security.model.UserDto;
import org.mvcsecurity.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/login", produces = {"text/plain;charset=UTF-8"})
    public String login(AuthenticationRequest authenticationRequest, HttpSession session) {
        UserDto userDto = authenticationService.authentication(authenticationRequest);
        session.setAttribute(UserDto.SESSION_USER_KEY, userDto);
        return userDto.getFullname() + "登录成功";
    }

    @GetMapping(value = "/logout", produces = "text/plain;charset=utf-8")
    public String logout(HttpSession session) {
        session.invalidate();
        return "退出成功";
    }

    @GetMapping(value = "/r/r1", produces = "text/plain;charset=utf-8")
    public String r1(HttpSession session) {
        String fullname = null;
        Object attribute = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (attribute != null) fullname = ((UserDto) attribute).getFullname();
        else fullname = "匿名";
        return fullname + "访问资源1";
    }

    @GetMapping(value = "/r/r2", produces = "text/plain;charset=utf-8")
    public String r2(HttpSession session) {
        String fullname = null;
        Object attribute = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (attribute != null) fullname = ((UserDto) attribute).getFullname();
        else fullname = "匿名";
        return fullname + "访问资源2";
    }
}
