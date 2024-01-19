package net.javaproject.lukas.service;

import net.javaproject.lukas.entity.Pojisteni;

import java.util.List;

public interface PojisteniService {

    List<Pojisteni> getAllPojisteni();

    Pojisteni savePojisteni (Pojisteni pojisteni);

    Pojisteni getPojisteniById(Long id);

    Pojisteni updatePojisteni (Pojisteni pojisteni);

    void deletePojisteniById(Long id);

}
