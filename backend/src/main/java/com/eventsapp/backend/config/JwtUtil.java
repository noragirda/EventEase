package com.eventsapp.backend.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Utility class for generating, parsing, and validating JWT tokens.
 * Used for securing API endpoints by embedding user-related claims in signed tokens.
 */
@Component
public class JwtUtil {

    /**
     * The secret key used to sign the JWTs, loaded from the application properties.
     */
    @Value("${jwt.secret}")
    private String secretKey;

    /**
     * Token expiration duration in milliseconds, loaded from the application properties.
     */
    @Value("${jwt.expiration}")
    private long jwtExpiration;

    /**
     * Generates the signing key from the configured secret.
     *
     * @return the signing {@link Key} used for HMAC SHA encryption
     */
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    /**
     * Generates a new JWT token for the provided user, including role information in the claims.
     *
     * @param userDetails the user for whom to generate the token
     * @return a signed JWT token
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", userDetails.getAuthorities().stream().findFirst().get().getAuthority());
        return buildToken(claims, userDetails.getUsername());
    }

    /**
     * Builds the actual JWT token using provided claims and subject.
     *
     * @param claims  a map of claims to include in the token
     * @param subject the username or identifier of the token owner
     * @return a signed JWT token string
     */
    private String buildToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Extracts the username (subject) from the JWT token.
     *
     * @param token the JWT token
     * @return the username (subject) from the token
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extracts the user's role from the JWT token.
     *
     * @param token the JWT token
     * @return the user's role
     */
    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    /**
     * Validates whether the token is valid for the given user.
     *
     * @param token        the JWT token
     * @param userDetails  the user details to match against
     * @return true if the token is valid and not expired, false otherwise
     */
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * Checks if the token has expired.
     *
     * @param token the JWT token
     * @return true if expired, false otherwise
     */
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Extracts the expiration date from the JWT token.
     *
     * @param token the JWT token
     * @return the expiration {@link Date}
     */
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Extracts a specific claim from the token using a resolver function.
     *
     * @param token          the JWT token
     * @param claimsResolver a function to resolve a specific claim
     * @param <T>            the type of the claim
     * @return the extracted claim
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Parses the token and extracts all claims (subject, expiration, custom claims).
     *
     * @param token the JWT token
     * @return the parsed {@link Claims}
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
