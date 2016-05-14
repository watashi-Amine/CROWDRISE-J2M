/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crowd.entities;



/**
 *
 * @author Ben Hmida Mahdi
 */
public class CompetenceFreelancer {
    private  int idCompetence;
    private int idProbleme;
    private  String competence;
    
    public CompetenceFreelancer(){
        this(-1, -1, null);
    }
    public CompetenceFreelancer(int idCompetence,int idProbleme,String competence){
        this.idCompetence=idCompetence;
        this.idProbleme=idProbleme;
        this.competence=competence;
        
    }

  public int getIdCompetence(){
      return idCompetence;
  }
  public int getIdProbleme(){
      return idProbleme;
  }
  public String getCompetence(){
      return competence;
  }
  public void setIdCompetence(int idCompetence) {
      this.idCompetence=idCompetence;
    }
  public void setIdProbleme(int idProbleme) {
        this.idProbleme=idProbleme;
    }
  public void setCompetence(String competence) {
        this.competence=competence;
    }

    
    public String toString() {
        return competence + ' ';
    }
  
  
  
}
