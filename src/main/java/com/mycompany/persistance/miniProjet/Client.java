/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.persistance.miniProjet;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * developpeur class.
 *
 * @author elhor maher
 */

    
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "nom", length = 255, nullable = true)
    private String nom;
@Column(name = "prenom", length = 255, nullable = true)
    private String prenom;

    

    // Bidirectional mode:
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    // Unidirectional mode:
    //@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "client_projet",
            joinColumns = {
                @JoinColumn(name = "client_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "projet_id")})
    private List<Projet> projets = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }
    
}

