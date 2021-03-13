package ru.sfedu.coursezz.api.lab4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import ru.sfedu.coursezz.lab4.setCollection.api.HibernateProvider;
import ru.sfedu.coursezz.lab4.setCollection.model.Client;

import java.util.*;

public class setCollectionTest {

    private Logger log = LogManager.getLogger(HibernateProvider.class);
    private HibernateProvider dp = new HibernateProvider();

    @Test
    public void createClient() {

        Set<String> namePlan = new HashSet<String>();
        namePlan.add("Plan1");
        namePlan.add("Plan2");
        Client client = new Client();
        client.setName("Lika");
        client.setLogin("log_in");
        client.setPassword("pass");
        client.setPlanList(namePlan);
        dp.createClient(client);
    }

    @Test
    public void getClients() {
        List<Client> clientList = dp.getClients();
        log.info(clientList);
    }

    @Test
    public void getChannelById() {
        long id = 1;
        Client client = dp.getClientById(id);
        log.info(client);
    }

    @Test
    public void deleteChannel() {
        long id = 2;
        Boolean isDeleted = dp.deleteClient(id);
        log.info(isDeleted);
    }

    @Test
    public void updateChannel() {
        long id = 3;
        Client client = dp.getClientById(id);
        client.setName("Ne_Lika");
        client = dp.updateClient(client);
        log.info(client);
    }
}
