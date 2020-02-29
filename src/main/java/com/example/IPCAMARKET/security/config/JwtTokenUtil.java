/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.security.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 *
 * @author Andy
 */
@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = 916360118716149216L;
    static final String CLAM_KEY_USERNAME = "sub";
    static final String CLAM_KEY_AUDIENCE = "audience";
    static final String CLAM_KEY_CREATED = "created";

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

   
    public String getUsernameFromToken(String token) {
        String username = null;

        try {
            final Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;

        }
        return username;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            // TODO: handle exception
            claims = null;
        }
        return claims;
    }

   
    public Date getExpirationDateFromToken(String token) {
    	Date expiration=null;
    	try {
			final Claims claims=getClaimsFromToken(token);
			if (claims!=null) {
				expiration=claims.getExpiration();
			}else {
				expiration=null;
			}
		} catch (Exception e) {
			expiration=null;
		}
    	return expiration;
        
    }

    

   

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

   
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    private String generateToken(Map<String, Object> claims) {
		return Jwts.builder().setClaims(claims).setExpiration(generateExpirationDate())
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	private Date generateExpirationDate() {
		return new Date(System.currentTimeMillis()+expiration*1000);
	}


//    private String doGenerateToken(Map<String, Object> claims, String subject) {
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(subject)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(
//                        System.currentTimeMillis()
//                        + serialVersionUID
//                        * 1000
//                ))
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//    }

    public Boolean validateToken(String token, UserDetails userDetails) {
       JwtUser user=(JwtUser)userDetails;
       final String username=getUsernameFromToken(token);
       
       return (username.equals(user.getUsername()) && !isTokenExpired(token)) ;
    }

}
