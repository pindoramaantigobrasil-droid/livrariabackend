package com.livraria.backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.backend.dto.AuthRequest;
import com.livraria.backend.dto.AuthResponse;
import com.livraria.backend.entity.User;
import com.livraria.backend.repository.UserRepository;
import com.livraria.backend.service.JwtService;

@RestController
@RequestMapping("/auth")

@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody AuthRequest request
    ) {

        Optional<User> usuarioExistente =
                userRepository.findByUsername(
                        request.getUsername()
                );

        if (usuarioExistente.isPresent()) {

            return ResponseEntity
                    .badRequest()
                    .body("Usuário já existe");
        }

        User novoUsuario = new User();

        novoUsuario.setUsername(
                request.getUsername()
        );

        novoUsuario.setPassword(
                request.getPassword()
        );

        userRepository.save(novoUsuario);

        return ResponseEntity.ok(
                "Usuário cadastrado com sucesso"
        );
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody AuthRequest request
    ) {

        Optional<User> usuario =
                userRepository.findByUsername(
                        request.getUsername()
                );

        if (usuario.isEmpty()) {

            return ResponseEntity
                    .badRequest()
                    .body("Usuário não encontrado");
        }

        if (!usuario.get().getPassword()
                .equals(request.getPassword())) {

            return ResponseEntity
                    .badRequest()
                    .body("Senha inválida");
        }

        String token =
                jwtService.generateToken(
                        request.getUsername()
                );

        return ResponseEntity.ok(
                new AuthResponse(token)
        );
    }
}