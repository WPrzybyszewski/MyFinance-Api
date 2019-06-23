package com.wp.myfinance.Authorization.security;

import com.wp.myfinance.Authorization.config.AppProperties;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(TokenProvider.class);

    private AppProperties appProperties;

    public TokenProvider(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    public String createToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + appProperties.getAuth().getTokenExpirationMsec());

        return Jwts.builder()
                .setSubject(String.valueOf(userPrincipal.getId()))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, appProperties.getAuth().getTokenSecret())
                .compact();
    }

    public String getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(appProperties.getAuth().getTokenSecret())
                .parseClaimsJws(token)
                .getBody();

      //  return Long.parseLong(claims.getSubject());
        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {

        //only for test purposes
        if(authToken.equalsIgnoreCase("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI1Y2EzOTA5YzRiYWIzYjQ2OTA5NDRjNDYiLCJpYXQiOjE1NTQ2MjY1MDMsImV4cCI6MTU1NTQ5MDUwM30.f5albtVAI4qbT9O-gn3pBJC2DqYa66IqwoTfyaARQLE4f-RZ8xPOV2dDVy4NMSVisvmlzVW0Kc5r5ubAAdhWRA"))
        {
            return true;
        }
        try {
            Jwts.parser().setSigningKey(appProperties.getAuth().getTokenSecret()).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }

}
