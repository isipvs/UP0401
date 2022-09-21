package ru.mpt.p50_4_19.UP0401.models;


import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ordr")
public class POrder {

    @Id
    @Column(name = "id_ordr")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "note")
    private String note;

    @Column(name = "dtbeg")
    private LocalDateTime dtBeg;

    @Column(name = "dtend")
    private LocalDateTime dtEnd;

    @Column(name="mcost")
    private BigDecimal mcost;

    @ManyToOne
    @JoinColumn(name = "id_cus", referencedColumnName="id_cus")
    private PCus cus;

    @ManyToOne
    @JoinColumn(name = "id_empl", referencedColumnName="id_empl")
    private PEmpl empl;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public PCus getCus() {
        return cus;
    }
    public void setCus(PCus cus) {
        this.cus = cus;
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
    public void setDtBeg(LocalDateTime dBeg) {
        this.dtBeg = dBeg;
    }

    public LocalDateTime getDtEnd() {
        return dtEnd;
    }
    public void setDtEnd(LocalDateTime dEnd) {
        this.dtEnd = dEnd;
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

    public String getStatusName() {
        return "<not impl>";
    }
}
