package ru.mpt.p50_4_19.UP0401.models;

import javax.persistence.*;

@Entity
@Table(name = "usr")
public class PUsr {
    @Id
    @Column(name = "id_usr")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_rol")
    private Integer roleId;
    @Column(name = "login")
    private String login;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
}
