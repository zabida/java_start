package com.at.base;

import com.at.base.pclass.Account;
import com.at.service.UserDetailService;

public class Lam {

    public UserDetailService userDetail(){
        return Account::getOne;
    }

    public static void main(String[] args) {
        Lam lam = new Lam();
        UserDetailService userDetailService = lam.userDetail();

    }
}
