package com.quinbay.customer.model.entity;

import com.quinbay.customer.model.vo.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

public class ResponseEntity<Response> {
    private final HttpHeaders headers;
    private final HttpStatus statusCode;
    private final Response body;

    public ResponseEntity(Response body, HttpHeaders headers, HttpStatus statusCode) {
        this.body = body;
        this.headers = headers;
        this.statusCode = statusCode;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public Response getBody() {
        return body;
    }
}
