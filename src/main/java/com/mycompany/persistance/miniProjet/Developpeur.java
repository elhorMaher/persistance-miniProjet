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
@Table(name = "developper")
public class Developpeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", length = 255, nullable = true)
    private String name;

    

    // Bidirectional mode:
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    // Unidirectional mode:
    //@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "developpeur_tache",
            joinColumns = {
                @JoinColumn(name = "developpeur_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "tache_id")})
    private List<Tache> taches = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

    public List<Tache> getTaches() {
        return taches;
    }

    public void setTaches(List<Tache> taches) {
        this.taches = taches;
    }

}
