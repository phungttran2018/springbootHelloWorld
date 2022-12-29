package com.phung.helloWorld.configuration;

import com.phung.helloWorld.configuration.multitenancy.TenantRoutingDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties({JpaProperties.class})
@EnableJpaRepositories(
        basePackages = "com/phung/helloWorld/repository/inventory",
        entityManagerFactoryRef = "inventoryEntityManager",
        transactionManagerRef = "inventoryTransactionManager"
)
@EnableTransactionManagement
public class DataSourceConfig {

    private static final Logger log = LoggerFactory.getLogger(DataSourceConfig.class);

    @Autowired
    JpaProperties jpaProperties;

    @Autowired
    DatasourceProperties datasourceProperties;

    public Map<Object, Object> buildDatasources(){
        Map<Object, Object> datasources = new HashMap<>();
        datasourceProperties.getDataSources().forEach((k,v)->{
            log.info("building datasource for {}", k);
            DataSourceBuilder builder = DataSourceBuilder.create()
                    .url(v.getUrl())
                    .username(v.getUsername())
                    .password(v.getPassword())
                    .driverClassName(v.getDriverClassName());
            datasources.put(k, builder.build());

        });
        return datasources;
    }


    @Bean
    public DataSource getDataSource(){
        TenantRoutingDataSource tenantRoutingDataSource = new TenantRoutingDataSource();
        tenantRoutingDataSource.setTargetDataSources(buildDatasources());
        tenantRoutingDataSource.afterPropertiesSet();
        log.info("tenantRoutingDataSource {}", tenantRoutingDataSource);
        return tenantRoutingDataSource;
    }

    @Bean(name = "inventoryEntityManager")
    public LocalContainerEntityManagerFactoryBean inventoryEntityManager(EntityManagerFactoryBuilder builder) {
        log.info("Multitenant inventory datasource configuration started");
        return builder.dataSource(getDataSource()).packages("com/phung/helloWorld/model/inventory")
                .build();
//        LocalContainerEntityManagerFactoryBean em
//                = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(getDataSource());
//        em.setPackagesToScan( "com/phung/helloWorld/model/inventory" );
//
//        HibernateJpaVendorAdapter vendorAdapter
//                = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto",
//                env.getProperty("hibernate.hbm2ddl.auto"));
//        properties.put("hibernate.dialect",
//                env.getProperty("hibernate.dialect"));
//        em.setJpaPropertyMap(properties);
//
//        return em;
    }

    @Bean(name = "inventoryTransactionManager")
    public JpaTransactionManager inventoryTransactionManager(
            @Autowired @Qualifier("inventoryEntityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
    }
}
