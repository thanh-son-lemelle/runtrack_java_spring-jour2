package com.example.demo.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class FormData {

    @NotEmpty(message = "Le nom est requis")
    private String nom;

    @Min(value = 18, message = "Vous devez avoir au moins 18 ans")
    private int age;

    // Getters / Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
