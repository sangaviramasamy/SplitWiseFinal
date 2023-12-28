package com.quinbay.customer.dao.api;


import com.quinbay.customer.model.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

    @Query("SELECT user_details FROM Login user_details " +
            "WHERE " +
            "user_details.token = :authToken  AND user_details.userId = :userId")
    Login findByToken(@Param("authToken") String authToken, @Param( "userId") long userId);

}

