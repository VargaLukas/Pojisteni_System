package net.javaproject.lukas.controller;

import net.javaproject.lukas.entity.Pojisteni;
import net.javaproject.lukas.entity.Uzivatel;
import net.javaproject.lukas.service.PojisteniService;
import net.javaproject.lukas.service.UzivatelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PojisteniController {


    private PojisteniService pojisteniService;
    private UzivatelService uzivatelService;

    //Konstruktor -start
    public PojisteniController(PojisteniService pojisteniService, UzivatelService uzivatelService) {
        this.pojisteniService = pojisteniService;
        this.uzivatelService = uzivatelService;
    }
    //metóda na prenášanie zoznamu poistenia a navrátenie náhľadu

    //Konstruktor - end

    @ModelAttribute("uzivatelList")
    public List<Uzivatel> uzivatelList() {
        return uzivatelService.getAllUzivatele();
    }

    @GetMapping("/pojisteni_list")
    public String listPojisteni(Model model) {
        model.addAttribute("pojisteni_list", pojisteniService.getAllPojisteni());
        return "pojisteni_list";
    } //

    @GetMapping("/pojisteni_list/nove")
    public String createPojisteniForm(Model model) {
        //vytvori poistenie ako objekt k udrzani uzivatelskych dat z formulara
        List<Uzivatel> uzivatele = uzivatelService.getAllUzivatele();
        Pojisteni pojisteni = new Pojisteni();
        model.addAttribute("pojisteni",pojisteni);
        model.addAttribute("uzivatele", uzivatele);
        return "create_pojisteni";
    }
    @PostMapping("/pojisteni_list")
    public String savePojisteni(@ModelAttribute("pojisteni") Pojisteni pojisteni) {
        try {
            // Logování hodnot před uložením
            System.out.println("platnostOd: " + pojisteni.getPlatnostOd());
            System.out.println("platnostDo: " + pojisteni.getPlatnostDo());

            // Získání uživatele z databáze pomocí uzivatelService
            Uzivatel uzivatel = uzivatelService.getUzivatelById(pojisteni.getUzivatel().getId());

            // Nastavení reference na uživatele ve vytvořeném pojištění
            pojisteni.setUzivatel(uzivatel);

            pojisteniService.savePojisteni(pojisteni);
            return "redirect:/pojisteni_list/user/" + uzivatel.getId();
        } catch (Exception e) {
            // Logování výjimky
            e.printStackTrace();
            return "redirect:/error"; // Upravte dle potřeby
        }
    }

    @GetMapping("/pojisteni_list/edit/{id}")
    public String editPojisteniForm(@PathVariable Long id, Model model) {
        model.addAttribute("pojisteni", pojisteniService.getPojisteniById(id));
        return "edit_pojisteni";
    }

    @PostMapping("/pojisteni_list/{id}")
    public String updatePojisteni(@PathVariable Long id, @ModelAttribute("pojisteni") Pojisteni pojisteni, Model model) {
        //ziskanie poistenia z databaze podla jeho ID
        Pojisteni existingPojisteni = pojisteniService.getPojisteniById(id);
        existingPojisteni.setId(id);
        existingPojisteni.setTyp(pojisteni.getTyp());
        existingPojisteni.setCastka(pojisteni.getCastka());
        existingPojisteni.setPredmet(pojisteni.getPredmet());
        existingPojisteni.setPlatnostOd(pojisteni.getPlatnostOd());
        existingPojisteni.setPlatnostDo(pojisteni.getPlatnostDo());

        //ulozit updatovane poistovacie objekty
        pojisteniService.updatePojisteni(existingPojisteni);
        return "redirect:/pojisteni_list/user/" + existingPojisteni.getUzivatel().getId();
    }

    //metoda k spravovaniu poziadavky na zmazanie poistenia
    @GetMapping("/pojisteni_list/delete/{id}")
    public String deletePojisteni(@PathVariable Long id) {
        Optional<Pojisteni> pojisteni = Optional.ofNullable(pojisteniService.getPojisteniById(id));

        if (pojisteni.isPresent()) {
            // Získání ID uživatele, kterému pojištění patří
            Long userId = pojisteni.get().getUzivatel().getId();

            pojisteniService.deletePojisteniById(id);

            // Přesměrování na stránku s uživateli
            return "redirect:/pojisteni_list/user/" + userId;
        } else {
            // Pokud entita s daným ID neexistuje,
            // Zde používám přesměrování na seznam uzivatelu.
            return "redirect:/uzivatele";
        }
    }

}
