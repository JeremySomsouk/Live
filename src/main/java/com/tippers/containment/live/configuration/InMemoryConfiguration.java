package com.tippers.containment.live.configuration;

import com.tippers.containment.live.repository.UsersRepository;
import com.tippers.containment.live.repository.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class InMemoryConfiguration {

    @Bean
    CommandLineRunner initDatabase(UsersRepository repository) {
        return args -> {
            UserModel user1 = UserModel.builder().username("Bilbo Baggins").job("burglar").build();
            UserModel user2 = UserModel.builder().username("Frodo Baggins").job("thief").build();

            log.info("Preloading " + repository.save(user1));
            log.info("Preloading " + repository.save(user2));
        };
    }
}
