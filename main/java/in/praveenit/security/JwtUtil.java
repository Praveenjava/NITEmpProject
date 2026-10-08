package in.praveenit.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {

    // ✅ Correct: 32+ character secret
    private static final String SECRET = "4e941a8e-0a8c-4df4-93fd-79e9e1e316c8";

    private Key getKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes()); // ✅ NO Base64 decoding
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}