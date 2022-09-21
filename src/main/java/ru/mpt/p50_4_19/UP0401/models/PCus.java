package ru.mpt.p50_4_19.UP0401.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class PCus {

    @Id
    @Column(name = "id_cus")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;
    @NotEmpty
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @NotEmpty
    @Column(name = "phone", nullable = false)
    private String phone;

    @OneToMany(mappedBy = "cus")
    private List<POrder> orderList;

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

    public List<POrder> getOrderList() { return orderList;}
    public void setOrderList(List<POrder> orderList) {
        this.orderList = orderList;
    }
//    public PUsr getUsr() {
//        return usr;
//    }
//
//    public void setUsr(PUsr usr) {
//        this.usr = usr;
//    }
}
