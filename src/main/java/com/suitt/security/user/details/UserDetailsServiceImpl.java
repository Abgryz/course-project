package com.suitt.security.user.details;

import com.suitt.security.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userService.getUser(email)
                .map(user -> {
                    if (!user.isActive()) {
                        throw new DisabledException("User account is disabled");
                    }
                    return new User(
                            user.getEmail(),
                            user.getPassword(),
                            Collections.singletonList(new SimpleGrantedAuthority(user.getRole()))
                    );
                })
                .orElseThrow(() -> new UsernameNotFoundException("User " + email + " not found"));
    }
}


