/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowd.entities;

import java.io.InputStream;

/**
 *
 * @author Taha
 */
public class Reclamation {
    	
int ID_RECLAMATION;
int ID_USER;
int ID_CATEGORIE_RECLAMATION;
String TITRE;
String CONTENUE ;
int NOTIFICATION;

    public Reclamation(int ID_RECLAMATION, int ID_USER, int ID_CATEGORIE_RECLAMATION, String TITRE, String CONTENUE, int NOTIFICATION) {
        this.ID_RECLAMATION = ID_RECLAMATION;
        this.ID_USER = ID_USER;
        this.ID_CATEGORIE_RECLAMATION = ID_CATEGORIE_RECLAMATION;
        this.TITRE = TITRE;
        this.CONTENUE = CONTENUE;
        this.NOTIFICATION = NOTIFICATION;
    }

    public Reclamation() {
    }

    public int getID_RECLAMATION() {
        return ID_RECLAMATION;
    }

    public void setID_RECLAMATION(int ID_RECLAMATION) {
        this.ID_RECLAMATION = ID_RECLAMATION;
    }

    public int getID_USER() {
        return ID_USER;
    }

    public void setID_USER(int ID_USER) {
        this.ID_USER = ID_USER;
    }

    public int getID_CATEGORIE_RECLAMATION() {
        return ID_CATEGORIE_RECLAMATION;
    }

    public void setID_CATEGORIE_RECLAMATION(int ID_CATEGORIE_RECLAMATION) {
        this.ID_CATEGORIE_RECLAMATION = ID_CATEGORIE_RECLAMATION;
    }

    public String getTITRE() {
        return TITRE;
    }

    public void setTITRE(String TITRE) {
        this.TITRE = TITRE;
    }

    public String getCONTENUE() {
        return CONTENUE;
    }

    public String toString() {
        return "Reclamation{" + "ID_RECLAMATION=" + ID_RECLAMATION + ", ID_USER=" + ID_USER + ", ID_CATEGORIE_RECLAMATION=" + ID_CATEGORIE_RECLAMATION + ", TITRE=" + TITRE + ", CONTENUE=" + CONTENUE + ", NOTIFICATION=" + NOTIFICATION + "} \n";
    }

    public void setCONTENUE(String CONTENUE) {
        this.CONTENUE = CONTENUE;
    }

    public int getNOTIFICATION() {
        return NOTIFICATION;
    }

    public void setNOTIFICATION(int NOTIFICATION) {
        this.NOTIFICATION = NOTIFICATION;
    }


    
}
