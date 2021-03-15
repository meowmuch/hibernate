package ru.sfedu.coursezz.api.lab4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import ru.sfedu.coursezz.lab4.mapCollection.api.DataProviderMap;
import ru.sfedu.coursezz.lab4.mapCollection.api.IDataProviderMap;
import ru.sfedu.coursezz.lab4.mapCollection.model.Plan;
import ru.sfedu.coursezz.lab4.mapCollection.model.Client;
import ru.sfedu.coursezz.models.enums.ResultType;

import java.util.HashMap;

import java.util.*;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class mapCollectionTest {

    public static Logger log = LogManager.getLogger(mapCollectionTest.class);
    IDataProviderMap provider = new DataProviderMap();

    public mapCollectionTest(){}


    public Map createPlans() {
        Plan firstPlan = new Plan(5, "Name plan");
        Plan secondPlan = new Plan(8, "Second Plan");
        Map<String, Plan> plan = new HashMap<>();
        plan.put(firstPlan.getName(),firstPlan);
        plan.put(secondPlan.getName(), secondPlan);
        return plan;
    }

    @Test
    public void createClient() {
        Long id = provider.createClient("Client name", "Login", "Password", createPlans());
        assertNotNull(id);
    }

    @Test
    public void updateClient() {
        Long id = provider.createClient("Client name", "Login", "Password", createPlans());
        assertEquals(ResultType.COMPLETE, provider.updateClient(id, " New client name", "New login", "Password", createPlans()));
    }

    @Test
    public void deleteClient() {
        Long id = provider.createClient("Client name", "Login", "Password", createPlans());
        assertEquals(ResultType.COMPLETE, provider.deleteClient(id));
    }

    @Test
    public void getClient() {
        Long id = provider.createClient("Client name", "Login", "Password", createPlans());
        assertEquals(ResultType.COMPLETE, provider.getClient(id));
    }


}
