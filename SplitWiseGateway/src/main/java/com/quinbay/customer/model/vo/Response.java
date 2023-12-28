package com.quinbay.customer.model.vo;

public class Response {
    private long id;
    private String status;
    private String token;  // Add this line

    // Other existing fields and methods...

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isSuccess() {
        // Modify this method based on your logic
        return getStatus().equalsIgnoreCase("success");
    }

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

    public boolean getStatusCode() {
        // Modify this method based on your logic
        return isSuccess();
    }
}
