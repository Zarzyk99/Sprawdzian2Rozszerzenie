package pl.kurs.clinicapp.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@Profile("dev")
@PropertySource("classpath:application-dev.properties")
public class DevConfiguration {

    @Bean
    public JpaVendorAdapter createVendorAdapterDev() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.H2);
        adapter.setShowSql(false);
        return adapter;
    }

    @Bean
    public DataSource createDataSourceDev() {
        BasicDataSource bds = new BasicDataSource();
        bds.setUrl("jdbc:h2:mem:testdb");
        bds.setUsername("Sa");
        bds.setPassword("");
        bds.setDriverClassName("org.h2.Driver");
        return bds;
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        Server tcpServer = Server.createWebServer();
        System.out.println(tcpServer.getURL());
        return tcpServer;
    }

}