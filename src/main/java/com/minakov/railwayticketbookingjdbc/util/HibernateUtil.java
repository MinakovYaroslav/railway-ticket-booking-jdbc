package com.minakov.railwayticketbookingjdbc.util;

import com.minakov.railwayticketbookingjdbc.config.DatabaseConfiguration;
import com.minakov.railwayticketbookingjdbc.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateUtil {

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, DatabaseConfiguration.PROPERTY.getDriver());
                settings.put(Environment.URL, DatabaseConfiguration.PROPERTY.getUrl());
                settings.put(Environment.USER, DatabaseConfiguration.PROPERTY.getLogin());
                settings.put(Environment.PASS, DatabaseConfiguration.PROPERTY.getPassword());
                settings.put(Environment.DIALECT, DatabaseConfiguration.PROPERTY.getDialect());
                settings.put(Environment.HBM2DDL_AUTO, DatabaseConfiguration.PROPERTY.getHbm2ddlAuto());
                settings.put(Environment.SHOW_SQL, true);
                settings.put(Environment.FORMAT_SQL, true);
                settings.put(Environment.USE_SQL_COMMENTS, true);

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Station.class);
                configuration.addAnnotatedClass(Route.class);
                configuration.addAnnotatedClass(Wagon.class);
                configuration.addAnnotatedClass(Train.class);
                configuration.addAnnotatedClass(Cruise.class);
                configuration.addAnnotatedClass(Ticket.class);

                // Create registry
                registry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();

                // Create SessionFactory
                sessionFactory = configuration.buildSessionFactory(registry);

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
