package com.solana.pupilty.controller;

import com.solana.pupilty.request.LoginRequest;
import com.solana.pupilty.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login", produces = "application/json")
public class LoginController {


    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping()
    public Object login(@RequestBody LoginRequest request) {

        return loginService.login(request);

    }


}
