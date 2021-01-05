package br.com.broscoder.hrauth.service;

import br.com.broscoder.hrauth.client.UserFeignClient;
import br.com.broscoder.hrauth.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient client;

    public User findByEmail(String email) {
        User user = client.findByEmail(email).getBody();
        if(Objects.isNull(user)) {
            logger.error("Email not found: " + email);
            throw new IllegalArgumentException("Username Not Found");
        }
        logger.info("Email found: " + email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = client.findByEmail(username).getBody();
        if(Objects.isNull(user)) {
            logger.error("Email not found: " + username);
            throw new UsernameNotFoundException("Username Not Found");
        }
        logger.info("Email found: " + username);
        return user;
    }
}
