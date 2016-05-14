/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowd.entities;

/**
 *
 * @author Oussama
 */
public class Commentaire {

    private int id, score, author_id,idProjet;
    private String thread_id, body, created_at, username;

    public Commentaire() {
    }

    public Commentaire(String body, String created_at, String username) {
        this.body = body;
        this.created_at = created_at;
        this.username = username;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getThread_id() {
        return thread_id;
    }

    public String getBody() {
        return body;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUsername() {
        return username;
    }
   public String getInfo(){
        return "Commentaire : \n"+" theme:"+ String.valueOf(thread_id) +" .\n editeur :"+ String.valueOf(username)+" .\n date de creation :"+ created_at+" .\n Description :"+ body + "\n";
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public void setThread_id(String thread_id) {
        this.thread_id = thread_id;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String toString() {
        return "commentaire  "+   id + "\n" +  " creer par \n" + author_id + " Titre du projet \n" + thread_id + "\n Contenu \n" + body + "\n cree le \n" + created_at ;
    }
   
    
    
}
