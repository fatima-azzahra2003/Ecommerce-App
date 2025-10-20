package org.sid;

import org.sid.config.CustomerConfigParams;
import org.sid.entities.Customer;
import org.sid.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration repositoryRestConfiguration) {
        repositoryRestConfiguration.exposeIdsFor(Customer.class);
        return args -> {
            customerRepository.save(
                    new Customer(null, "yassine", "yassine@gmail.com")
            );
            customerRepository.save(
                    new Customer(null, "yahya", "yahya@gmail.com")
            );
            customerRepository.save(
                    new Customer(null, "ali", "ali@gmail.com")
            );
            customerRepository.findAll().forEach(c ->{
                System.out.println(c.toString());
            });

        };
    }

}