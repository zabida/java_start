package org.mvcsecurity.security.service;

import org.mvcsecurity.security.model.AuthenticationRequest;
import org.mvcsecurity.security.model.UserDto;


public interface AuthenticationService {
    UserDto authentication(AuthenticationRequest authenticationRequest);
}
