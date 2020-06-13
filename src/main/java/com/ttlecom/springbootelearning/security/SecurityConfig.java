package com.ttlecom.springbootelearning.security;

import com.ttlecom.springbootelearning.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final CustomUserDetailsService userDetailsService;

  final
  Environment environment;

  public SecurityConfig(CustomUserDetailsService userDetailsService, Environment environment) {
    this.userDetailsService = userDetailsService;
    this.environment = environment;
  }

  @Bean
  @Override
  protected AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService)
            .passwordEncoder(new BCryptPasswordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
//    http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    http.cors();
    http.csrf()
            .disable()
            .antMatcher("/api/**")
            .authorizeRequests()
            .antMatchers("/api/auth/**", "/api/category/**", "/api/course/**")
            .permitAll()
            .antMatchers("/api/role/**")
            .hasAnyRole("ADMIN")
            .antMatchers("/api/user/**")
            .hasAnyRole("ADMIN", "STAFF", "LEGAL", "GUEST")
//        .and()
//            .antMatcher("/admin/**")
//            .authorizeRequests()
//            .antMatchers("/admin/login**")
//            .permitAll()
//            .antMatchers("/admin/role/**")
//            .hasAnyRole("ADMIN")
//            .antMatchers("/admin/user")
//            .hasAnyRole("ADMIN", "STAFF", "LEGAL")
            .anyRequest()
            .authenticated();
    http.addFilter(new JwtAuthFilter(authenticationManager(), userDetailsService, environment));
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring()
            .antMatchers("/v2/api-docs",
                    "/configuration/ui",
                    "/swagger-resources/**",
                    "/configuration/security",
                    "/swagger-ui.html",
                    "/webjars/**",
                    "/assets/upload/**");
  }
}
