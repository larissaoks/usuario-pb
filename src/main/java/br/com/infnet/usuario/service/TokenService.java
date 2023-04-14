package br.com.infnet.usuario.service;

import br.com.infnet.usuario.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@Service
public class TokenService {
    String secret = "mySecret";
    public String generateToken(Usuario userAuth) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        Instant expiration = Instant.now().plus(50, ChronoUnit.MINUTES);

        return JWT.create()
                .withIssuer("user-agenda")
                .withSubject(userAuth.getIdUser().toString())
                .withClaim("nome", userAuth.getNome())
                .withClaim("tipo_usuario", userAuth.getTipoUser())
                .withExpiresAt(expiration)
                .sign(algorithm);
    }

    public Map<String, String> verifyToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            DecodedJWT tokenVerified = JWT.require(algorithm).build().verify(token);
            String user = tokenVerified.getClaim("nome").asString();
            String tipoUser = tokenVerified.getClaim("tipo_usuario").asString();
            return Map.of("validToken", "true", "user", user, "tipoUser", tipoUser);
        } catch (JWTDecodeException e){
            return Map.of("validToken", "false", "user", "", "tipoUser", "");
        }
    }
}
