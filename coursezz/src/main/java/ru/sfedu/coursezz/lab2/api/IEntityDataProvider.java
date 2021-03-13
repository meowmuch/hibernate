package ru.sfedu.coursezz.lab2.api;

import ru.sfedu.coursezz.lab2.model.NewEntity;
import ru.sfedu.coursezz.lab2.model.TestEntity;
import ru.sfedu.coursezz.models.enums.ResultType;

import java.util.Date;
import java.util.Optional;

public interface IEntityDataProvider {
    public Long createEntity(String name, String description, Date dateCreated, Boolean check, NewEntity newEntity);
    public ResultType updateEntity(Long id, String name, String description, Date dateCreated, Boolean check, NewEntity newEntity);
    public void update(TestEntity entity);
    public ResultType delete(Long Id);
    public Optional<TestEntity> getById(Class<TestEntity> entity, Long id);
    public Long save(TestEntity entity);
}
