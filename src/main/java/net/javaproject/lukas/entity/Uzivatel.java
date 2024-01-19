package net.javaproject.lukas.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="uzivatel")
public class Uzivatel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "uzivatel",cascade = CascadeType.ALL)
    private List<Pojisteni> pojisteniList = new ArrayList<>(); // Pozor! Uživatel může mít 0 druhů pojištění!!! Nenuluj!

    @Column (name = "jmeno", nullable = false)
    private String jmeno;

    @Column (name = "prijmeni", nullable = false)
    private String prijmeni;

    @Column (name = "pohlavi")
    private String pohlavi;

    @Column (name = "email")
    private String email;

    @Column (name = "telefon", nullable = false)
    private String telefon;

    @Column (name = "ulice", nullable = false)
    private String ulice;

    @Column (name = "mesto", nullable = false)
    private String mesto;

    @Column (name = "psc", nullable = false)
    private Integer psc;

    public Uzivatel() {
    }

    public Uzivatel(List<Pojisteni> pojisteniList, String jmeno, String prijmeni, String pohlavi, String email, String telefon, String ulice, String mesto, Integer psc) {
        super();
        this.jmeno = jmeno;
        this.pojisteniList = pojisteniList;
        this.prijmeni = prijmeni;
        this.pohlavi = pohlavi;
        this.email = email;
        this.telefon = telefon;
        this.ulice = ulice;
        this.mesto = mesto;
        this.psc = psc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getPohlavi() {return pohlavi; }

    public void setPohlavi(String pohlavi) {this.pohlavi = pohlavi;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public Integer getPsc() {
        return psc;
    }

    public void setPsc(Integer psc) {
        this.psc = psc;
    }

    public List<Pojisteni> getPojisteniList() {
        return pojisteniList;
    }

    public void setPojisteniList(List<Pojisteni> pojisteniList) {
        this.pojisteniList = pojisteniList;
    }
}


