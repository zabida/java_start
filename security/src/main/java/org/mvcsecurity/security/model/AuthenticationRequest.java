package org.mvcsecurity.security.model;

import lombok.Data;

@Data
public class AuthenticationRequest {
    // 认证请求参数
    private String username;

    private String password;
}
