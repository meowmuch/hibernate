package ru.sfedu.coursezz.lab4.setCollection.api;

import ru.sfedu.coursezz.lab4.setCollection.model.Plan;
import ru.sfedu.coursezz.models.enums.ResultType;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

public interface IDataProviderSet {
    Long createPlan(String name);

    Long createClient(String name, String login, String password,
                      Set<Plan> planList);

    ResultType updateClient(Long id, String name, String login, String password,
                            Set<Plan> planList);

    ResultType getClient(Long id);

    ResultType deleteClient(Long Id);

    <T> void update(T cn);

    @Transactional
    <T> Optional<T> getById(Class<T> cn, Long id);

    <T> Long save(T cn);
}
