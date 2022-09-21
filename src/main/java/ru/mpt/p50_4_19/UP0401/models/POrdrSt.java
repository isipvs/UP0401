package ru.mpt.p50_4_19.UP0401.models;

import javax.persistence.*;

@Entity
@Table(name = "ordr_st")
public class POrdrSt {

    @Id
    private Integer id;
    @Column(name = "name")
    private String name;

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
