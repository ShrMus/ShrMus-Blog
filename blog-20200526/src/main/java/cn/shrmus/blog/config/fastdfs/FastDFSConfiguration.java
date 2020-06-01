package cn.shrmus.blog.config.fastdfs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(
        value = "classpath:config/fastdfsconfig.properties"
)
@Configuration
public class FastDFSConfiguration {
}
