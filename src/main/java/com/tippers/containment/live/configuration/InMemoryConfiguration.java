package com.tippers.containment.live.configuration;

import com.tippers.containment.live.repository.model.mysql.Products;
import com.tippers.containment.live.repository.model.postgres.Orders;
import com.tippers.containment.live.repository.model.postgres.Users;
import com.tippers.containment.live.repository.model.redis.Invoice;
import com.tippers.containment.live.repository.mysql.ProductsRepository;
import com.tippers.containment.live.repository.postgres.OrdersRepository;
import com.tippers.containment.live.repository.postgres.UsersRepository;
import com.tippers.containment.live.repository.redis.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.UUID;

@Configuration
@Slf4j
public class InMemoryConfiguration {

    @Bean
    CommandLineRunner initDatabase(UsersRepository usersRepository,
                                   OrdersRepository ordersRepository,
                                   ProductsRepository productsRepository,
                                   InvoiceRepository invoiceRepository) {
        return args -> {
            Users user1 = Users.builder().username("Bilbo Baggins").job("burglar").build();
            Users user2 = Users.builder().username("Frodo Baggins").job("thief").build();

            Orders order1 = Orders.builder().deliveryAddress("address1").build();
            Orders order2 = Orders.builder().deliveryAddress("address2").build();

            Products product1 = Products.builder().id((long) 1).name("product1").build();
            Products product2 = Products.builder().id((long) 2).name("product2").build();

            Invoice invoice1 = Invoice.builder().reference("inv1").build();
            Invoice invoice2 = Invoice.builder().id(UUID.randomUUID()).reference("inv2").build();

            log.info("Preloading PostgreSQL " + usersRepository.save(user1));
            log.info("Preloading PostgreSQL " + usersRepository.save(user2));
            log.info("Preloading PostgreSQL " + ordersRepository.save(order1));
            log.info("Preloading PostgreSQL " + ordersRepository.save(order2));
            log.info("Preloading MySQL " + productsRepository.save(product1));
            log.info("Preloading MySQL " + productsRepository.save(product2));
            log.info("Preloading Redis " + invoiceRepository.save(invoice1));
            log.info("Preloading Redis " + invoiceRepository.save(invoice2));
        };
    }
}
