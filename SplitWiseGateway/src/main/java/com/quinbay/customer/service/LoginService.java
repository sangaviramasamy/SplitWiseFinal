package com.quinbay.customer.service;

import com.quinbay.customer.model.entity.Login;

public interface LoginService {

    Login findByToken(String Token, long userId);
}
