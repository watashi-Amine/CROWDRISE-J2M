/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowd.gui;

import com.crowd.midlet.CrowdRiseMidlet;
import com.sun.lwuit.Button;
import com.sun.lwuit.Command;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.Image;
import com.sun.lwuit.List;
import com.sun.lwuit.animations.Transition3D;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.events.FocusListener;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.layouts.Layout;
import java.io.IOException;
import java.util.Date;


import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author MohamedAmine
 */
public class Menu extends Form implements ActionListener{
       
                    Display Disp ;
                    
//                   setLaynout(new BoxLayout(BoxLayout.Y_axis));
                      
   Button Projet =new Button("Nos Projets");
   
   
   
   
                            Button Probleme =new Button("Nos Probleme");
                            Button Solutions =new Button("Nos Solutions");
                            Button event =new Button("Nos événement");
                             Button reclamtion =new Button("Faire une reclamtion");
                              Button user =new Button("Profil");
        
        
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
                            System.err.println("zut l'image  !!!!!!!!!!!!!!!");
                        }
                        
                        
                         
                           
                            

              Projet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

   List l =new ListProjet("aaaa");
   
               Form a =new Form();
               
             a.setTransitionInAnimator(Transition3D.createRotation(250, true));
            a.addCommandListener(this);
               a.addComponent(l);
               a.animate();
               a.show();
                        

            }
        });
                            
                            
                            addComponent(Projet);
                             addComponent(Solutions);
                            addComponent(Probleme);
                            addComponent(event);
                              addComponent(reclamtion);
                        
                        
    }

    public Menu() {
    }

    public void actionPerformed(ActionEvent evt) {
        
        if (Projet.isSelected()) {
            
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            
        }

        
    }

}
