package com.config;

import com.model.dto.UserDTO;
import com.model.entity.user.Role;
import com.model.entity.user.User;
import com.model.service.util.SecurityUserDetailService;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.io.IOException;
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
    @Scope("singleton")
    public DriverManagerDataSource dataSourceBean() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/db_logistic");
        driverManagerDataSource.setUsername("db_logistic");
        driverManagerDataSource.setPassword("db_logistic_admin_26");

        Properties jdbcProperties = new Properties();
        jdbcProperties.setProperty("useUnicode", "true");
        jdbcProperties.setProperty("useJDBCCompliantTimezoneShift", "true");
        jdbcProperties.setProperty("useLegacyDatetimeCode", "false");
        jdbcProperties.setProperty("serverTimezone", "UTC");
        jdbcProperties.setProperty("show_sql", "true");

        driverManagerDataSource.setConnectionProperties(jdbcProperties);
        return driverManagerDataSource;
    }

    /**
     * Bean with Hibernate session factory.
     * @return session factory bean
     * @throws IOException throws if something wrong
     */
    @Bean(name = "sessionFactory")
    @Scope("prototype")
    public SessionFactory sessionFactory() throws IOException {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSourceBean());
        localSessionFactoryBean.setPackagesToScan("com.model.entity");
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        hibernateProperties.setProperty("show_sql", "true");
        localSessionFactoryBean.setHibernateProperties(hibernateProperties);
        localSessionFactoryBean.afterPropertiesSet();
        return localSessionFactoryBean.getObject();
    }

    ///////////////////////////////////////////////////////////////////////////
    // Security
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Spring Security bean, implemented USER instance from security context.
     * @return user bean
     */
    @Bean(name = "userDetailsService")
    @Scope("singleton")
    public UserDetailsService userDetailsService() {
        return new SecurityUserDetailService();
    }
    ///////////////////////////////////////////////////////////////////////////
    // Model Mappers
    ///////////////////////////////////////////////////////////////////////////
    /**
     * Bean with Model Mapper, which convert User to UserDTO instance
     * @return model mapper bean
     */
    @Bean(name = "userModelMapper")
    public ModelMapper userModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<User, UserDTO>() {
            @Override
            protected void configure() {
                map().setRole(source.getRole().getRole());
            }
        });
        modelMapper.addMappings(new PropertyMap<UserDTO, User>() {
            @Override
            protected void configure() {
                map().setRole(new Role(source.getRole()));
            }
        });
        return modelMapper;
    }


}
