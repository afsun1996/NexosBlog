package top.afsun1996.nexos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@EnableTransactionManagement
@EnableWebMvc
@EnableScheduling
@ServletComponentScan(basePackages = "top.afsun1996.nexos.controller")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class NexosApplication {

    public static void main(String[] args) {
        SpringApplication.run(NexosApplication.class, args);
    }

}
