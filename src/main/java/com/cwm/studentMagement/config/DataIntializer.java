
package com.cwm.studentMagement.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cwm.studentMagement.model.Users;
import com.cwm.studentMagement.repository.UserRepository;

@Configuration
public class DataIntializer {
    @Bean
    CommandLineRunner loadSampleData(UserRepository userRepository , PasswordEncoder passwordEncoder) {
        return args -> {
            if (!userRepository.existsByUsername("cuong")) {
                Users users = new Users();
                users.setUsername("cuong");
                
                users.setPassword(passwordEncoder.encode("cuong"));
                users.setActive(true);
                userRepository.save(users);
            }
        };
    }

}