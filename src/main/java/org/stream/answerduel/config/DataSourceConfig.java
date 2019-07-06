package org.stream.answerduel.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * 功能描述：
 *
 * @Auther: 梁展鹏
 * @Date: 2018/7/17 14:54
 */
@SpringBootConfiguration
public class DataSourceConfig {

    @Bean(name = "dataSource")
    public DataSource dataSource(@Autowired Environment env) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        dataSource.setMinimumIdle(env.getProperty("spring.datasource.hikari.minimum-idle", Integer.class));
        dataSource.setMaximumPoolSize(env.getProperty("spring.datasource.hikari.maximum-pool-size", Integer.class));
        dataSource.setAutoCommit(env.getProperty("spring.datasource.hikari.auto-commit", Boolean.class));
        dataSource.setIdleTimeout(env.getProperty("spring.datasource.hikari.idle-timeout", Integer.class));
        dataSource.setPoolName(env.getProperty("spring.datasource.hikari.pool-name"));
        dataSource.setMaxLifetime(env.getProperty("spring.datasource.hikari.max-lifetime", Integer.class));
        dataSource.setConnectionTimeout(env.getProperty("spring.datasource.hikari.connection-timeout", Integer.class));
        dataSource.setConnectionTestQuery(env.getProperty("spring.datasource.hikari.connection-test-query"));
        return dataSource;
    }

}
