package ru.sfedu.coursezz.lab4.mapCollection.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Table
@Entity(name = "Map")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "CLIENT_ID")
    private long id;

    @Column
    private String cname;

    @Column
    private String login;

    @Column
    private String password;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Plan_map",
            joinColumns = @JoinColumn(name = "CLIENT_ID"))
    @MapKeyColumn (name = "name")
    @Column (name = "pname")
    protected Map<String, Plan> planList =  new HashMap<String, Plan>();

    public Client() {}

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return cname;
    }

    public void setName(String name) {
        this.cname = name;
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

    public void setPlanList(Map<String, Plan> planList) {
        this.planList = planList;
    }

    public Map<String, Plan> getPlanList() {
        return planList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                Objects.equals(cname, client.cname) &&
                Objects.equals(login, client.login) &&
                Objects.equals(password, client.password) &&
                Objects.equals(planList, client.planList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cname, login, password, planList);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + cname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", planList=" + planList +
                '}';
    }
}
