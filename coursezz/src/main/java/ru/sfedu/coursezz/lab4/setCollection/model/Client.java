package ru.sfedu.coursezz.lab4.setCollection.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import ru.sfedu.coursezz.utils.Converters.PlanConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Table
@Entity (name = "Set")
public class Client implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @Column (name = "CLIENT_ID")
    private Long id;

    @Column
    private String name;


    @Column
    private String login;

    @Column
    private String password;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Plans",
            joinColumns = @JoinColumn(name = "CLIENT_ID"))
    @Column (name = "namePlan")
    protected Set<Plan> planList = new HashSet<Plan>();

    public Client() {}

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() { return login; }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPlanList(Set<Plan> planList) {
        this.planList = planList;
    }

    public Set<Plan> getPlanList() {
        return planList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                Objects.equals(name, client.name) &&
                Objects.equals(login, client.login) &&
                Objects.equals(password, client.password) &&
                Objects.equals(planList, client.planList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, password, planList);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", planList=" + planList +
                '}';
    }
}
