package com.quinbay.customer.service;

import com.quinbay.customer.dao.api.LoginRepository;
import com.quinbay.customer.model.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository loginRepository;

    public Login findByToken(String token, long userId){
        return loginRepository.findByToken(token,userId);
    }

}
