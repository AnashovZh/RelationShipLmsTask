package org.example.config;

import jakarta.persistence.EntityManager;
import org.example.model.Author;
import org.example.model.Book;
import org.example.model.Publisher;
import org.example.model.Reader;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateConfig {
    public static EntityManager getEntityManager() {
    Properties properties=new Properties();
        properties.setProperty(Environment.DRIVER,"org.postgresql.Driver");
        properties.setProperty(Environment.URL,"jdbc:postgresql://localhost:5432/postgres");
        properties.setProperty(Environment.USER,"postgres");
        properties.setProperty(Environment.PASS,"postgres");
        properties.setProperty(Environment.HBM2DDL_AUTO,"update");//validate//update//
        properties.setProperty(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty(Environment.SHOW_SQL,"true");

    org.hibernate.cfg.Configuration configuration=new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Author.class);
        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(Publisher.class);
        configuration.addAnnotatedClass(Reader.class);

        return configuration.buildSessionFactory().createEntityManager();
    }
}
