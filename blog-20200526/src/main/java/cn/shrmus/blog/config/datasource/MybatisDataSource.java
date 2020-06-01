package cn.shrmus.blog.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(value = DataSourceProperties.class)
@MapperScan("cn.shrmus.blog.mapper")
public class MybatisDataSource {
    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Value("${mybatis.mapper-locations}")
    private String MAPPER_LOCATIONS;

    private DruidDataSource pool;

    /**
     * 注入数据库连接池
     * @return
     * @throws Exception
     */
    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws  Exception {
        DataSourceProperties config = dataSourceProperties;
        this.pool = new DruidDataSource();
        this.pool.setDriverClassName(config.getDriverClassName());
        this.pool.setUrl(config.getUrl());
        this.pool.setUsername(config.getUsername());
        this.pool.setPassword(config.getPassword());
        return this.pool;
    }

    @PreDestroy
    public void close() {
        if (this.pool != null) {
            this.pool.close();
        }
    }

    /**
     * 注入SQL会话工厂
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(this.MAPPER_LOCATIONS));
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 注入事务管理器
     * @return
     * @throws Exception
     */
    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource());
        return dataSourceTransactionManager;
    }
}
