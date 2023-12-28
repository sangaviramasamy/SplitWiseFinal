package com.example.group_services.dao.api;

import com.example.group_services.model.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    @Override
    List<Login> findAll();

    Login findByPhoneNumberAndUserPassword(String phoneNumber, String userPassword);
    Login findByUserId(long userId);
    Login findByPhoneNumber(String phoneNumber);
}
