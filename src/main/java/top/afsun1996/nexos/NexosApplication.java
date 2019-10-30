package top.afsun1996.nexos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import top.afsun1996.nexos.mapper.ArticleMapper;

@EnableTransactionManagement
@EnableScheduling
@ServletComponentScan(basePackages = "top.afsun1996.nexos.controller")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackageClasses = ArticleMapper.class)
public class NexosApplication {
    //sss
    public static void main(String[] args) {
        SpringApplication.run(NexosApplication.class, args);
    }

}
