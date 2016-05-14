/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowd.gui;

import com.crowd.entities.Utilisateur;
import com.crowd.midlet.CrowdRiseMidlet;
import com.crowd.gui.VideoForm;
import com.sun.lwuit.Button;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.Image;
import com.sun.lwuit.animations.Transition3D;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;


import java.io.IOException;




/**
 *
 * @author MohamedAmine
 */
public class Menu extends Form implements ActionListener{
       
                    Display Disp ;
                    
//                   setLaynout(new BoxLayout(BoxLayout.Y_axis));
                      
   Button Projet =new Button("Nos Projets");
   
   
   
   
                            Button Probleme =new Button("Nos Probleme");
                            Button Solutions =new Button("Nos Statistiques");
                            Button event =new Button("Nos événement");
                             Button reclamtion =new Button("Faire une reclamtion");
                              Button user =new Button("Profil");
                                                            Button out =new Button("Se deconnecter");

        
        
    public Menu(String title) {
        
        super(title);
        
                      
                        try {
                            //appelle disp midlet
                            this.Disp = com.crowd.midlet.CrowdRiseMidlet.Mc.Disp;
                            Image PImage =Image.createImage("/com/crowd/img/prj.png");
                            Image EImage =Image.createImage("/com/crowd/img/evt.png");
                             Image PrImage =Image.createImage("/com/crowd/img/prb.png");
                              Image UImage =Image.createImage("/com/crowd/img/usr.png");
                              Image SImage =Image.createImage("/com/crowd/img/slt.png");
                              Image Rmage =Image.createImage("/com/crowd/img/rcl.png");
                              
                              reclamtion.setIcon(Rmage);
                             user.setIcon(UImage);
                             Probleme.setIcon(PrImage);
                            event.setIcon(EImage);
                              Projet.setIcon(PImage);
                           Solutions.setIcon(SImage);
                          Projet.setIcon(PImage);
                                                                

                            
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        
                        
                   event.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            
          
   
               Form a =new FormListEvenement("Evenements");
                
               a.show();
                        
            
            }
        });
                                
                   reclamtion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            
   
               Form a =new FormListReclamation("Reclamtion");
             
               a.show();
               

            
            
            }
        });
                       
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   Probleme.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            
   
               Form a =new FormListProbleme("Problemes");
                 
               a.show();
               

            
            
            }
        }); 
                   
                   
                   
                   
                   
                    out.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            
   
               Form a =new ConnexionForm("au revoir");
                 
               a.show();
               

            
            
            }
        });          
                   
                   
                   
                   
                   
                   
                   
            Solutions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            
               CrowdRiseMidlet.Mclcdui.Displcdui.setCurrent(new Statistique("Statistique"));
               

            
            
            }
        });        
               user.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            setTransitionOutAnimator(Transition3D.createCube(180, true));
  
                Utilisateur u = ConnexionForm.clientConnecté;
            
            Form f = new UserDetailForm("Profil",u);
            f.show();
            
            }
        });             
                            

              Projet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

   javax.microedition.lcdui.Form f = new VideoForm("Promotion de projet",CrowdRiseMidlet.Mclcdui.Displcdui);
//               Form a =new FormListProjet("Projets");
//            
//               a.show();
            CrowdRiseMidlet.Mclcdui.Displcdui.setCurrent(f);

            }
        });
                            
                            
                            addComponent(Projet);
                            addComponent(Probleme);
                            addComponent(event);
                              addComponent(reclamtion);
                                                     addComponent(Solutions);
                                                     addComponent(user);
                                                     addComponent(out);

                        
    }

    public Menu() {
    }

    public void actionPerformed(ActionEvent evt) {
        
        if (Projet.isSelected()) {
            
            
        }

        
    }

}
