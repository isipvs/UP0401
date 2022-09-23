package ru.mpt.p50_4_19.UP0401.models;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item")
public class PItem {

    @Id
    @Column(name = "id_item")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_titem")
    private Integer typeId;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "note", nullable = true)
    private String note;

    @Column(name = "dtbeg")
    private LocalDateTime dtBeg;

    @Column(name = "dtend")
    private LocalDateTime dtEnd;

    @ManyToOne
    @JoinColumn(name = "id_empl", referencedColumnName="id_empl")
    @Lazy
    private PEmpl empl;

    public PItem( ) {
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

    public PEmpl getEmpl() {
        return empl;
    }
    public void setEmpl(PEmpl empl) {
        this.empl = empl;
    }

    @Transient
    public boolean isClosed()
    {
        return getDtEnd() != null;
    }
}
