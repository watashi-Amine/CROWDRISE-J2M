/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crowd.gui;

import com.crowd.entities.Projet;
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


public class ProjetDetailForm extends Form implements CommandListener ,ActionListener{

    Command cmdBack = new Command("Retour");
     Command cmdadd = new Command("Ajouter");
    Display Disp;
        //image
     ImageItem imgt = new ImageItem("img item", null, ImageItem.LAYOUT_CENTER, "don't do that");
    Image img;
    
 

    public ProjetDetailForm(String title, Projet p) {
                super(title);
          this.Disp = CrowdRiseMidlet.Mc.Disp;
           String    url1 = "http://localhost/1/uploadsProjets/" ;
          
         try {
            img = Image.createImage(url1+p.getImage());
                    System.out.println(url1+p.getImage());
            //les items
        } catch (IOException ex) {
            ex.printStackTrace();
             System.out.println("Don't work  ..............................................");
        }
          
          
          Label st0 = new Label( "Titre                                               ");
          
     
          Label st1 = new Label( p.getNOM_PROJET());

          Label st2 = new Label( "  Resumé                                      ");
          Label st3 = new Label( p.getRESUME());
       st3.getStyle().setMargin(10, 10, 10,10);

          Label st4 = new Label( "Budjet                                          ");
          Label st5 = new Label( String.valueOf(p.getBUDJET()) );

            com.sun.lwuit.Image mg;
            mg = Recuperate.GetImageServer("http://127.0.0.1/1/uploadsProjets/"+p.getImage());
           imgt.setImage(img); 
        addComponent(st0);

        addComponent(st1);
       Button bb = new Button("", mg);
        addComponent(bb);
        addComponent(st2);
        addComponent(st3);
        addComponent(st4);
        addComponent(st5);
        addCommand(cmdBack);
         addCommand(cmdadd);
         
         
         
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
            Form m = new InsertProjet("Ajouter Projet");
           m.show();
        }
        
        
    }
    
}
