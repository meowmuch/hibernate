package ru.sfedu.coursezz.lab4.listCollection.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Class Plan
 */
@Embeddable
public class Plan implements Serializable {


    @Column (nullable = true)
    private long planId;

    @Column (nullable = true)
    private String pname;




    public Plan() {}


    public Plan(long planId, String pname) {
        this.planId = planId;
        this.pname = pname;

    }

    public void setId(long planId) {
        this.planId = planId;
    }

    public long getId() {
        return planId;
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
        return planId == plan.planId &&
                Objects.equals(pname, plan.pname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planId, pname);
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + planId +
                ", name='" + pname + '\'' +
                '}';
    }



}
