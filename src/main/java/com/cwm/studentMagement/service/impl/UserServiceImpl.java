package com.cwm.studentMagement.service.impl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cwm.studentMagement.model.Users;
import com.cwm.studentMagement.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {
    
    private  UserRepository userRepository;
    UserServiceImpl(UserRepository userRepository){
     this.userRepository = userRepository;
    }

    @Override 
    public  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     Users user =  userRepository.findByUsername(username).orElseThrow(() ->  new UsernameNotFoundException("Invalid username"));
     System.out.print(user.getPassword());
     return User.withUsername(username).password(user.getPassword()).disabled(!user.isActive()).build();
    }
}
