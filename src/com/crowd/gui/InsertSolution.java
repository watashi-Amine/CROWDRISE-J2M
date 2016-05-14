/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crowd.gui;

import com.crowd.entities.Probleme;
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
public class InsertSolution  extends Form implements CommandListener,ActionListener{
        private Command soluscmd = new Command("Ajouter");
    private Command retour = new Command("retour");
    
    
     private TextArea  DureeTF = new TextArea(" Duree", 1, 15, TextArea.ANY);
        private TextArea  ResumerTF = new TextArea(" Description du probleme", 5, 15, TextArea.ANY);
        private TextArea  BudgetTF = new TextArea("0000", 1, 15, TextArea.DECIMAL);
            Label resume =new Label("Description");
             Label budget =new Label("budget");
             Label duree =new Label("Estimation de la duree de travail");

        Display Disp;
    
    Probleme prb;
    
    
    
    public InsertSolution(String title,Probleme p) {
        super(title);
         this.Disp = CrowdRiseMidlet.Mc.Disp;
     prb = p;
        
    
     
     
          
         addComponent(resume);
        addComponent(ResumerTF);
         addComponent(budget);
        addComponent(BudgetTF);
       addComponent(duree);
        addComponent(DureeTF);

        addCommand(soluscmd);
        addCommand(retour);
  addCommandListener(this);
     
        
        
    }

    public void commandAction(Command c, Displayable d) {

 }



  

    
    
    
    
    
 

    public void commandAction(javax.microedition.lcdui.Command c, Displayable d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void actionPerformed(ActionEvent evt) {
 Command back = evt.getCommand();
  if (back.equals(soluscmd)) {
       

String t1 = ResumerTF.getText();
 String t2 = BudgetTF.getText();                          
  String t4 =DureeTF.getText();             

String n = "";
 
   for (int i = 0; i < t1.length(); i++) {
           String c=t1.charAt(i)+"";
             if (c.equals(" ")){
                 
                n+="%20";
                         
             } 
             else{
             n+=c;
             }
       }
   
   String m = "";
 
   for (int i = 0; i < t4.length(); i++) {
           String c=t4.charAt(i)+"";
             if (c.equals(" ")){
                 
                m+="%20";
                         
             } 
             else{
             m+=c;
             }
       }
   
   
   

        String url ="http://localhost/crowdRiseMobile/Probleme/AjouterSolution.php?description="+n+"&budjetS="+t2+"&duree="+m+"&idProbleme="+prb.getIdProbleme();
      System.out.println(url);
                 String added = Recuperate.GetTextServer(url);
               System.out.println(url);

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
            System.out.println("Solution Existe");
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

    
   
    
    
    
    

