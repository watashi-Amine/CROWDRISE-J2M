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
import helper.Recuperate;

import java.io.DataInputStream;
import java.util.Random;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;

import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class MdpForm extends Form implements CommandListener ,ActionListener{

 Random rand = new Random();

    int nombreAleatoire = rand.nextInt(9999 - 1000 + 1) + 1000;
  
public  Container c0 = new Container();
    MessageConnection clientConn;

public TextArea smsTF = new TextArea("Email", 1,15, TextArea.ANY);
public  Label sms = new Label("Saisie Votre email ");


public Command retourcmd =new Command("retour");
public Command outcmd =new Command("quiter");

public Button smsBTN = new Button("envoyé");

Label sms1 = new Label("un sms avec votre nouveau mot de passe vous es envoyé ");

 

    public MdpForm(String title) {
                super(title);
                
              smsBTN.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        System.out.println("1111111111");
String t1 = smsTF.getText();
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


                        System.out.println("22222222222");
       
       
                    
                        try {
                    
                    
                    
                            System.out.println("33333333333333");
                    
                    UserHandler userHandler = new UserHandler();
                    SAXParser parser = SAXParserFactory.newInstance().newSAXParser();

                    HttpConnection hc = (HttpConnection) Connector.open("http://localhost/crowdRiseMobile/user/mailverif.php?email="+n);

                    DataInputStream dis = new DataInputStream(hc.openDataInputStream());

                    parser.parse(dis, userHandler);

                    // display the result
                    Utilisateur[] utilisateurs = userHandler.getUtilisateur();
                    int i = 0;

                    Utilisateur utilisateur = null;
                    if (utilisateurs.length > 0) {
                        System.out.println("user bien trouvé");
                        System.out.println(utilisateurs[0]);
                       /*  sms sms  sms sms  sms sms  sms sms  sms sms  sms sms  sms sms */
                      
                       
                        System.out.println("4444444444444444444");
                        System.out.println(utilisateurs[0]);
                        System.out.println("!!!!!!!!!!");
        String url = "http://localhost/crowdRiseMobile/user/MDPsms.php?password="+nombreAleatoire+"&id="+utilisateurs[0].getId_membre() ;
            
                         System.out.println(url);

             String added = Recuperate.GetTextServer(url);
             
             
                  if (added.equals("sms")) {
      /*  sms sms  sms sms  sms sms  sms sms  sms sms  sms sms  sms sms */

                      
          try {
                                            clientConn=(MessageConnection)Connector.open("sms://"+123456789); //MessageConnection clientConn;

                              TextMessage textmessage = (TextMessage) clientConn.newMessage(MessageConnection.TEXT_MESSAGE);
                              textmessage.setAddress("sms://"+123456789);
                              textmessage.setPayloadText("votre nouveau mdp est : "+nombreAleatoire);
                              clientConn.send(textmessage);
                              System.out.println("text msg sent");
                        }
                        catch(Exception e)
                        {
                              Alert alert=new Alert("Alert","",null,AlertType.INFO);
                              alert.setTimeout(Alert.FOREVER);
                              alert.setString("Unable to send");
                        }
      
      
      
      
                      
      /*  sms sms  sms sms  sms sms  sms sms  sms sms  sms sms  sms sms */
                System.out.println("555555555555555");    
                      
      Dialog validDialog = new Dialog("Alert");
        validDialog.setScrollable(false);
        validDialog.setIsScrollVisible(false);
        validDialog.setTimeout(2000); // set timeout milliseconds
        TextArea textArea = new TextArea("Un msg vous es envoyé"); //pass the alert text here
        textArea.setFocusable(false);
        textArea.setIsScrollVisible(false);
        validDialog.addComponent(textArea);
        validDialog.show(0, 100, 10, 10, true);
                      
                      addComponent(sms1);
                      
            System.out.println("Mdp modifier");
        } else {
            System.out.println("Mdp Erreur");
        }
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                      
                        
                        
                        

                      /*  sms sms  sms sms  sms sms  sms sms  sms sms  sms sms  sms sms */
                    }

                   else {
             Dialog validDialog = new Dialog("Erreur");
        validDialog.setScrollable(false);
        validDialog.setIsScrollVisible(false);
        validDialog.setTimeout(2000); // set timeout milliseconds
        TextArea textArea = new TextArea("ce email n'existe pas dans notre BDD"); //pass the alert text here
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
                      
                
                
              
                
                
                
                
                

          addCommand(outcmd);
          addCommand(retourcmd);
      
          
    c0.addComponent(sms);

     c0.addComponent(smsTF);

   
         
          addComponent(c0);
           addComponent(smsBTN);
          
          
          addCommandListener(this);
          
          

          
          
          
          
          


    }
    
    public void commandAction(Command c, Displayable d) {

        }
    

    public void commandAction(javax.microedition.lcdui.Command c, Displayable d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void actionPerformed(ActionEvent ae) {
 Command back = ae.getCommand();
       
      
        
   if (back.equals(retourcmd)) {
           
       
       Form f = new ConnexionForm("Bonjour");
       f.show();
       
       
             
        }
        
    if (back.equals(outcmd)) {
           
       
     CrowdRiseMidlet.Mc.notifyDestroyed();
       
       
             
        }
   
    }
    
    
    

    
    
}
