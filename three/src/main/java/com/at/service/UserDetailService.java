package com.at.service;

import com.at.base.pclass.Account;
import com.at.base.pclass.Car;


@FunctionalInterface
public interface UserDetailService {
    Account getAccount(String userName);
}
