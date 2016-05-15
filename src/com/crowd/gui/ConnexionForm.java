/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crowd.gui;

import com.crowd.entities.Utilisateur;
import com.crowd.handler.UserHandler;
import com.crowd.midlet.CrowdRiseMidlet;
import com.sun.lwuit.Button;
import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextArea;

import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;

import com.sun.lwuit.layouts.BoxLayout;

import java.io.DataInputStream;
import java.util.Random;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class ConnexionForm extends Form implements CommandListener ,ActionListener{


public  Container c0 = new Container();
public  Container c1 = new Container();
public  Container c2 = new Container(new BoxLayout(TOP));

public TextArea loginTF = new TextArea("login", 1,15, TextArea.ANY);
public TextArea passTF = new TextArea("pwd", 1,15, TextArea.PASSWORD);

public Button logBTN = new Button("SE CONNECTER");
public Button outBTN = new Button("QUITER");

public Command authcmd =new Command("S'INSCRIRE");
public Command Oublcmd =new Command("Mot de passe oublier");

 static Utilisateur clientConnecté = null;


    Utilisateur[] user ;

    Display Disp;
 

    public ConnexionForm(String title) {
                super(title);
               
              
                outBTN.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {

        CrowdRiseMidlet.Mc.notifyDestroyed();

                    }
                });
                
                
              logBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            
                   System.out.println("!!!!!!!!!!!!!!!!!!!!!!");

                    
                    
                  String   t0 = loginTF.getText();
              String   t1 = passTF.getText();

                  
                    
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
                    
                    
                    
                        try {
                    
                    
                    
                    
                    
                    UserHandler userHandler = new UserHandler();
                    SAXParser parser = SAXParserFactory.newInstance().newSAXParser();

                    HttpConnection hc = (HttpConnection) Connector.open("http://localhost/crowdRiseMobile/user/select.php?username="+b+"&password="+n);

                    DataInputStream dis = new DataInputStream(hc.openDataInputStream());

                    parser.parse(dis, userHandler);

                    // display the result
                    Utilisateur[] utilisateurs = userHandler.getUtilisateur();
                    int i = 0;

                    Utilisateur utilisateur = null;
                    if (utilisateurs.length > 0) {
                        System.out.println("authentification ressite");
                        System.out.println(utilisateurs[0].getId_membre());
                        System.out.println(utilisateurs[0].getUsername());
                        System.out.println(utilisateurs[0].getPassword());
                                utilisateur = utilisateurs[i];
                                clientConnecté=utilisateur;
                                
                         Form k = new Menu("bonjour  "+ clientConnecté.getUsername());
                                    k.show();


                    }

                    if (utilisateur != null) {

 Form k = new Menu("bonjour  "+ clientConnecté.getUsername());
                                    k.show();                       
                    } else {
             Dialog validDialog = new Dialog("Alert");
        validDialog.setScrollable(false);
        validDialog.setIsScrollVisible(false);
        validDialog.setTimeout(1000); // set timeout milliseconds
        TextArea textArea = new TextArea("Veuillez saisir un login correcte "); //pass the alert text here
        textArea.setFocusable(false);
        textArea.setIsScrollVisible(false);
        validDialog.addComponent(textArea);
        validDialog.show(0, 100, 10, 10, true);
                                    
                       
                    }
                } catch (Exception e) {

                    System.out.println("aaaa:" + e.toString());
                    
                }               
       
            
            
            }
        });
          
              
              
              outBTN.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        
                        
       CrowdRiseMidlet.Mc.destroyApp(true);
                   
                    
                    }
                });
              
              
              
          
          c0.addComponent(loginTF);
          c0.addComponent(passTF);
          
          
          
          c1.setY(BOTTOM);
          c1.addComponent(logBTN);
          c1.addComponent(outBTN);
          
          
          
          c2.addComponent(new Label("                                                                                                                                                                                                                                                                "));
          
          
          addCommand(authcmd);
          addCommand(Oublcmd);
      
     

   
         
          addComponent(c0);
           addComponent(c1);
          
          
          
          addCommandListener(this);
          
          

          
          
          
          
          


    }
    
    public void commandAction(Command c, Displayable d) {

        }
    

    public void commandAction(javax.microedition.lcdui.Command c, Displayable d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void actionPerformed(ActionEvent ae) {
 Command back = ae.getCommand();
       
      
        
   if (back.equals(authcmd)) {
           
       
       Form f = new Insertuser("inscription");
       f.show();
       
       
             
        }
           if (back.equals(Oublcmd)) {
          
Form f = new MdpForm(" Sms ");
f.show();
       
             
        }
    }
    
    
    

    
    
}
