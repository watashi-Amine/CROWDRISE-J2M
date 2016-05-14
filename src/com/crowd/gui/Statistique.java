/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowd.gui;

import com.crowd.entities.Commentaire;
import com.crowd.entities.Projet;
import com.crowd.handler.CommentHandler;
import com.crowd.handler.ProjetHandler;
import com.crowd.midlet.CrowdRiseMidlet;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.beanizer.j2me.charts.VBarChart;
import org.xml.sax.SAXException;

/**
 *
 * @author araga
 */
public class Statistique  extends Form implements CommandListener{
    Command cmdretour = new Command("retour",Command.OK, 0);
    
        Commentaire[] comm;
            Projet[]             projet;
        
        
int commentCount,projetCount;
    Display Disp;
    int nbreprojet = 0;
 
    VBarChart item = new VBarChart("");
   

    public Statistique(String title) {
        super(title);
           this.Disp = CrowdRiseMidlet.Mclcdui.Displcdui;
               

                
                
                
                try {
           
            CommentHandler ListCommHandler = new CommentHandler();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/crowdRiseMobile/Comment/select.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, ListCommHandler);

            // display the result
            comm = ListCommHandler.getComment();
        
                   commentCount=comm.length;
                   
            
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
                
        
          ProjetHandler projetHandler = new ProjetHandler();
    String    url1 = "http://localhost/crowdRiseMobile/Projets/select.php" ;
        try {
          
              SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
       
             HttpConnection hc = (HttpConnection) Connector.open(url1);
           
            
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
                                
            parser.parse(dis, projetHandler);
            
            projet = projetHandler.getProjet();

            
            
            
            projetCount=projet.length;
           
        } catch (ParserConfigurationException ex) {
        } catch (SAXException ex) {
        } catch (IOException ex) {
        }           
                
                
                
                
                
                
                
                
                
                
                
                
                
                
             statbar();
                addCommand(cmdretour);
                setCommandListener(this);    
                
                
    }

    public void commandAction(Command c, Displayable d) {

     
        if (c==cmdretour) {
            
                com.sun.lwuit.Form m = new Menu("Menu");
           m.show();
            
        }
       
  
      


    }

    public void statbar() {

        Thread th = new Thread() {
            public void run() {

               

                item.setFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
                item.setDrawAxis(true);
                item.setPreferredSize(300, 300);
                item.setMargins(5, 5, 5, 5);
                item.showShadow(true);
                item.setShadowColor(20, 20, 20);
                item.setColor(40, 40, 200);
                item.resetData();
                System.out.println("hh");

                item.addElement("pojet",projetCount, 200, 50, 6);
                item.addElement("Commentaire",commentCount, 6, 50, 200);
                item.setMaxValue(100);
          append(item);

            
            }
        };
        th.start();
        // System.out.println(nbrevente);

    }

    
    
    
    
    
}
