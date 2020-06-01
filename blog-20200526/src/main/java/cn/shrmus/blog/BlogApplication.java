package cn.shrmus.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.solr.SolrRepositoriesAutoConfiguration;

@SpringBootApplication(exclude = SolrRepositoriesAutoConfiguration.class)
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
