/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.persistance.miniProjet;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Tache class.
 *
 * @author elhor maher
 */
@Entity
@Table(name = "tache")
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "titre", length = 255, nullable = true)
    private String titre;
 @Column(name = "description", length = 255, nullable = true)
    private String description;
 @Column(name = "dureeJour", length = 255, nullable = true)
    private String dureeJour;
 
    // Bidirectionnel mode :
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private List<Developpeur> developpeurs = new ArrayList<>();

    public List<Developpeur> getDeveloppeur() {
        return developpeurs;
    }

    public void setPDeveloppeurs(List<Developpeur> developpeurs) {
        this.developpeurs = developpeurs;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getDureeJour() {
        return dureeJour;
    }

    public List<Developpeur> getDeveloppeurs() {
        return developpeurs;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDureeJour(String dureeJour) {
        this.dureeJour = dureeJour;
    }

    public void setDeveloppeurs(List<Developpeur> developpeurs) {
        this.developpeurs = developpeurs;
    }

    
}