package com.endurance.india.config;

import com.endurance.india.dao.TinyUrlMappingDao;
import com.endurance.india.dao.jdbc.TinyUrlMappingJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.endurance.india")
@PropertySource(value = {"classpath:settings.properties"})
public class SpringConfig {

    @Autowired
    private Environment environment;

    @Value("classpath:db/sql/create.sql")
    private Resource schemaScript;

    @Value("classpath:db/sql/populate.sql")
    private Resource dataScript;

//    @Bean
//    public DataSourceInitializer dataSourceInitializer() {
//        final DataSourceInitializer initializer = new DataSourceInitializer();
//        initializer.setDataSource(dataSource());
//        initializer.setDatabasePopulator(databasePopulator());
//        return initializer;
//    }

    private DatabasePopulator databasePopulator() {
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(schemaScript);
        populator.addScript(dataScript);
        return populator;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("DNS.DB.DRIVER"));
        dataSource.setUrl(environment.getRequiredProperty("DNS.DB.URL"));
        if (environment.getRequiredProperty("DNS.DB.USERNAME") != null && !environment.getRequiredProperty("DNS.DB.USERNAME").trim().equalsIgnoreCase("")) {
            dataSource.setUsername(environment.getRequiredProperty("DNS.DB.USERNAME"));
        }
        if (environment.getRequiredProperty("DNS.DB.PASSWORD") != null && !environment.getRequiredProperty("DNS.DB.PASSWORD").trim().equalsIgnoreCase("")) {
            dataSource.setPassword(environment.getRequiredProperty("DNS.DB.PASSWORD"));
        }
        return dataSource;
    }

    @Bean
    public TinyUrlMappingDao tinyUrlMappingDao() {
        TinyUrlMappingJdbcDao dao = new TinyUrlMappingJdbcDao();
        dao.setDataSource(dataSource());
        return dao;
    }

}