package com.example.UP0401.models;

import javax.persistence.*;

@Entity
public class PCus {

    @Id
    @Column(name = "id_cus")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name, email, phone;

    @OneToOne(optional = false)
    private PUsr usr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public PUsr getUsr() {
        return usr;
    }

    public void setUsr(PUsr usr) {
        this.usr = usr;
    }
}
