/*
 * package com.example.demo.security;
 * 
 * import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * import com.example.demo.entity.User; import
 * com.example.demo.exception.ResourceFoundException; import
 * com.example.demo.repository.UserRepository;
 * 
 * @Service public class UserDetailServiceImpl implements UserDetailsService {
 * private final UserRepository userRepository;
 * 
 * @Autowired public UserDetailServiceImpl(UserRepository userRepository) {
 * this.userRepository = userRepository; }
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException { Optional<User> userOptional =
 * userRepository.findByEmail(username); if (userOptional.isEmpty()) { throw new
 * ResourceFoundException("User not found"); } return new
 * UserDetail(userOptional.get()); }
 * 
 * }
 */