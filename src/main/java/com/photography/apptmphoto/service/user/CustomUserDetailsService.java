package com.photography.apptmphoto.service.user;

import com.photography.apptmphoto.entity.user.User;
import com.photography.apptmphoto.entity.user.UserRepository;
import com.photography.apptmphoto.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Nije pronadjen user");
        }
        return new CustomUserDetails(user);
    }
}
