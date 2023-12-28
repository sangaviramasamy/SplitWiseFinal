package com.quinbay.customer.model.vo;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String status;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String token;



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isSuccess() {
        return getStatus().equalsIgnoreCase("success");
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean getStatusCode() {
        return isSuccess();
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> categoryList;


}
