package com.tuempresa.sistemaventas.security.auth;

import com.tuempresa.sistemaventas.dto.AuthRequest;
import com.tuempresa.sistemaventas.dto.AuthResponse;
import com.tuempresa.sistemaventas.dto.RegisterRequest;
import com.tuempresa.sistemaventas.model.Rol;
import com.tuempresa.sistemaventas.model.Usuario;
import com.tuempresa.sistemaventas.repository.UsuarioRepository;
import com.tuempresa.sistemaventas.security.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public void register(RegisterRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setEmail(request.getEmail());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuario.setRol(Rol.valueOf(request.getRol())); // ADMIN o VENDEDOR
        usuarioRepository.save(usuario);
    }

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        String token = jwtService.generateToken(usuario.getEmail());
        return new AuthResponse(token);
    }
}
