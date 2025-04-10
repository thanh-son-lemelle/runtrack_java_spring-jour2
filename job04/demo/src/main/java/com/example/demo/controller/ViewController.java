package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;



@Controller
public class ViewController {
    @GetMapping("/view")
    public String showView(Model model) {
        model.addAttribute("message", "Bonjour depuis Thymeleaf controller !!!");
        return "view";
    }
    @GetMapping("/liste")
    public String showList(Model model) {
        List<String> noms = List.of("Alice", "Bob", "Charlie");
        model.addAttribute("noms", noms);
        return "liste";
    }
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("nom", ""); // initialisation
        return "form";
    }

    @PostMapping("/form")
    public String submitForm(@RequestParam String nom, Model model) {
        model.addAttribute("message", "Bienvenue, " + nom + " !");
        return "formResult";
    }
}
