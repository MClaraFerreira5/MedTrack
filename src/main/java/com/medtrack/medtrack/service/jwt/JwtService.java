package com.medtrack.medtrack.service.jwt;

import com.medtrack.medtrack.model.dependente.DependenteDetails;
import com.medtrack.medtrack.model.usuario.UsuarioDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    // Gera uma chave segura para o algoritmo HS256
    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(UsuarioDetails usuario) {
        // Criação das claims (informações) do token
        Claims claims = Jwts.claims().setSubject(usuario.getUsername());
        claims.put("categoria", usuario.getTipoConta()); // Adicionando a categoria ao token

        // Gerando o token com a assinatura e claims
        return Jwts.builder()
                .setClaims(claims)  // Usando as claims definidas acima
                .setIssuedAt(new Date(System.currentTimeMillis())) // Data de criação
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas de validade
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256) // Algoritmo de assinatura
                .compact();
    }

    public String generateTokenDependente(DependenteDetails dependenteDetails) {
        // Criação das claims (informações) do token
        Claims claims = Jwts.claims().setSubject(dependenteDetails.getUsername());

        // Gerando o token com a assinatura e claims
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis())) // Data de criação
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas de validade
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256) // Algoritmo de assinatura
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY) // Define a chave secreta
                .build()
                .parseClaimsJws(token) // Parseia o token
                .getBody(); // Obtém o corpo dos claims

        return claimsResolver.apply(claims);
    }
}
