package org.security.springmvcsecurity.service;

import org.security.springmvcsecurity.model.AuthenticationRequest;
import org.security.springmvcsecurity.model.UserDto;


public interface AuthenticationService {
    UserDto authentication(AuthenticationRequest authenticationRequest);
}
