package Collin_Le.StatRoyale.config;

import Collin_Le.StatRoyale.model.Users;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder encodePassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(8);

        return encoder;
    }
}
