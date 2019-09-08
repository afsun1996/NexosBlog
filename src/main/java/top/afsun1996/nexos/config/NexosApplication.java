package top.afsun1996.nexos.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableTransactionManagement
@EnableWebMvc
@EnableScheduling
@SpringBootApplication
public class NexosApplication {

    public static void main(String[] args) {
        SpringApplication.run(NexosApplication.class, args);
    }

}
