package com.naresh.bankingapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class DataSourceConfig {

	@Value("${dbUsername}")
	private String username;
	
	@Value("${dbPassword}")
	private String password;
	
	@Value("${dbUrl}")
	private String url;
	
	@Value("${driverClassName}")
	private String driverClassName;
	
	
	@Bean
	@Scope("singleton") //"prototype", "request", "application",session
	public DataSource dataSource() {
		System.out.println("Creating dataSource");
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		System.out.println("Creating jdbcTemplate");
		DataSource dataSource = dataSource();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		System.out.println("Creating SessionFactory");
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.naresh" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		// properties.put("hibernate.hbm2ddl.auto", "none");
		return properties;
	}

	@Bean
	public PlatformTransactionManager annotationDrivenTransactionManager(SessionFactory sessionFactory) {
		System.out.println("Creating TransactionManager" + sessionFactory);
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}

}
