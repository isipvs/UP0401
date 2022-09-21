package ru.mpt.p50_4_19.UP0401.models;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ordr")
public class POrder {

    @Id
    @Column(name = "id_ordr")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "note")
    private String note;

    @Column(name = "dbeg")
    private LocalDate dBeg;

    @Column(name = "dend")
    private LocalDate dEnd;

    @Column(name="mcost")
    private BigDecimal mcost;

    @ManyToOne
    @JoinColumn(name = "id_cus", referencedColumnName="id_cus")
    private PCus cus;

    @ManyToOne
    @JoinColumn(name = "id_empl", referencedColumnName="id_empl")
    private PEmpl empl;

    public PCus getCus() {
        return cus;
    }
    public void setCus(PCus cus) {
        this.cus = cus;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getDBeg() {
        return dBeg;
    }
    public void setDBeg(LocalDate dBeg) {
        this.dBeg = dBeg;
    }

    public LocalDate getDEnd() {
        return dEnd;
    }
    public void setDEnd(LocalDate dEnd) {
        this.dEnd = dEnd;
    }

    public BigDecimal getMCost() {
        return mcost;
    }
    public void setMCost(BigDecimal mcost) {
        this.mcost = mcost;
    }

    public PEmpl getEmpl() {
        return empl;
    }
    public void setEmpl(PEmpl empl) {
        this.empl = empl;
    }
}
