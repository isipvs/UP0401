package ru.mpt.p50_4_19.UP0401.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "v_mst_item_list")
public class PItemRpr {

    @Id
    @Column(name = "id_item")
    private Integer id;

    @Column(name = "id_empl")
    private Integer emplId;

    @Column(name = "id_titem")
    private Integer typeId;

    @Column(name = "t_name")
    private String typeName;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "note", nullable = true)
    private String note;

    @Column(name = "dtbeg")
    private LocalDateTime dtBeg;

    @Column(name = "dtend")
    private LocalDateTime dtEnd;

    public PItemRpr() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getEmplId() {
        return emplId;
    }

    public void setEmplId(Integer emplId) {
        this.emplId = emplId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getDtBeg() {
        return dtBeg;
    }

    public void setDtBeg(LocalDateTime dtBeg) {
        this.dtBeg = dtBeg;
    }

    public LocalDateTime getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(LocalDateTime dtEnd) {
        this.dtEnd = dtEnd;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Transient
    public boolean isClosed() {
        return getDtEnd() != null;
    }

    @Transient
    public boolean isWaiting() {
        return getDtBeg() == null;
    }

    @Transient
    public int getStatus()
    {
        if( getDtBeg() == null )
            return 1;
        if( getDtEnd() == null )
            return 2;
        return 3;
    }

}
