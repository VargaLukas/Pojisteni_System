package net.javaproject.lukas.service;

import net.javaproject.lukas.entity.Uzivatel;

import java.util.List;

public interface UzivatelService {

    List<Uzivatel> getAllUzivatele();

    Uzivatel saveUzivatel (Uzivatel uzivatel);

    Uzivatel getUzivatelById(Long id);

    Uzivatel updateUzivatel (Uzivatel uzivatel);

    void deleteUzivatelById(Long id);

}
