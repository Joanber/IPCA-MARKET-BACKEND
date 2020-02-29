package com.example.IPCAMARKET.security.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import io.jsonwebtoken.ExpiredJwtException;

public class CsrfHeaderFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtUserDetailsServiceImpl jwtUserDetailsServiceImpl;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		
//		CsrfToken csrfToken=(CsrfToken) request.getAttribute(CsrfToken.class.getName());
//		if (csrfToken!=null) {
//			Cookie cookie=WebUtils.getCookie(request, "XSRF-TOKEN");
//			String token=csrfToken.getToken();
//			if (cookie==null || token!=null && !token.equals(cookie.getValue())) {
//				cookie=new Cookie("XSRF-TOKEN", token);
//				cookie.setPath("/");
//				response.addCookie(cookie);
//			}
//			
//		}
//		filterChain.doFilter(request, response);
//	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
        String jwtToken = null;
        
        if (requestTokenHeader != null) {
            jwtToken = requestTokenHeader.replace("Bearer", "");
            try {
                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
            } catch (IllegalArgumentException e) {
                System.out.println("No logramos obtener  JWT Token");
            } catch (ExpiredJwtException e) {
                System.out.println("JWT Token ha expirado.");
            }
        } else {
            logger.warn("JWT Token no lo tenemos");
        }

        // Validamos el username 
        if (username != null
                && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.jwtUserDetailsServiceImpl.loadUserByUsername(username);
            
            // Si el token es valido configuramos el Spring security 
            if(jwtTokenUtil.validateToken(jwtToken, userDetails)){
                UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(
                        userDetails, 
                        null,
                        userDetails.getAuthorities()
                );
                upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(hsr));
                
                SecurityContextHolder.getContext().setAuthentication(upat);
            }
        }
        
        filterChain.doFilter(request, response);
	}

}
