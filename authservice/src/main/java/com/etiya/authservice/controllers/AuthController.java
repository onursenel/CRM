//package com.etiya.authservice.controllers;
//
//import com.etiya.authservice.services.abstracts.AuthService;
//import com.etiya.authservice.services.dtos.LoginRequest;
//import com.etiya.authservice.services.dtos.RegisterRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/auth")
//@CrossOrigin
//public class AuthController {
//    private final AuthService authService;
//
//    @PostMapping("/register")
//    @Secured("admin")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void register(@RequestBody RegisterRequest request)
//    {
//        authService.register(request);
//    }
//
//    @PostMapping("/login")
//    @ResponseStatus(HttpStatus.OK)
//    @Secured("admin")
//    public String login(@RequestBody LoginRequest request)
//    {
//        return authService.login(request);
//    }
//}
