package ru.sfedu.coursezz.utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.sfedu.coursezz.lab2.model.TestEntity;
import ru.sfedu.coursezz.lab3.MappedSuperclass.model.Article;
import ru.sfedu.coursezz.lab3.MappedSuperclass.model.Book;
import ru.sfedu.coursezz.lab3.MappedSuperclass.model.Film;
import ru.sfedu.coursezz.lab3.MappedSuperclass.model.InfoRes;
import ru.sfedu.coursezz.lab4.setCollection.model.Client;

import java.io.File;
import java.io.IOException;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static Logger log = LogManager.getLogger(SessionFactory.class);
    private static final String USER_CONFIG_PATH = System.getenv("config");


    public static SessionFactory getSessionFactory() throws IOException {

        if (sessionFactory == null) {
            // loads configuration and mappings
            String filepath =  (USER_CONFIG_PATH ==null) ? (ConfigurationUtil.getConfigurationEntry("PATH_TO_CFG_XML")) :(USER_CONFIG_PATH);
            log.debug(filepath);
            File file = new File(filepath);
            Configuration configuration = new Configuration().configure(file);
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            MetadataSources metadataSources =
                    new MetadataSources(serviceRegistry);
            addEntities(metadataSources);
            Metadata metadata =  metadataSources.getMetadataBuilder().build();
            sessionFactory =   metadata.getSessionFactoryBuilder().build();
        }

        return sessionFactory;
    }

    private static void addEntities(MetadataSources metadataSources){
        metadataSources.addAnnotatedClass(TestEntity.class);
        metadataSources.addAnnotatedClass(InfoRes.class);
        metadataSources.addAnnotatedClass(Book.class);
        metadataSources.addAnnotatedClass(Article.class);
        metadataSources.addAnnotatedClass(Film.class);
        metadataSources.addAnnotatedClass(ru.sfedu.coursezz.lab3.TablePerClass.model.InfoRes.class);
        metadataSources.addAnnotatedClass(ru.sfedu.coursezz.lab3.TablePerClass.model.Book.class);
        metadataSources.addAnnotatedClass(ru.sfedu.coursezz.lab3.TablePerClass.model.Article.class);
        metadataSources.addAnnotatedClass(ru.sfedu.coursezz.lab3.TablePerClass.model.Film.class);
        metadataSources.addAnnotatedClass(ru.sfedu.coursezz.lab3.SingleTable.model.InfoRes.class);
        metadataSources.addAnnotatedClass(ru.sfedu.coursezz.lab3.SingleTable.model.Book.class);
        metadataSources.addAnnotatedClass(ru.sfedu.coursezz.lab3.SingleTable.model.Article.class);
        metadataSources.addAnnotatedClass(ru.sfedu.coursezz.lab3.SingleTable.model.Film.class);
        metadataSources.addAnnotatedClass(ru.sfedu.coursezz.lab3.JoinedTable.model.InfoRes.class);
        metadataSources.addAnnotatedClass(ru.sfedu.coursezz.lab3.JoinedTable.model.Book.class);
        metadataSources.addAnnotatedClass(ru.sfedu.coursezz.lab3.JoinedTable.model.Article.class);
        metadataSources.addAnnotatedClass(ru.sfedu.coursezz.lab3.JoinedTable.model.Film.class);
        metadataSources.addAnnotatedClass(Client.class);

    }
}