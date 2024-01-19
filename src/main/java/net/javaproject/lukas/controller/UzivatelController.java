package net.javaproject.lukas.controller;

import net.javaproject.lukas.entity.Pojisteni;
import net.javaproject.lukas.entity.Uzivatel;
import net.javaproject.lukas.service.UzivatelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

public class UzivatelController {

    private UzivatelService uzivatelService;

    public UzivatelController(UzivatelService uzivatelService) {
        this.uzivatelService = uzivatelService;
    }
    //metóda na prenášanie zoznamu uživateľov a navrátenie náhľadu
    @GetMapping("/uzivatele")
    public String listUzivatele(Model model) {
        List<Uzivatel> uzivatelList = uzivatelService.getAllUzivatele();
        model.addAttribute("uzivatele", uzivatelList);
        return "uzivatele";
    }

    @GetMapping("/uzivatele/novy")
    public String createUzivatelForm(Model model) {
        //vytvori uzivatela ako objekt k udrzani uzivatelskych dat z formulara
        Uzivatel uzivatel = new Uzivatel();
        model.addAttribute("uzivatel", uzivatel);
        return "create_uzivatel";
    }

    @PostMapping("/uzivatele")
    public String saveUzivatel(@ModelAttribute("uzivatel") Uzivatel uzivatel) {
        uzivatelService.saveUzivatel(uzivatel);
        return "redirect:/uzivatele";
    }

    @GetMapping("/uzivatele/edit/{id}")
    public String editUzivatelForm(@PathVariable Long id, Model model) {
        model.addAttribute("uzivatel", uzivatelService.getUzivatelById(id));
        return "edit_uzivatel";
    }

    @PostMapping("/uzivatele/{id}")
    public String updateUzivatel(@PathVariable Long id, @ModelAttribute("uzivatel")Uzivatel uzivatel, Model model) {
        //ziskanie uzivatela z databaze podla jeho ID
        Uzivatel existingUzivatel = uzivatelService.getUzivatelById(id);
        existingUzivatel.setId(id);
        existingUzivatel.setJmeno(uzivatel.getJmeno());
        existingUzivatel.setPrijmeni(uzivatel.getPrijmeni());
        existingUzivatel.setPohlavi(uzivatel.getPohlavi());
        existingUzivatel.setEmail(uzivatel.getEmail());
        existingUzivatel.setTelefon(uzivatel.getTelefon());
        existingUzivatel.setUlice(uzivatel.getUlice());
        existingUzivatel.setMesto(uzivatel.getMesto());
        existingUzivatel.setPsc(uzivatel.getPsc());

        //ulozit updatovane uzivatelske objekty
        uzivatelService.updateUzivatel(existingUzivatel);
        return "redirect:/uzivatele";
    }

    //metoda k spravovaniu poziadavky na zmazanie uzivatela
    @GetMapping("/uzivatele/{id}")
    public String deleteUzivatel(@PathVariable Long id) {
        uzivatelService.deleteUzivatelById(id);
        return "redirect:/uzivatele";
    }

    @GetMapping("/pojisteni_list/user/{uzivatelId}")
    public String getPojisteniListForUser(@PathVariable Long uzivatelId, Model model) {
        // Získání uživatele z databáze pomocí uzivatelService
        Uzivatel uzivatel = uzivatelService.getUzivatelById(uzivatelId);

        // Získání seznamu pojištění pro konkrétního uživatele
        List<Pojisteni> pojisteniList = uzivatel.getPojisteniList();

        // Přidání seznamu pojištění do modelu pro použití v Thymeleaf šabloně
        model.addAttribute("pojisteniList", pojisteniList);

        // Přidání informací o uživateli do modelu (pokud je potřeba)
        model.addAttribute("uzivatel", uzivatel);

        // Návrat na stránku se seznamem pojištění pro uživatele
        return "pojisteni_list";  // Název Thymeleaf šablony (pojisteni_list.html)
    }

}
