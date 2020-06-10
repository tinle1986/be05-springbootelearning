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
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

  private final CustomUserDetailsService userDetailsService;

  final
  Environment environment;

  public AdminSecurityConfig(CustomUserDetailsService userDetailsService, Environment environment) {
    this.userDetailsService = userDetailsService;
    this.environment = environment;
  }

  @Bean
  protected AuthenticationManager adminAuthenticationManager() throws Exception {
    return super.authenticationManager();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService)
            .passwordEncoder(new BCryptPasswordEncoder());
//    auth
//            .inMemoryAuthentication()
//            .withUser("admin").password("123@abc").authorities("ADMIN");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
//    http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//    http.cors();
    http.csrf().disable()
            .antMatcher("/admin/**")
            .authorizeRequests()
            .antMatchers("/admin/auth/**", "/admin/login/**")
            .permitAll()
            .antMatchers("/admin/role/**")
            .hasAnyRole("ADMIN")
            .antMatchers("/admin/user/**")
            .hasAnyRole("ADMIN", "STAFF", "LEGAL", "GUEST")
            .anyRequest()
            .authenticated()
    .and()
    .formLogin()
    .usernameParameter("email")
    .passwordParameter("password")
    .loginPage("/admin/login");
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
