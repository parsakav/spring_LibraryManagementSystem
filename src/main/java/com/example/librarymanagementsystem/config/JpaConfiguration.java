package com.example.librarymanagementsystem.config;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.librarymanagementsystem.repository")


public class JpaConfiguration {
    @Autowired
    @Bean
    public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {

        HibernateTemplate template = new HibernateTemplate();
        template.setSessionFactory(sessionFactory);
        return template;
    }
    @Autowired
    @Bean

    public LocalSessionFactoryBean factoryBean(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setPackagesToScan("/com/example/librarymanagementsystem/","/com/example/librarymanagementsystem/model","/com/example/librarymanagementsystem/repository");
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }

    @Autowired
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory);
        hibernateTransactionManager.setDataSource(dataSource());
        return hibernateTransactionManager;
    }



    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username("sa")
                .password("")
                .url("jdbc:h2:mem:libdb")
                .driverClassName("org.h2.Driver")
                .build();

    }

    @Bean(name="entityManagerFactory")
    @Autowired
    @Primary

    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource datasource, Properties hibernateProperties) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("/com/example/librarymanagementsystem/","/com/example/librarymanagementsystem/model","/com/example/librarymanagementsystem/repository");
        entityManagerFactoryBean.setDataSource(datasource);

        entityManagerFactoryBean.setJpaProperties(hibernateProperties);
        return entityManagerFactoryBean;
    }
    @Bean
    public Properties hibernateProperties() {

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.show_sql","true");
        //  hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");

        return hibernateProperties;
    }

}