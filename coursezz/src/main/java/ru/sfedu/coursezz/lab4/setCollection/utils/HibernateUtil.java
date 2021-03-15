package ru.sfedu.coursezz.lab4.setCollection.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import ru.sfedu.coursezz.lab2.model.TestEntity;
import ru.sfedu.coursezz.lab3.MappedSuperclass.model.InfoRes;
import ru.sfedu.coursezz.lab4.setCollection.model.Client;

import java.io.File;

public class HibernateUtil {

    private static final String CUSTOM_CONFIG_PATH = System.getProperty("hibernatePath");

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration;
            if (CUSTOM_CONFIG_PATH != null) {
                configuration = new Configuration().configure(new File(CUSTOM_CONFIG_PATH));
            } else {
                configuration = new Configuration();
            }
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            MetadataSources metadataSources =
                    new MetadataSources(serviceRegistry);
            addEntities(metadataSources);
            sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        }

        return sessionFactory;
    }

    private static void addEntities(MetadataSources metadataSources) {
        metadataSources.addAnnotatedClass(Client.class);
    }
}
