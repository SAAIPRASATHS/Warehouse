package com.VisioniX.warehouse_management_system.service;
import com.VisioniX.warehouse_management_system.dto.AuthDto;
import com.VisioniX.warehouse_management_system.entity.User;
import com.VisioniX.warehouse_management_system.repository.UserRepository;
import com.VisioniX.warehouse_management_system.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String register(AuthDto dto) {
        if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
            return "Username already exists";
        }
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.saveAndFlush(user);

        return jwtService.generateToken(user.getUsername());
    }

    public String login(AuthDto dto) {
        var user = userRepository.findByUsername(dto.getUsername());
        if (user.isPresent() && passwordEncoder.matches(dto.getPassword(), user.get().getPassword())) {
            return "Successfully login in the Application";
        }
        return "Invalid credentials";
    }
}