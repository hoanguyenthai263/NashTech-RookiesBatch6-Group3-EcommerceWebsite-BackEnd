/*
 * package com.example.demo.security;
 * 
 * import javax.validation.Valid;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.Authentication; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.example.demo.jwt.JwtTokenProvider;
 * 
 * @RestController
 * 
 * @RequestMapping("/api/v1") public class UserRestController {
 * 
 * @Autowired AuthenticationManager authenticationManager;
 * 
 * @Autowired private JwtTokenProvider tokenProvider;
 * 
 * @PostMapping("/login") public LoginResponse
 * authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
 * Authentication authentication = authenticationManager.authenticate( new
 * UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
 * loginRequest.getPassWord()));
 * SecurityContextHolder.getContext().setAuthentication(authentication); String
 * jwt = tokenProvider.generateToken((UserDetail)
 * authentication.getPrincipal()); return new LoginResponse(jwt); } }
 */