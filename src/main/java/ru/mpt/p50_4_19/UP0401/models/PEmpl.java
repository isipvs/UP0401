package ru.mpt.p50_4_19.UP0401.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name = "empl")
public class PEmpl {

    @Id
    @Column(name = "id_empl")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "f_name", nullable = false)
    private String fName;
    @Column(name = "l_name", nullable = false)
    private String lName;
    @Column(name = "m_name", nullable = false)
    private String mName;

    @Email
    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_dol", referencedColumnName="id_dol")
    private PDol dol;

    @OneToMany(mappedBy = "empl")
    private List<POrder> orderList;

    @OneToMany(mappedBy = "empl")
    private List<PItem> itemList;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFName() {
        return fName;
    }
    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }
    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getMName() {
        return mName;
    }
    public void setMName(String mName) {
        this.mName = mName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public PDol getDol() {
        return dol;
    }
    public void setDol(PDol dol) {
        this.dol = dol;
    }

    public List<POrder> getOrderList() {
        return orderList;
    }
    public void setOrderList(List<POrder> orderList) {
        this.orderList = orderList;
    }

    // Список изделий в ремонте
    public List<PItem> getItemList() {
        return itemList;
    }
    public void setItemList(List<PItem> itemList) {
        this.itemList = itemList;
    }
}
