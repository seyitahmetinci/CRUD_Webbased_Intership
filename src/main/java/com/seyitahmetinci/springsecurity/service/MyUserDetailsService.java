package com.seyitahmetinci.springsecurity.service;

import com.seyitahmetinci.springsecurity.Repository.UserRepository;
import com.seyitahmetinci.springsecurity.entitites.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        if(user==null){
            throw new UsernameNotFoundException("User details not found for the user : " + username);
        }


        return new MyUserDetail(user);
    }
}
