/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crowd.gui;

import com.crowd.entities.Probleme;
import com.crowd.entities.Projet;
import com.crowd.entities.Reclamation;
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


public class ReclamationDetailForm extends Form implements CommandListener ,ActionListener{

    Command cmdBack = new Command("Retour");
          Command cmdRec = new Command("Listes des Solutions");


    Display Disp;

    
 Reclamation Rec ;

    public ReclamationDetailForm(String title, Reclamation r) {
                super(title);
                
                
          this.Disp = CrowdRiseMidlet.Mc.Disp;
          
        Rec = r;
          
          
          Label st0 = new Label( "Titre                                               ");
          
     
          Label st1 = new Label( r.getTITRE());

          Label st2 = new Label( "  Description                                      ");
          Label st3 = new Label( r.getCONTENUE());

        addComponent(st0);

        addComponent(st1);

        addComponent(st2);
        addComponent(st3);
      
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
