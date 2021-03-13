package ru.sfedu.coursezz.api;

import org.junit.Test;

import java.util.List;
import static org.junit.Assert.*;

public class HibernateMetadataProviderTest {

    @Test
    public void getSchema() {
        System.out.println("getSchema");
        HibernateMetadataProvider instance = new HibernateMetadataProvider();
        List result = instance.getSchema();
        assertNotNull(result);
    }

    @Test
    public void getTables() {
        System.out.println("getTables");
        HibernateMetadataProvider instance = new HibernateMetadataProvider();
        List result = instance.getTables();
        assertNotNull(result);
    }

    @Test
    public void getSchemaName() {
        System.out.println("getSchemaName");
        HibernateMetadataProvider instance = new HibernateMetadataProvider();
        List result = instance.getSchemaName();
        assertNotNull(result);
    }

    @Test
    public void getDetails() {
        System.out.println("getDetails");
        HibernateMetadataProvider instance = new HibernateMetadataProvider();
        List result = instance.getDetails();
        assertNotNull(result);
    }

}
