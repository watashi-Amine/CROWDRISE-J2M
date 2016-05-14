/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crowd.gui;

import com.crowd.midlet.CrowdRiseMidlet;
import com.sun.lwuit.Command;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.animations.Transition3D;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import helper.Recuperate;
import java.io.DataInputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Ticker;

/**
 *
 * @author araga
 */
public class InsertProjet  extends Form implements CommandListener,ActionListener{
    private Ticker tk0;
        private Command Projetcmd = new Command("Ajouter");
    private Command retour = new Command("retour");

     private TextArea  TitreTF = new TextArea(" Votre titre", 1, 15, TextArea.ANY);
        private TextArea  ResumerTF = new TextArea(" Description du projet", 5, 15, TextArea.ANY);
        private TextArea  BudgetTF = new TextArea("0000", 1, 15, TextArea.DECIMAL);
           Label titre =new Label("Titre");
            Label resume =new Label("Resumé");
             Label budget =new Label("budget");
   private Ticker tk1;
        Display Disp;
    
    
    
    
    
    public InsertProjet(String title) {
        super(title);
         this.Disp = CrowdRiseMidlet.Mc.Disp;
     
        
           tk0 = new Ticker("ajoutez votre projet ");
    
     
     
           addComponent(titre); 
        addComponent(TitreTF);
         addComponent(resume);
        addComponent(ResumerTF);
         addComponent(budget);
        addComponent(BudgetTF);
       
             tk0 = new Ticker("une imge par defaut va etre saisie veullez la modifier sur notre site ou application ");
        
        addCommand(Projetcmd);
        addCommand(retour);
  this.addCommandListener(this);
     
        
        
    }

    public void commandAction(Command c, Displayable d) {

 }



  

    
    
    
    
    
 

    public void commandAction(javax.microedition.lcdui.Command c, Displayable d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void actionPerformed(ActionEvent evt) {
 Command back = evt.getCommand();
  if (back.equals(Projetcmd)) {
       

String t0 = TitreTF.getText();
String t1 = ResumerTF.getText();
 String t2 = BudgetTF.getText();                          
 String t3 = "570abfb287517.png";             
String b = "";
String n = "";
  for (int i = 0; i < t0.length(); i++) {
           String c=t0.charAt(i)+"";
             if (c.equals(" ")){
                 
                b+="%20";
                         
             } 
             else{
             b+=c;
             }
       }
   for (int i = 0; i < t1.length(); i++) {
           String c=t1.charAt(i)+"";
             if (c.equals(" ")){
                 
                n+="%20";
                         
             } 
             else{
             n+=c;
             }
       }
 
 
 
 String added = Recuperate.GetTextServer("http://localhost/crowdRiseMobile/Projets/insert.php"+ "?NOM_PROJET=" + b + "&RESUME=" + n + "&BUDJET=" + t2+ "&imageFile=" + t3);
         
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
                
                
            
      System.out.println("fin");
        }
 if (back.equals(retour)) {
        this.setTransitionOutAnimator(Transition3D.createCube(750, true));
            Form m = new Menu("Menu");
           m.show();
        }



    }














    }

    
   
    
    
    
    

