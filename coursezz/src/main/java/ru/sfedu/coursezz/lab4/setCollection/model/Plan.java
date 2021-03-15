package ru.sfedu.coursezz.lab4.setCollection.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import ru.sfedu.coursezz.models.Book;
import ru.sfedu.coursezz.utils.Converters.BookConverter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class Plan implements Serializable {


    @Column (nullable = true)
    private Long id;

    @Column (nullable = true)
    private String name;




    public Plan() {}


    public Plan(long id, String name) {
        this.id = id;
        this.name = name;

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return id == plan.id &&
                Objects.equals(name, plan.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }



}
