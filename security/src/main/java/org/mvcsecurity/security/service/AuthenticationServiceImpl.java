package org.mvcsecurity.security.service;

import org.mvcsecurity.security.model.AuthenticationRequest;
import org.mvcsecurity.security.model.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private Map<String, UserDto> userMap = new HashMap<>();

    {
        HashSet<String> p1 = new HashSet<>();
        p1.add("p1");
        HashSet<String> p2 = new HashSet<>();
        p2.add("p2");
        userMap.put("张三", new UserDto("1010", "zhangsan", "1234", "zhangsan", "1213121", p1));
        userMap.put("lisi", new UserDto("1011", "lisi", "1234", "lisi", "1213121", p2));
    }

    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        if (authenticationRequest == null ||
                StringUtils.isEmpty(authenticationRequest.getUsername()) ||
                StringUtils.isEmpty(authenticationRequest.getPassword())) throw new RuntimeException("帐户或密码为空");
        UserDto userDto = getUserDto(authenticationRequest.getUsername());
        if (userDto == null) throw new RuntimeException("查询不到该用户");
        if (!userDto.getPassword().equals(authenticationRequest.getPassword())) throw new RuntimeException("密码错误");
        return userDto;
    }

    private UserDto getUserDto(String username) {
        return userMap.get(username);
    }
}
