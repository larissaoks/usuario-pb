package br.com.infnet.usuario.controller;

import br.com.infnet.usuario.model.Usuario;
import br.com.infnet.usuario.service.AuthService;
import br.com.infnet.usuario.service.TokenService;
import io.swagger.v3.core.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;

@RestController
@RequestMapping("autenticacao/")
public class AuthController {
    @Autowired
    AuthService authService;

    @Autowired
    TokenService tokenService;

    @PostMapping("auth")
    public ResponseEntity<Map<String, String>> autenticacao(@RequestHeader("Authorization") String authHeader) {
        String credentials = new String(Base64.getDecoder().decode(authHeader.substring("Basic".length()).trim()), StandardCharsets.UTF_8);
        String[] auth = credentials.split(":",2);
        String email = auth[0];
        String password = auth[1];
        if(email.isEmpty() || password.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Error", "Preencha os campos vazios"));
        }
        Usuario userAuthorized = authService.logar(email, password);
        if (userAuthorized == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Map.of("Message:", "Email e/ou Senha não encontrado"));
        }
        String token = tokenService.generateToken(userAuthorized);

        return ResponseEntity.ok(Map.of("token", token));
    }


    @GetMapping("verifyToken")
    public ResponseEntity<Map<String, String>> verify(@RequestHeader("Authorization") String token) {

        String jwt = token.substring("Bearer".length()).trim();
        Map<String, String> isAuthenticated = tokenService.verifyToken(jwt);
        if (isAuthenticated.containsValue("true")) {
            return ResponseEntity.ok(Map.of("validToken", isAuthenticated.get("validToken"),"data", isAuthenticated.get("user")));
            //return ResponseEntity.ok(Map.of(true, isAuthenticated.get(true)));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("validToken", isAuthenticated.get("validToken"),"data", isAuthenticated.get("user")));
    }

}

