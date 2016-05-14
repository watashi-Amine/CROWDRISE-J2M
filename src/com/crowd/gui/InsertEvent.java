/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crowd.gui;

import com.crowd.midlet.CrowdRiseMidlet;
import com.sun.lwuit.Calendar;
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
import javax.microedition.lcdui.Ticker;

/**
 *
 * @author araga
 */
public class InsertEvent  extends Form implements CommandListener,ActionListener{
    private Ticker tk0;
        private Command Eventcmd = new Command("Ajouter");
    private Command retour = new Command("retour");

     private TextArea  TitreTF = new TextArea(" Votre titre", 1, 15, TextArea.ANY);
        private TextArea  DesTF = new TextArea(" Description du projet", 5, 15, TextArea.ANY);

        Calendar DFinTF = new Calendar();
Calendar DdebutTF = new Calendar();
                String[] categ=new String[]{"Telephonie","Ordinateur","Laptop","Consoles_Videos","Jeux_Videos","Camescopes","Vetements","Bricolage","Electromenager","autres" };
    
    ComboBox catBox = new ComboBox(categ);
             
      String[] pos=new String[]{"Tunis","Ariana","BenArous","Manouba" };
    
    ComboBox posBox = new ComboBox(pos);
    
           Label titre =new Label("Titre");
            Label Des =new Label("Description");
             Label Ddebut =new Label("Date debut");
               Label Dfin =new Label("Date fin");
           
   private Ticker tk1;
        Display Disp;
    
    
    
    
    
    public InsertEvent(String title) {
        super(title);
         this.Disp = CrowdRiseMidlet.Mc.Disp;
     
        
           tk0 = new Ticker("ajoutez votre Evenement ");
    
     
     
           addComponent(titre); 
        addComponent(TitreTF);
         addComponent(Des);
        addComponent(DesTF);
         addComponent(Ddebut);
        addComponent(DdebutTF);
       
        
      
           addComponent(Dfin);
        addComponent(DFinTF);
        
        
        
           addComponent(catBox);
        addComponent(posBox);
          
       
        
        addCommand(Eventcmd);
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
  if (back.equals(Eventcmd)) {
      
     


    
String t0 = TitreTF.getText()    ;
String t1 =    DesTF.getText()  ;
String t2 =  DdebutTF.getDate().toString()   ;
String t3 =  DFinTF.getDate().toString()   ;
String t4 =  catBox.getSelectedItem().toString()   ;
String t5 = posBox.getSelectedItem().toString()    ;
 String      al="";
 String  lon="";     

      if (t5 == "Tunis") {
          
          al=  String.valueOf(36.7994597) ;
          lon=String.valueOf(10.1808313)  ;
          
      }
       else  if (t5 == "Ariana") {
         
          al= String.valueOf(36.8689216);
          lon= String.valueOf(10.1353404);
          
      }
        else    if (t5 == "BenArous") {
         
           al= String.valueOf(36.7465169);
          lon= String.valueOf(10.2171373);
          
      }
            else   if (t5 == "Manouba") {
        
           al= String.valueOf(36.8099176);
          lon= String.valueOf(10.0601505);
      }
 


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
            
            String z = "";

            
             for (int i = 0; i < t1.length(); i++) {
           String c=t1.charAt(i)+"";
             if (c.equals(" ")){
                 
                z+="%20";
                         
             } 
             else{
             z+=c;
             }
       }
        
  
             
             String x = "";

                for (int i = 0; i < t2.length(); i++) {
           String c=t2.charAt(i)+"";
             if (c.equals(" ")){
                 
                x+="%20";
                         
             } 
             else{
             x+=c;
             }
       }
             String w = "";

               for (int i = 0; i < t3.length(); i++) {
           String c=t3.charAt(i)+"";
             if (c.equals(" ")){
                 
                w+="%20";
                         
             } 
             else{
             w+=c;
             }
       } 
             String q = "";

             
          for (int i = 0; i < t4.length(); i++) {
           String c=t4.charAt(i)+"";
             if (c.equals(" ")){
                 
                q+="%20";
                         
             } 
             else{
             q+=c;
             }
       }      
             String r = "";

         for (int i = 0; i < t5.length(); i++) {
           String c=t5.charAt(i)+"";
             if (c.equals(" ")){
                 
                r+="%20";
                         
             } 
             else{
             r+=c;
             }
       }       
             
             
             
  
 
        String url = "http://localhost/crowdRiseMobile/Evenement/AddEvent.php";
            
            url=url+"?DESCRIPTION="+z+"&nomEvenement="+b+"&DATE_DEBUT="+x+"&DATE_FIN="+w+"&CATEGORIE_EVENEMENT="+q+"&id="+3+"&longitude="+lon+"&latitude="+al;
                         System.out.println(url);

             String added = Recuperate.GetTextServer(url);
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
                      
                      
            System.out.println("Added Event");
        } else {
            System.out.println("Event Existe");
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

    
   
    
    
    
    

