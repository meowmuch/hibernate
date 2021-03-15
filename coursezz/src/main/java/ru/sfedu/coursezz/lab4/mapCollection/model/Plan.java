package ru.sfedu.coursezz.lab4.mapCollection.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Class Plan
 */
@Embeddable
public class Plan implements Serializable {


    @Column (name = "PlanId", nullable = true)
    private Long id;

    @Column (nullable = true)
    private String pname;




    public Plan() {}


    public Plan(long id, String pname) {
        this.id = id;
        this.pname = pname;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return pname;
    }

    public void setName(String name) {
        this.pname = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return id == plan.id &&
                Objects.equals(pname, plan.pname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pname);
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", name='" + pname + '\'' +
                '}';
    }



}
