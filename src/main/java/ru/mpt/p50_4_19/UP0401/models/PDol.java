package ru.mpt.p50_4_19.UP0401.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "dol")
public class PDol {
    @Id
    @Column(name = "id_dol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false)
    @NotEmpty
    private String name;
    @OneToMany(mappedBy = "dol")
    private List<PEmpl> emplList;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<PEmpl> getEmplList() {
        return emplList;
    }
    public void setEmplList(List<PEmpl> emplList) {
        this.emplList = emplList;
    }
}