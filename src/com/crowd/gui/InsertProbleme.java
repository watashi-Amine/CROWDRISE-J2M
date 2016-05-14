/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crowd.gui;

import com.crowd.midlet.CrowdRiseMidlet;
import com.sun.lwuit.ComboBox;
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
public class InsertProbleme  extends Form implements CommandListener,ActionListener{
        private Command Probcmd = new Command("Ajouter");
    private Command retour = new Command("retour");
     private TextArea  DureeTF = new TextArea(" Duree", 1, 15, TextArea.ANY);

     private TextArea  TitreTF = new TextArea(" titre", 1, 15, TextArea.ANY);
        private TextArea  ResumerTF = new TextArea(" Description du probleme", 5, 15, TextArea.ANY);
        private TextArea  BudgetTF = new TextArea("0000", 1, 15, TextArea.DECIMAL);
String[] typ= {"dev","design","conception"};
    ComboBox typeBox = new ComboBox(typ);
        Label titre =new Label("Titre");
            Label resume =new Label("Description");
             Label budget =new Label("budget");
                          Label type =new Label("type");
             Label duree =new Label("Estimation de la duree de travail");

        Display Disp;
    
    
    
    
    
    public InsertProbleme(String title) {
        super(title);
         this.Disp = CrowdRiseMidlet.Mc.Disp;
     
        
    
     
     
           addComponent(titre); 
        addComponent(TitreTF);
         addComponent(resume);
        addComponent(ResumerTF);
         addComponent(budget);
        addComponent(BudgetTF);
        addComponent(type);
       addComponent(duree);
        addComponent(DureeTF);
                addComponent(typeBox);

        addCommand(Probcmd);
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
  if (back.equals(Probcmd)) {
       

String t0 = TitreTF.getText();
String t1 = ResumerTF.getText();
 String t2 = BudgetTF.getText();                          
 String t3 =typeBox.getSelectCommandText();     
  String t4 =DureeTF.getText();             

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

        String url ="http://localhost/crowdRiseMobile/Probleme/AjouterProbleme.php?typeProbleme="+t3+"&nomProbleme="+b+"&description="+n+"&budjetP="+t2+"&duree="+t4;
 
 String added = Recuperate.GetTextServer(url);
         
                  if (added.equals("OK")) {
                      Dialog validDialog = new Dialog("Alert");
        validDialog.setScrollable(false);
        validDialog.setIsScrollVisible(false);
        validDialog.setTimeout(100); // set timeout milliseconds
        TextArea textArea = new TextArea("Ajout avec succes"); //pass the alert text here
        textArea.setFocusable(false);
        textArea.setIsScrollVisible(false);
        validDialog.addComponent(textArea);
        validDialog.show(0, 100, 10, 10, true);
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

    
   
    
    
    
    

