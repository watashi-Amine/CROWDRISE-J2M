/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crowd.entities;

import java.util.Date;




/**
 *
 * @author Ben Hmida Mahdi
 */
public class Probleme {
    private int iduser;
    private int idProbleme;
    private String nomProbleme;
    private  String typeProbleme;
    private  String competence;
    private  String description;
    private  String budget;
    private  String duree;
    private String fichier;
    private Date datePub;
    private String image;
    
    public Probleme(){
        this(0,0,null,null,null,null,null,null,null,null,null);
    }

    public Probleme(int idProbleme,int iduser, String nomProbleme, String typeprobleme, String description,String competence, String budget, String duree, String fichier,Date datePub,String image) {
        this.idProbleme=idProbleme;
        this.iduser=iduser;
        this.nomProbleme =nomProbleme;
        this.typeProbleme =typeprobleme;
        this.description =description;
        this.competence=competence;
        this.budget =budget ;
        this.duree =duree ;
        this.fichier =fichier ;
        this.datePub=datePub;
        this.image=image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public int getIdUser() {
        return iduser;
    }
    public void setIdUser(int iduser){
        this.iduser=iduser;
    }
 public int getIdProbleme() {
        return idProbleme;
    }
    public void setIdProbleme(int IdProbleme){
        this.idProbleme=IdProbleme;
    }
   
    
    public String getNomProbleme() {
        return nomProbleme;
    }
    public void setNomProbleme(String NomProbleme) {
        this.nomProbleme=NomProbleme;
    }
    public String getCompetence() {
        return competence;
    }
    public void setCompetence(String competence) {
        this.competence=competence;
    }
    
    public String getFichier() {
        return fichier;
    }
    public void setFichier(String fichier) {
        this.fichier=fichier;
    }
   
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description=description;
    }
    
    public String getBudge() {
        return budget;
    }
    public void setBudge(String budge) {
        this.budget=budge;
    }
    
    public String getDuree() {
        return duree;
    }
    public void setDuree(String duree) {
        this.duree=duree;
    }
   
    public String getType() {
        return typeProbleme;
    }
    public void setTypeProbleme(String typeProbleme) {
        this.typeProbleme=typeProbleme;
    }

    public Date getDatePub() {
        return datePub;
    }

    public void setDatePub(Date datePub) {
        this.datePub = datePub;
    }
   
    public String getInfo(){
        return "Produit : \n" +" ,\n Nom :"+ String.valueOf(nomProbleme)+" ,\n Type :"+ typeProbleme+" ,\n Description :"+ description+" ,\n budget :"+ String.valueOf(budget)+"\n------------------------------------------";
    }
            


    
}
