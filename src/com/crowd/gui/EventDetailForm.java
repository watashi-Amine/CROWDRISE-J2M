/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crowd.gui;

import com.crowd.entities.evenement;
import com.crowd.midlet.CrowdRiseMidlet;
import com.sun.lwuit.Button;
import com.sun.lwuit.Command;
import com.sun.lwuit.Component;
import helper.Recuperate;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.Graphics;
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
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Image;

import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.StringItem;
import javax.microedition.midlet.MIDlet;


public class EventDetailForm extends Form implements CommandListener ,ActionListener{

    Command cmdBack = new Command("Retour");
     Command cmdadd = new Command("Ajouter");
          Command cmdpos = new Command("POS");

    Display Disp;
evenement event;
    
 

    public EventDetailForm(String title, evenement e) {
                super(title);
          this.Disp = CrowdRiseMidlet.Mc.Disp;
           event=e;
      
          
          
          Label st0 = new Label( "Titre                                               ");
          st0.setScrollAnimationSpeed(BRB_CONSTANT_ASCENT);
          Label st1 = new Label( e.getNom_evenement());

          Label st2 = new Label( "  Date Debut                                      ");
          Label st3 = new Label( e.getDate_debut());
       st3.getStyle().setMargin(10, 10, 10,10);

          Label st4 = new Label( "Date Fin                                         ");
          Label st5 = new Label( e.getDate_fin() );
 Label st8 = new Label( "Categorie                                        ");
          Label st9 = new Label( e.getCATEGORIE_EVENEMENT());
            Label st6 = new Label( "Description                                        ");
          Label st7 = new Label( e.getDescription());
         
        addComponent(st0);

        addComponent(st1);
addComponent(st8);
        addComponent(st9);
        addComponent(st2);
        addComponent(st3);
        addComponent(st4);
        addComponent(st5);
        addComponent(st6);
        addComponent(st7);
        
        addCommand(cmdBack);
         addCommand(cmdadd);
                  addCommand(cmdpos);

         
         
   this.addCommandListener(this);
        

          
          
          
          
          


    }
    
    public void commandAction(Command c, Displayable d) {
        if (c == cmdBack) {
//            ListProjet lstp = new ListProjet("Projet", List.IMPLICIT);
//            Disp.setCurrent(lstp);

         
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

         if (back.equals(cmdadd)) {
            this.setTransitionOutAnimator(Transition3D.createCube(750, true));
            Form m = new InsertEvent("Ajouter Evenement");
           m.show();
        }
            if (back.equals(cmdpos)) {
            this.setTransitionOutAnimator(Transition3D.createCube(750, true));
                MIDlet      k=CrowdRiseMidlet.Mc;
                                Displayable      d = null ;

          CrowdRiseMidlet.Mc.Displcdui.setCurrent(new GoogleMap(k, d,event));
        }
        
    }
    
}
