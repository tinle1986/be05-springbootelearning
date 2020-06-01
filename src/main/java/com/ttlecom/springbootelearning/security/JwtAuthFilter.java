package com.ttlecom.springbootelearning.security;

import com.ttlecom.springbootelearning.service.CustomUserDetailsService;
import io.jsonwebtoken.Jwts;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthFilter extends BasicAuthenticationFilter {

  private final CustomUserDetailsService userDetailsService;

  // cannot get value of secret key from application.properties file because of not initialized an object,
  // need to put it into a constructor as below
  private final String secretKey;

  public JwtAuthFilter(AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService, Environment environment) {
    super(authenticationManager);
    this.userDetailsService = userDetailsService;
    this.secretKey = environment.getProperty("secret-key");
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
    String tokenHeader = request.getHeader("Authorization");

    if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
      try {
        String token = tokenHeader.replace("Bearer ", "");
        String email = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
      } catch (Exception e) {
        response.sendError(400, "Token doesn't have a correct format!");
      }
    }

    chain.doFilter(request, response);
  }
}
