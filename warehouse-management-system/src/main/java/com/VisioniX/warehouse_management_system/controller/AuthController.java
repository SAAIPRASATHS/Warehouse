package com.VisioniX.warehouse_management_system.controller;

import com.VisioniX.warehouse_management_system.dto.AuthDto;
import com.VisioniX.warehouse_management_system.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/register")
    public String register(
            @RequestBody AuthDto dto) {

        return authService.register(dto);
    }
    @PostMapping("/login")
    public String login(
            @RequestBody AuthDto dto) {

        return authService.login(dto);
    }
}