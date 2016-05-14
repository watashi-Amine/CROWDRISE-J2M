/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crowd.gui;

import com.crowd.entities.Probleme;
import com.crowd.entities.Projet;
import com.crowd.entities.Utilisateur;
import com.crowd.midlet.CrowdRiseMidlet;
import com.sun.lwuit.Button;
import com.sun.lwuit.Command;
import com.sun.lwuit.Component;
import helper.Recuperate;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.animations.Transition3D;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.geom.Dimension;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.plaf.Border;
import com.sun.lwuit.plaf.Style;
import java.io.IOException;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Image;

import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.StringItem;


public class UserDetailForm extends Form implements CommandListener ,ActionListener{

    Command cmdBack = new Command("Retour");
   


    Display Disp;
       
    Utilisateur user ;

    public UserDetailForm(String title, Utilisateur u) {
                super(title);
                
                
          this.Disp = CrowdRiseMidlet.Mc.Disp;
          
        user = u;
          
          
          Label st0 = new Label( "prenom                      ");
          
     
          Label st1 = new Label( u.getPrenom());

          Label st2 = new Label( "  nom                             ");
          Label st3 = new Label( u.getNom());
        System.out.println(u.toString());
          Label st4 = new Label( "Email                                          ");
          Label st5 = new Label( u.getEmail() );

             Label st6 = new Label( "Pseudonyme                                          ");
          Label st7 = new Label(u.getUsername());

          
              Label st8 = new Label( "Date  de naissance                                          ");
          Label st9 = new Label(u.getDate_naissance());
          
        
          
        addComponent(st0);

        addComponent(st1);

        addComponent(st2);
        addComponent(st3);
        addComponent(st4);
        addComponent(st5);
         addComponent(st6);
        addComponent(st7);
           addComponent(st8);
        addComponent(st9);
        addCommand(cmdBack);
         

         addCommandListener(this);
        

          
          
          
          
          


    }
    
    public void commandAction(Command c, Displayable d) {
     
    }

    public void commandAction(javax.microedition.lcdui.Command c, Displayable d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void actionPerformed(ActionEvent ae) {
 Command back = ae.getCommand();
       
        if (back.equals(cmdBack)) {
            this.setTransitionOutAnimator(Transition3D.createCube(750, true));
            Form m = new Menu("Menu");
           m.show();
        }

       
        
    }
    
}
