package net.javaproject.lukas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LinkController {

    @GetMapping("/index")
    public String indexPage(Model model) {
        model.addAttribute("pageTitle", "Domů");
        return "index"; // Název Thymeleaf šablony (index.html)
    }

    @GetMapping("/o_aplikaci")
    public String oAplikaciPage(Model model) {
        // Přidání atributu pro Thymeleaf šablonu
        model.addAttribute("pageTitle", "O aplikaci");
        return "o_aplikaci"; // Název Thymeleaf šablony (aplikaci.html)
    }

    @GetMapping("/udalosti")
    public String udalostiPage(Model model) {
        model.addAttribute("pageTitle", "Události");
        return "udalosti"; // Název Thymeleaf šablony (udalosti.html)
    }

    @GetMapping("/prehled_pojisteni")
    public String prehledUdalostiPage(Model model) {
        model.addAttribute("pageTitle", "Přehled pojištění");
        return "prehled_pojisteni"; // Název Thymeleaf šablony (prehled_pojisteni.html)
    }

    @GetMapping("/nova_udalost")
    public String novaUdalostPage(Model model) {
        model.addAttribute("pageTitle", "Nová událost");
        return "nova_udalost"; // Název Thymeleaf šablony (nova_udalost.html)
    }

    @GetMapping("/pojisteni_majetku")
    public String pojisteniMajetkuPage(Model model) {
        model.addAttribute("pageTitle", "Pojištění majetku");
        return "pojisteni_majetku"; // Název Thymeleaf šablony (pojisteni_majetku.html)
    }

    @GetMapping("/pojisteni_domacnosti")
    public String pojisteniDomacnostiPage(Model model) {
        model.addAttribute("pageTitle", "Pojištění domácnosti");
        return "pojisteni_domacnosti"; // Název Thymeleaf šablony (pojisteni_domacnosti.html)
    }

    @GetMapping("/pojisteni_bytu")
    public String pojisteniBytuPage(Model model) {
        model.addAttribute("pageTitle", "Pojištění bytu");
        return "pojisteni_bytu"; // Název Thymeleaf šablony (pojisteni_bytu.html)
    }

    @GetMapping("/zivotni_pojisteni")
    public String zivotniPojisteniPage(Model model) {
        model.addAttribute("pageTitle", "Životní pojištění");
        return "zivotni_pojisteni"; // Název Thymeleaf šablony (zivotni_pojisteni.html)
    }

    @GetMapping("/pojisteni_vozidla")
    public String pojisteniVozidlaPage(Model model) {
        model.addAttribute("pageTitle", "Pojištění vozidla");
        return "pojisteni_vozidla"; // Název Thymeleaf šablony (pojisteni_vozidla.html)
    }

    @GetMapping("/create_pojisteni")
    public String createPojisteniPage(Model model) {
        model.addAttribute("pageTitle", "Nové pojištění");
        return "create_pojisteni"; // Název Thymeleaf šablony (create_pojisteni.html)
    }

    @GetMapping("/admin_hlavni")
    public String adminHlavniPage(Model model) {
        model.addAttribute("pageTitle", "Admin - hlavní stránka");
        return "admin_hlavni"; // Název Thymeleaf šablony (admin_hlavni.html)
    }
}
