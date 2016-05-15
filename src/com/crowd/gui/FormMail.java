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
import java.io.IOException;
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
public class FormMail  extends Form implements CommandListener,ActionListener{
        private Command sendcmd = new Command("envoyer");
    private Command retour = new Command("retour");

     private TextArea  mailTF = new TextArea("mail", 1, 15, TextArea.ANY);
        private TextArea  ObjetTF = new TextArea(" Objet", 1, 15, TextArea.ANY);
        private TextArea  messTF = new TextArea("message", 5, 15, TextArea.DECIMAL);
        
        
        
           Label mail =new Label(" Remplir votre reclamation un mail sera envoyeé    ");
            Label objet =new Label("Objet");
             Label mess =new Label("message");
             
             
             
        Display Disp;
    
         //Connexion
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/mail/sendMail.php";
    StringBuffer sb = new StringBuffer();
    int ch;
    
    
    
    public FormMail(String title) {
        super(title);
         this.Disp = CrowdRiseMidlet.Mc.Disp;
     
        
    
     
     
          addComponent(mail); 
       
         addComponent(mess);
        addComponent(messTF);
       
        
        addCommand(sendcmd);
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
  if (back.equals(retour)) {
       
Form f = new FormListReclamation("reclamation");
f.show();
        }
 if (back.equals(sendcmd)) {
       
      try {
          
          String t0 = "&msg="+messTF.getText();
          
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
          
          
          
          
          System.out.println(url+"?to=crowdtecksoul@gmail.com&sujet=aaa&msg="+b);
              hc = (HttpConnection) Connector.open(url+"?to=crowdtecksoul@gmail.com&sujet="+ConnexionForm.clientConnecté.getUsername()+"&msg="+b);
              //  System.out.println(url+"?lib="+tfLib.getString().trim()+"&description="+tfDesc.getString().trim());
              dis = new DataInputStream(hc.openDataInputStream());
              while ((ch = dis.read()) != -1) {
                  sb.append((char)ch);
                  
              }
              if ("ok".equals(sb.toString().trim())) {
                  System.out.println("email envoyé");
                  
              }else{
                  
                  System.out.println("email non envoyé");
              }
              sb = new StringBuffer();
              } catch (IOException ex) {
                  ex.printStackTrace();
              }

    }














    }

}
   
    
    
    
    

