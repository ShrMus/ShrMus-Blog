package cn.shrmus.blog.config.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpSolrClientConfiguration {

    @Value("${spring.data.solr.host}")
    private String solrHost;
    @Value("${solr.article.core.name}")
    private String ARTICLE_CORE;
    @Value("${solr.question.core.name}")
    private String QUESTION_CORE;
    @Value("${solr.resource.core.name}")
    private String RESOURCE_CORE;

    @Bean
    public SolrClient httpSolrClientArticle() {
        String solrUrl = this.solrHost + this.ARTICLE_CORE;
        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder(solrUrl)
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)
                .build();
        return httpSolrClient;
    }

    @Bean
    public SolrClient httpSolrClientQuestion() {
        String solrUrl = this.solrHost + this.QUESTION_CORE;
        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder(solrUrl)
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)
                .build();
        return httpSolrClient;
    }

    @Bean
    public SolrClient httpSolrClientResource() {
        String solrUrl = this.solrHost + this.RESOURCE_CORE;
        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder(solrUrl)
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)
                .build();
        return httpSolrClient;
    }

}
