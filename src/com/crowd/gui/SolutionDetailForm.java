/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crowd.gui;

import com.crowd.entities.Projet;
import com.crowd.entities.Solution;
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


public class SolutionDetailForm extends Form implements CommandListener ,ActionListener{

    Command cmdBack = new Command("Retour");


    Display Disp;
  
    
 Solution sol ;

    public SolutionDetailForm(String title,Solution s) {
                super(title);
                
                sol=s;
                
          this.Disp = CrowdRiseMidlet.Mc.Disp;
         
       
          Label st2 = new Label( "  Description de la solution                                      ");
          Label st3 = new Label( s.getDescription());

          Label st4 = new Label( "Prix de la solution                                           ");
          Label st5 = new Label( String.valueOf(s.getBudjets()) );

          Label st6 = new Label( "Estimation de la durée de travail                                          ");
          Label st7 = new Label( s.getDuree()+"H");
          


        addComponent(st2);
        addComponent(st3);
        addComponent(st4);
        addComponent(st5);
        addComponent(st6);
        addComponent(st7);
        addCommand(cmdBack);
         

         
   this.addCommandListener(this);
        

          
          
          
          
          


    }
    
    public void commandAction(Command c, Displayable d) {
        if (c == cmdBack) {
            Form f = new Menu("Menu");
f.show();
         
        }
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
