package lk.ijse.auth_backend.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.expiration}")
    private long expiration;

    @Value("${jwt.secretKey}")
    private String secretKey;

    private Key key;

    @PostConstruct
    public void init() {
        key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    // UPDATED — includes role
    public String generateToken(String username, String role){
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)   // add role
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token){
        return extractAllClaims(token).getSubject();
    }

    public String extractRole(String token){
        return extractAllClaims(token).get("role", String.class);
    }

    public boolean validateToken(String token){
        try {
            extractAllClaims(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}