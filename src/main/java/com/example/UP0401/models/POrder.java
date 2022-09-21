package com.example.UP0401.models;


import javax.persistence.*;

@Entity
@Table(name = "ordr")
public class POrder {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cus")
    private PCus PCus;

    public PCus getPCus() {
        return PCus;
    }

    public void setPCus(PCus PCus) {
        this.PCus = PCus;
    }
}
