/*
 * package com.example.demo.security;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.config.BeanIds; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.web.authentication.
 * UsernamePasswordAuthenticationFilter;
 * 
 * import com.example.demo.jwt.JwtAuthenticationFilter;
 * 
 * @EnableWebSecurity public class WebSecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Autowired UserDetailServiceImpl userDetailServiceImpl;
 * 
 * @Bean public JwtAuthenticationFilter jwtAuthenticationFilter() { return new
 * JwtAuthenticationFilter(); }
 * 
 * @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
 * 
 * @Override public AuthenticationManager authenticationManagerBean() throws
 * Exception { return super.authenticationManagerBean(); }
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); }
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { auth.userDetailsService(userDetailServiceImpl).passwordEncoder(
 * passwordEncoder()); }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.cors().and().authorizeRequests().antMatchers("/api/login").permitAll().
 * anyRequest().authenticated(); http.addFilterBefore(jwtAuthenticationFilter(),
 * UsernamePasswordAuthenticationFilter.class); } }
 */