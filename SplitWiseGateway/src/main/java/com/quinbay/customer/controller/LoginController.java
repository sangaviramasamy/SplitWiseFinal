//package com.quinbay.customer.controller;
//
//import com.quinbay.customer.model.entity.Login;
//import com.quinbay.customer.service.LoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//@Component
////@CrossOrigin(origins="http://127.0.0.1:3000/")
//public class LoginController implements HandlerInterceptor, WebMvcConfigurer {
//
//    private static final String AUTH_HEADER = "Authorization";
//    @Autowired
//    private LoginService loginService;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//
//        if (request.getRequestURI().endsWith("/httpmethod/login")) {
//            return true;
//        }
//        String baseUri = "/httpmethod/register";
//        if (request.getRequestURI().contains(baseUri + "/")){
//            return true;
//        }
//
////        String baseUri2 = "httpmethod/expense-list";
////        if (request.getRequestURI().contains(baseUri2 + "/")){
////            return true;
////        }
//
//        String authToken = request.getHeader(AUTH_HEADER);
//        if (authToken == null || authToken.isEmpty() || !authToken.startsWith("Bearer ")) {
//
//            response.setStatus(HttpStatus.UNAUTHORIZED.value());
//            return false;
//        }
//        long userId =  Long.parseLong(request.getHeader("User-Id"));
//        Login check = loginService.findByToken(authToken, userId);
//        System.out.println(check);
//
//
//        if(check == null)
//        {
//            response.setStatus(HttpStatus.UNAUTHORIZED.value());
//            return false;
//        }
//
//        return true;
//    }
//
//
//}
