
package com.ebim.esupplier.config;

import com.ebim.esupplier.domain.User;
import com.ebim.esupplier.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeeder {
   /* private static final Logger log = LoggerFactory.getLogger(DataSeeder.class);

    @Bean
    CommandLineRunner seedAdmin(UserRepository users, PasswordEncoder enc) {
        return args -> {
            String adminUsername = "admin";
            users.findByUsername(adminUsername).ifPresentOrElse(u -> {
                log.info("Admin already exists: {}", u.getUsername());
            }, () -> {
                User admin = User.builder()
                        .username(adminUsername)
                        .email("admin@esupplier.local")
                        .password(enc.encode("Admin123!"))
                        .role("ROLE_ADMIN")
                        .enabled(true)
                        .build();
                users.save(admin);
                log.info("Created default admin user 'admin' with password 'Admin123!'");
            });
        };
    }*/
}
