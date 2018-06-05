package hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner initBase(ContactRepository contactRepository){
        return (args) -> {
            contactRepository.save(new Contact("Nathan", "Folb", "Jambono", "nathan.folb@gmail.com", "0631489248"));
            contactRepository.save(new Contact("Tony", "Hun", "", "tony.hun@gmail.com", "06666666"));
            contactRepository.save(new Contact("Quentin", "wuattier", "passif", "quantin.wuatier@gmail.com", "066666666"));
        };
    }

}