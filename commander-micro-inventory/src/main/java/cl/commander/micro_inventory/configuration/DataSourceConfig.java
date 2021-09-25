package cl.commander.micro_inventory.configuration;

import java.sql.SQLException;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
						entityManagerFactoryRef = "entityManager",
						transactionManagerRef = "transactionManager",
						basePackages = "cl.commander.micro_inventory.repository"
						)
public class DataSourceConfig {
	
	@Autowired
	private Environment env;

	@Value("${commander.datasource.url}")
	private String url;	

	@Value("${commander.datasource.username}")
	private String username;	

	@Value("${commander.datasource.password}")
	private String password;	

	@Value("${setMaximumPoolSize}")
	private Integer maximumPoolSize;

	@Value("${setMinimumIdle}")
	private Integer minimumIdle;	

	@Value("${driverClassName}")
	private String driverClassName;	

	@Bean
	DataSource dataSource() throws SQLException {		

		HikariConfig config = new HikariConfig();
		config.setDriverClassName(driverClassName);
		config.setMaximumPoolSize(maximumPoolSize);
		config.setMinimumIdle(minimumIdle);
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(password);
		return new HikariDataSource(config);		
	}
	
	@Bean(name = "transactionManager")
	@Primary
    public PlatformTransactionManager transactionManager() throws SQLException {
       final JpaTransactionManager transactionManager = new JpaTransactionManager();
       transactionManager.setEntityManagerFactory(entityManager().getObject());
       return transactionManager;
    }
	
	@Bean(name="entityManager")
	@Primary
    public LocalContainerEntityManagerFactoryBean entityManager() throws SQLException {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPersistenceUnitName("address");
		em.setPackagesToScan("cl.commander.micro_inventory.model");
		em.setJpaVendorAdapter(this.vendorAdaptor());
		em.setJpaPropertyMap(this.jpaHibernateProperties());
		return em;
	}
	
	private HibernateJpaVendorAdapter vendorAdaptor() {
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        return vendorAdapter;
    }
 
	private HashMap<String, Object> jpaHibernateProperties() {
        final HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("commander.hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("commander.hibernate.dialect"));
        properties.put("hibernate.default_schema", env.getProperty("commander.hibernate.default_schema"));
        properties.put("show_sql", env.getProperty("commander.hibernate.show_sql"));
        properties.put("format_sql", env.getProperty("commander.hibernate.format_sql"));
        properties.put("use_sql_comments", env.getProperty("commander.hibernate.use_sql_comments"));
        return properties;
    }
}
