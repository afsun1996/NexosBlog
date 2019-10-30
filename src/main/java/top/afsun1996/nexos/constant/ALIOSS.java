package top.afsun1996.nexos.constant;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @program: NexosBlog
 * @description: 阿里OSS
 * @author: afsun
 * @create: 2019-09-23 11:33
 */
@Configuration
//@ConfigurationProperties(prefix = "oss",ignoreUnknownFields = false)
@PropertySource("classpath:alibabaoss.properties")
//@NoArgsConstructor
public class ALIOSS {

    public static String ALI_OSS_ENDPOINT;

    public static String ALI_OSS_ACCESSKEYID;

    public static String ALI_OSS_ACCESSKEYSECRET;

    public static String BACKET_NAME;

    public static  String FOLDER;

}