package ru.sfedu.coursezz.lab4.listCollection.api;

import ru.sfedu.coursezz.lab4.listCollection.model.Plan;
import ru.sfedu.coursezz.models.enums.ResultType;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface IDataProviderList {


    Long createPlan(String name);

    Long createClient(String cname, String login, String password,
                      List<Plan> planList);

    ResultType updateClient(Long id, String cname, String login, String password,
                            List<Plan> planList);

    ResultType getClient(Long id);

    ResultType deleteClient(Long Id);

    <T> void update(T cn);

    @Transactional
    <T> Optional<T> getById(Class<T> cn, Long id);

    <T> Long save(T cn);
}
