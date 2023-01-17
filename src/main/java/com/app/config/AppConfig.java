package com.app.config;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.app.model.User;

@Configuration
@EnableTransactionManagement(proxyTargetClass = false)
@PropertySource("mydata.properties")
@ComponentScan(basePackages ="com.app")
public class AppConfig {
	@Autowired
	private Environment env;

	@Bean
	public DriverManagerDataSource dsObj() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("dcn"));
		ds.setUrl(env.getProperty("url"));
		ds.setUsername(env.getProperty("un"));
		ds.setPassword(env.getProperty("pwd"));
		return ds;
	}

	public Properties props() {
		Properties p = new Properties();
		p.put("hibernate.dialect", env.getProperty("dialects"));
		p.put("hibernate.show_sql", env.getProperty("showsql"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("hbmauto"));
		p.put("hibernate.format_sql", env.getProperty("formatsql"));
		return p;
	}

	@Bean
	public LocalSessionFactoryBean sfObj() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(dsObj());
		sf.setHibernateProperties(props());
		sf.setAnnotatedClasses(User.class);
		return sf;
	}
	
	@Bean
	public HibernateTemplate htObj() {
		HibernateTemplate ht = new HibernateTemplate();
		ht.setSessionFactory(sfObj().getObject());
		return ht;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager htxm = new HibernateTransactionManager();
		htxm.setSessionFactory(sfObj().getObject());
		return htxm;
	}
}
