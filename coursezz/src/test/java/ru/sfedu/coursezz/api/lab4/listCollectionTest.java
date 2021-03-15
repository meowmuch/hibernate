package ru.sfedu.coursezz.api.lab4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import ru.sfedu.coursezz.lab4.listCollection.api.DataProviderList;
import ru.sfedu.coursezz.lab4.listCollection.api.IDataProviderList;
import ru.sfedu.coursezz.lab4.setCollection.model.Plan;
import ru.sfedu.coursezz.models.enums.ResultType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class listCollectionTest {

    public static Logger log = LogManager.getLogger(DataProviderList.class);
    IDataProviderList provider = new DataProviderList();

    public listCollectionTest(){}

    public List createPlan() {
        Plan firstPlan = new Plan(1, "Name plan");
        Plan secondPlan = new Plan(2, "Second Plan");
        List<Plan> plans = new ArrayList<>();
        plans.add(firstPlan);
        plans.add(secondPlan);
        return plans;
    }

    @Test
    public void createClient() {
        Long id = provider.createClient("Client name", "Login", "Password", createPlan());
        assertNotNull(id);
    }

    @Test
    public void updateClient() {
        Long id = provider.createClient("Client name", "Login", "Password", createPlan());
        assertEquals(ResultType.COMPLETE, provider.updateClient(id, " New client name", "New login", "Password", createPlan()));
    }

    @Test
    public void deleteClient() {
        Long id = provider.createClient("Client name", "Login", "Password", createPlan());
        assertEquals(ResultType.COMPLETE, provider.deleteClient(id));
    }

    @Test
    public void getClient() {
        Long id = provider.createClient("Client name", "Login", "Password", createPlan());
        assertEquals(ResultType.COMPLETE, provider.getClient(id));
    }


}
