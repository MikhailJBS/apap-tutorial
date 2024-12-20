package apap.tutorial.manpromanpro.security.jwt;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.*;

@Component
public class JwtUtils {
    private static Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${manpromanpro.app.jwtSecret}")
    private String jwtSecret;

    @Value("${manpromanpro.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        JwtParser jwtParser = Jwts.parser().verifyWith(
            Keys.hmacShaKeyFor(jwtSecret.getBytes())).build();
        
        Claims claims = jwtParser.parse(token).accept(Jws.CLAIMS).getPayload();
        return claims.getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            JwtParser jwtParser = Jwts.parser().verifyWith(
                Keys.hmacShaKeyFor(jwtSecret.getBytes())).build();
            jwtParser.parse(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

}
