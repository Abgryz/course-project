package com.suitt.security.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration {
//    @Bean
//    UserMapper userMapper(PasswordEncoder passwordEncoder){
//        return new UserMapper(passwordEncoder);
//    }
//
//    @Bean
//    UserService userService(UserRepository repository, UserMapper userMapper) {
//        return new UserService(repository, userMapper);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
