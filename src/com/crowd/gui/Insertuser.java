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
public class Insertuser  extends Form implements CommandListener,ActionListener{
    
        private Command reccmd = new Command("S'inscrire");
    private Command retourcmd = new Command("retour");

     private TextArea  NomTF = new TextArea(" Nom", 1, 15, TextArea.ANY);
     private TextArea  prenomTF = new TextArea(" Prenom", 1, 15, TextArea.ANY);
          private TextArea  pseudoTF = new TextArea("Pseudo ", 1, 15, TextArea.ANY);
     private TextArea  EmailTF = new TextArea(" Email ", 1, 15, TextArea.ANY);  
     private TextArea  passwordTF = new TextArea(" Mot de passe ", 1, 15, TextArea.PASSWORD);
     private TextArea  CmdpTF = new TextArea(" Confirmation mot de Passe", 1, 15, TextArea.PASSWORD);
          private TextArea  adresseTF = new TextArea(" Adresse", 1, 15, TextArea.ANY);
     private TextArea  telephoneTF = new TextArea(" Numero de telephone ", 1, 15, TextArea.NUMERIC);


          Calendar ddnTF = new Calendar();
          
       Label Nom =new Label("Nom");
         Label Prenom =new Label("Prenom");
           Label Pseudo =new Label("Pseudo");
             Label Email =new Label("Email");
               Label Mdp =new Label("Mot de passe");
                 Label cmdp =new Label("Confirmation mot de Passe");
                   Label Adresse =new Label("Adresse");
                     Label ndt =new Label("Numero de telephone");
             
                       Label ddn =new Label("Date de Naissance :");
                     
                     
                    
             Display Disp;
    
   
    
    
    public Insertuser(String title) {
        super(title);
         this.Disp = CrowdRiseMidlet.Mc.Disp;
     
  addComponent(Nom); 
    addComponent(NomTF); 
      addComponent(Prenom); 
        addComponent(prenomTF); 
          addComponent(Pseudo); 
           addComponent(Email); 
             addComponent(EmailTF);
            addComponent(pseudoTF); 
            addComponent(Mdp); 
              addComponent(passwordTF); 
                addComponent(cmdp);  
                addComponent(CmdpTF); 
                  addComponent(Adresse); 
                    addComponent(adresseTF); 
                      addComponent(ndt); 
                        addComponent(telephoneTF); 
                         addComponent(ddn); 
                        addComponent(ddnTF); 
                          
                          
                
            
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
      

String t0 =   NomTF.getText() ;
String t1 = prenomTF.getText() ;
String t2 = pseudoTF.getText() ;
String t3 =  passwordTF.getText() ;
String t4 = CmdpTF.getText() ;
String t5 =  adresseTF.getText();
String t6 = telephoneTF.getText() ;
String t7 =  EmailTF.getText();
String t8 = ddnTF.getDate().toString();
 

 
          
     
               
          

String b = "";








            for (int i = 0; i < t0.length(); i++) {
           String c=t0.charAt(i)+"";
             if (c.equals(" ")){
                 
                b+="";
                         
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
            
        String a = "";

            for (int i = 0; i < t2.length(); i++) {
           String c=t2.charAt(i)+"";
             if (c.equals(" ")){
                 
                a+="%20";
                         
             } 
             else{
             a+=c;
             }
       }
            
            String aa = "";

            for (int i = 0; i < t3.length(); i++) {
           String c=t3.charAt(i)+"";
             if (c.equals(" ")){
                 
                aa+="%20";
                         
             } 
             else{
             aa+=c;
             }
       }
            String w = "";

            for (int i = 0; i < t4.length(); i++) {
           String c=t4.charAt(i)+"";
             if (c.equals(" ")){
                 
               w+="%20";
                         
             } 
             else{
            w+=c;
             }
       }
            
            String ww = "";

            for (int i = 0; i < t5.length(); i++) {
           String c=t5.charAt(i)+"";
             if (c.equals(" ")){
                 
                ww+="%20";
                         
             } 
             else{
             ww+=c;
             }
       }
            String q = "";

            for (int i = 0; i < t6.length(); i++) {
           String c=t6.charAt(i)+"";
             if (c.equals(" ")){
                 
                q+="%20";
                         
             } 
             else{
             q+=c;
             }
       }
            
            String qq = "";

            for (int i = 0; i < t7.length(); i++) {
           String c=t7.charAt(i)+"";
             if (c.equals(" ")){
                 
                qq+="%20";
                         
             } 
             else{
             qq+=c;
             }
       }
                  String x = "";

            for (int i = 0; i < t8.length(); i++) {
           String c=t8.charAt(i)+"";
             if (c.equals(" ")){
                 
                x+="%20";
                         
             } 
             else{
             x+=c;
             }
       }     
            
            
         String url = "http://localhost/crowdRiseMobile/user/insert.php?nom="
                 +b+"&username="+a+"&username_canonical="+a+"&password="
                 +aa+"&email="+qq+"&email_canonical="+qq+"&prenom="+bb
                 +"&date_naissance="+x+"&telephone="+q;
      System.out.println(url);

 
 String added = Recuperate.GetTextServer(url);
         System.out.println(url);
                  if (added.equals("successfully added")) {
                      Dialog validDialog = new Dialog("Alert");
        validDialog.setScrollable(false);
        validDialog.setIsScrollVisible(false);
        validDialog.setTimeout(1000); // set timeout milliseconds
        TextArea textArea = new TextArea("Veuillez vous connecter"); //pass the alert text here
        textArea.setFocusable(false);
        textArea.setIsScrollVisible(false);
        validDialog.addComponent(textArea);
        validDialog.show(0, 100, 10, 10, true);
        Form f = new ConnexionForm("Bonjour");
        } else {
        }
      }
      
   

  
      
       if (back.equals(retourcmd)) {
        this.setTransitionOutAnimator(Transition3D.createCube(750, true));
            Form m = new ConnexionForm("Bonjour :)");
           m.show();
        }      
}
          }   
            
            
            
       




    













    
   
    
    
    
    

