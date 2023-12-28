package com.example.group_services.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class Response {
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String status;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
