/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowd.entities;

/**
 *
 * @author hp
 */
public class evenement {
     private int      id;
    private int      id_evenement;
    private String   date_debut;
    private String   date_fin;
    private String   description;
    private String   CATEGORIE_EVENEMENT;
   
    private String  nom_evenement;
    private float longitude;
    private float latitude;

    public evenement() {
    }
        public evenement( int id,int id_evenement,String   date_debut,String   date_fin,String   description,String categorie_evenement,String  nom_evenement   )
        {
        
        this.id = id;
        this.id_evenement = id_evenement;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.description = description;
        this.CATEGORIE_EVENEMENT = CATEGORIE_EVENEMENT;
        
        this.nom_evenement = nom_evenement;
        
        }

    public evenement(int id_evenement, String date_debut, String description) {
        this.id_evenement = id_evenement;
        this.date_debut = date_debut;
        this.description = description;
    }

    public String getCATEGORIE_EVENEMENT() {
        return CATEGORIE_EVENEMENT;
    }

    public void setCATEGORIE_EVENEMENT(String CATEGORIE_EVENEMENT) {
        this.CATEGORIE_EVENEMENT = CATEGORIE_EVENEMENT;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public evenement(int id_evenement, String description) {
        this.id_evenement = id_evenement;
        this.description = description;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getcategorie_evenement() {
        return CATEGORIE_EVENEMENT;
    }

    public void setcategorie_evenement(String categorie_evenement) {
        this.CATEGORIE_EVENEMENT = CATEGORIE_EVENEMENT;
    }

   

    public String getNom_evenement() {
        return nom_evenement;
    }

    public void setNom_evenement(String nom_evenement) {
        this.nom_evenement = nom_evenement;
    }

    
    public String toString() {
        return nom_evenement   + "\n  date_debut  " + date_debut + " \n  date_fin " + date_fin + "\n  description " + description + "\n  CATEGORIE_EVENEMENT " + CATEGORIE_EVENEMENT + "\n  longitude " + longitude + "\n  latitude " + latitude ;
    }
        
 
    
 
}
