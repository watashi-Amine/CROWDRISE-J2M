/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crowd.gui;

import com.crowd.entities.Projet;
import com.crowd.midlet.CrowdRiseMidlet;
import com.sun.lwuit.Calendar;
import com.sun.lwuit.ComboBox;
import com.sun.lwuit.Command;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.RadioButton;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.animations.Transition3D;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import helper.Recuperate;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Ticker;
import helper.Recuperate;

/**
 *
 * @author araga
 */
public class InsertReclamation  extends Form implements CommandListener,ActionListener{
    
        private Command reccmd = new Command("Ajouter");
    private Command retourcmd = new Command("retour");

     private TextArea  TitreTF = new TextArea(" Sujet de la reclamation", 1, 15, TextArea.ANY);
     private TextArea  ReclamTF = new TextArea(" Votre reclamation", 3, 15, TextArea.ANY);
private RadioButton Notrb = new RadioButton("etre notifier pour une reponse");
                                  Label ConRec =new Label("Objet");

               Label Com =new Label("Titre");
                                      Label Not =new Label("être notifier pour une reponse");

        Display Disp;
    
   
    
    
    public InsertReclamation(String title) {
        super(title);
         this.Disp = CrowdRiseMidlet.Mc.Disp;
     
    
           addComponent(Com); 
        addComponent(TitreTF);
                    addComponent(ConRec); 

               addComponent(ReclamTF);
              
                 addComponent(Not); 
 addComponent(Notrb);
         
            
        
        addCommand(reccmd);
        addCommand(retourcmd);
    addCommandListener(this);
     
        
        
    }

    public void commandAction(Command c, Displayable d) {

 }



  

    
    
    
    
    
 

    public void commandAction(javax.microedition.lcdui.Command c, Displayable d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void actionPerformed(ActionEvent evt) {
 Command back = evt.getCommand();
  if (back.equals(reccmd)) {
      


    
String t0 = TitreTF.getText()    ;
String t1 = ReclamTF.getText()    ;
String t3 = "0" ;
      if ( Notrb.isSelected()) { t3 = "1";}
    
          
      
       
 


String b = "";

            for (int i = 0; i < t0.length(); i++) {
           String c=t0.charAt(i)+"";
             if (c.equals(" ")){
                 
                b+="%20";
                         
             } 
             else{
             b+=c;
             }
       }
            
            String bb = "";

            for (int i = 0; i < t1.length(); i++) {
           String c=t1.charAt(i)+"";
             if (c.equals(" ")){
                 
                bb+="%20";
                         
             } 
             else{
             bb+=c;
             }
       }
            
            
            
            
            
            
         String url = "http://localhost/crowdRiseMobile/Reclamation/insert.php?TITRE=" + b + "&CONTENU=" +bb+ "&NOTIFICATION=" +t3;
      System.out.println(url);

 
 String added = Recuperate.GetTextServer(url);
         System.out.println(url);
                  if (added.equals("successfully added")) {
                      Dialog validDialog = new Dialog("Alert");
        validDialog.setScrollable(false);
        validDialog.setIsScrollVisible(false);
        validDialog.setTimeout(100); // set timeout milliseconds
        TextArea textArea = new TextArea("Ajout avec succes"); //pass the alert text here
        textArea.setFocusable(false);
        textArea.setIsScrollVisible(false);
        validDialog.addComponent(textArea);
        validDialog.show(0, 100, 10, 10, true);
            System.out.println("Added Projet");
        } else {
            System.out.println("Projets Existe");
        }
    }
            
       if (back.equals(retourcmd)) {
        this.setTransitionOutAnimator(Transition3D.createCube(750, true));
            Form m = new Menu("Menu");
           m.show();
        }      
            
            
            
            
            
        }




    }













    
   
    
    
    
    

