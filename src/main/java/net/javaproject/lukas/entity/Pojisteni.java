package net.javaproject.lukas.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="pojisteni")
public class Pojisteni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "uzivatel_id") // Párování na Id uživatele tabulky Uzivatel
    private Uzivatel uzivatel;

    @Column(name = "typ")
    private String typ;

    @Column(name = "castka")
    private Integer castka;

    @Column(name = "predmet")
    private String predmet;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date platnostOd;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date platnostDo;

    public Pojisteni() {
    }

    //Date platnostOd, Date platnostDo - přidáno do konstruktoru
    public Pojisteni(String typ, Integer castka, String predmet, Date platnostOd, Date platnostDo) {
        super();
        this.typ = typ;
        this.castka = castka;
        this.predmet = predmet;
        this.platnostOd = platnostOd;
        this.platnostDo = platnostDo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Integer getCastka() {
        return castka;
    }

    public void setCastka(Integer castka) {
        this.castka = castka;
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public Uzivatel getUzivatel() {
        return uzivatel;
    }

    public void setUzivatel(Uzivatel uzivatel) {
        this.uzivatel = uzivatel;
    }

    public Date getPlatnostOd() {
        return platnostOd;
    }

    public void setPlatnostOd(Date platnostOd) {
        this.platnostOd = platnostOd;
    }

    public Date getPlatnostDo() {
        return platnostDo;
    }

    public void setPlatnostDo(Date platnostDo) {
        this.platnostDo = platnostDo;
    }
}