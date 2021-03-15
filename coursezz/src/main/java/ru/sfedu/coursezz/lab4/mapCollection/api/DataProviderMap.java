package ru.sfedu.coursezz.lab4.mapCollection.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.sfedu.coursezz.lab4.mapCollection.model.Client;
import ru.sfedu.coursezz.lab4.mapCollection.model.Plan;
import ru.sfedu.coursezz.models.enums.ResultType;
import ru.sfedu.coursezz.utils.HibernateUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Map;


public class DataProviderMap implements IDataProviderMap {

    public static Logger log = LogManager.getLogger(ru.sfedu.coursezz.lab4.mapCollection.api.DataProviderMap.class);
    static Session session;

    @Override
    public Long createPlan(String name) {
        Plan plan = new Plan();
        plan.setName(name);
        log.debug("Initializing bean:" + plan);
        Long id = this.save(plan);
        log.debug("Saving plan with id: " + id);
        return id;
    }

    @Override
    public Long createClient(String cname, String login, String password,
                             Map<String, Plan> planList) {
        Client client = new Client();
        client.setName(cname);
        client.setLogin(login);
        client.setPassword(password);
        client.setPlanList(planList);
        log.debug("Initializing bean:" + client);
        Long id = this.save(client);
        log.debug("Saving plan with id: " + id);
        return id;
    }

    @Override
    public ResultType updateClient(Long id, String cname, String login, String password,
                                   Map<String, Plan> planList) {
        try {
            log.debug("In updateFilm method");
            Client client = getById(Client.class, id).get();
            client.setName(cname);
            client.setLogin(login);
            client.setPassword(password);
            client.setPlanList(planList);
            this.update(client);
            return ResultType.COMPLETE;
        } catch (NoSuchElementException e) {
            log.error("Updating bean error");
            return ResultType.FAIL;
        }

    }

    @Override
    public ResultType getClient(Long id) {
        try {
            log.debug("In getClient method");
            Client client = getById(Client.class, id).get();
            return ResultType.COMPLETE;
        } catch (NoSuchElementException e) {
            log.error("Get bean error");
            return ResultType.FAIL;
        }

    }

    @Override
    public ResultType deleteClient(Long Id) {
        log.debug("On deleteClient method");
        try {
            session = this.getSession();
            Client client = this.getById(Client.class, Id).get();
            Transaction transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
            return ResultType.COMPLETE;
        } catch (IOException | NoSuchElementException e) {
            log.error(e);
            return ResultType.FAIL;

        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public <T> void update(T cn) {
        try {
            session = this.getSession();
            Transaction transaction = session.beginTransaction();
            session.update(cn);
            transaction.commit();
        } catch (IOException | NonUniqueObjectException e) {
            log.error(e);
        } finally {
            if (session != null) session.close();
        }
    }


    @Override
    @Transactional
    public <T> Optional<T> getById(Class<T> cn, Long id) {
        try {
            Session session = this.getSession();
            T resultBean = session.get(cn, id);
            log.debug("Returned entity: " + resultBean.toString());
            session.close();
            return Optional.of(resultBean);
        } catch (IOException | NullPointerException e) {
            log.error(e);
            return Optional.empty();
        }
    }

    @Override
    public <T> Long save(T cn) {
        try {
            session = this.getSession();
            Transaction transaction = session.beginTransaction();
            Long id = (Long) session.save(cn);
            transaction.commit();
            log.debug("Saving bean with the id: " + id.toString());
            return id;
        } catch (IOException e) {
            log.error(e);
            return null;
        } finally {
            if (session != null) session.close();
        }
    }

    private Session getSession() throws IOException {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        return factory.openSession();
    }
}
