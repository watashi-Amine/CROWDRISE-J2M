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
public class InsertComment  extends Form implements CommandListener,ActionListener{
    
        private Command Commentcmd = new Command("Ajouter");
    private Command retourcmd = new Command("retour");

     private TextArea  CommentTF = new TextArea(" Votre Commentaire", 1, 15, TextArea.ANY);

                   
               Label Com =new Label("Votre Commentire");
                       
        Display Disp;
    
    Projet prj;
    
    
    
    public InsertComment(String title,Projet p) {
        super(title);
         this.Disp = CrowdRiseMidlet.Mc.Disp;
     
        prj=p;
    
        System.out.println(prj.getID_PROJET()+"!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!");
           addComponent(Com); 
        addComponent(CommentTF);
         
       
        
        addCommand(Commentcmd);
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
  if (back.equals(Commentcmd)) {
      
      System.out.println("111111111111");


    
String t0 = CommentTF.getText()    ;

 String      al="";
 String  lon="";     


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
            
            System.out.println("2222222222222");
            
            
            
            
         String url = "http://localhost/crowdRiseMobile/Comment/insert.php?thread_id=aa&body=" + b + "&author_id=3" + "&idProjet=" + prj.getID_PROJET();
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
            Form m = new FormListComent("Commentaires",prj);
           m.show();
        }      
            
            
            
            
            
        }




    }













    
   
    
    
    
    

