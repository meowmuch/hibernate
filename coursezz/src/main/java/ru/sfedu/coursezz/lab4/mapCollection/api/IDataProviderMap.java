package ru.sfedu.coursezz.lab4.mapCollection.api;

import ru.sfedu.coursezz.lab4.mapCollection.model.Plan;
import ru.sfedu.coursezz.models.enums.ResultType;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;


public interface IDataProviderMap {

    Long createPlan(String name);

    Long createClient(String name, String login, String password,
                      Map<String, Plan> planList);

    ResultType updateClient(Long id, String name, String login, String password,
                            Map<String, Plan> planList);

    ResultType getClient(Long id);

    ResultType deleteClient(Long Id);

    <T> void update(T cn);

    @Transactional
    <T> Optional<T> getById(Class<T> cn, Long id);

    <T> Long save(T cn);
}
