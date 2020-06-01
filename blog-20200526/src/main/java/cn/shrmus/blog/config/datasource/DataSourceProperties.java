package cn.shrmus.blog.config.datasource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = DataSourceProperties.PREFIX, ignoreUnknownFields = false)
@Data
public class DataSourceProperties {
    public final static String PREFIX = "spring.datasource";
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
