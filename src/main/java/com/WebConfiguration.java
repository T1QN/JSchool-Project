package com;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.Properties;

/**
 * Created by Mandrake on 04.07.2018.
 */
@Configuration
public class WebConfiguration {

    /**
     * Bean with definition on DB connection.
     * @return
     */
    @Bean
    public DriverManagerDataSource dataSourceBean() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/db_logistic");
        driverManagerDataSource.setUsername("db_logistic");
        driverManagerDataSource.setPassword("db_logistic_admin_26");
        return driverManagerDataSource;
    }

    /**
     * Bean with Hibernate session factory.
     * @return
     */
    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSourceBean());
        localSessionFactoryBean.setPackagesToScan("com.model.entity");
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        hibernateProperties.setProperty("show_sql", "true");
        localSessionFactoryBean.setHibernateProperties(hibernateProperties);
        return localSessionFactoryBean.getObject();
    }

    /**
     *
     * @return
     */
    @Bean
    public HibernateTemplate hibernateTemplateBean() {
        HibernateTemplate hibernateTemplate = new HibernateTemplate();
        hibernateTemplate.setSessionFactory(sessionFactory());
        return hibernateTemplate;
    }
}
