/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowd.gui;


import com.crowd.entities.Commentaire;
import com.crowd.entities.Probleme;
import com.crowd.entities.Projet;
import com.crowd.entities.evenement;
import com.crowd.handler.CommentHandler;
import com.crowd.handler.DisplayEventtHandler;
import com.crowd.handler.ProblemeHandler;
import com.crowd.handler.ProjetHandler;
import com.crowd.midlet.CrowdRiseMidlet;
import com.sun.lwuit.Command;
import com.sun.lwuit.Component;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.List;
import com.sun.lwuit.animations.Transition3D;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.events.SelectionListener;
import com.sun.lwuit.geom.Dimension;
import com.sun.lwuit.list.ListCellRenderer;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;



public class FormListProbleme extends Form implements CommandListener,ActionListener,SelectionListener {
    Command cmdinsert = new Command("Ajouter");
    Command cmdretour = new Command("retour");

    Probleme[] prob;
    StringBuffer sb;
     List l =new List();
    Display Disp;
    
    public FormListProbleme(String title) {
        super(title);
           this.Disp = CrowdRiseMidlet.Mc.Disp;
       
                l.setPreferredSize(new Dimension(250,400));
        l.addSelectionListener(this);
        
   
         try {
            ProblemeHandler ListProbHandler = new ProblemeHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
             // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/crowdRiseMobile/Probleme/getXmlProblemes.php");
         //   hc.setRequestMethod(HttpConnection.GET);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, ListProbHandler);
            
             // display the result
            prob = ListProbHandler.getTabProbleme();
             if (prob.length > 0) {
                for (int i = 0; i < prob.length; i++) {
                    l.addItem(prob[i].getNomProbleme());
                }
            }
            
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        
        
        
        
        
        
        
        
        addCommand(cmdinsert);
        addComponent(l);
        l.addSelectionListener(this);
        addCommandListener(this);

      
    }

   

    public void commandAction(javax.microedition.lcdui.Command c, Displayable d) {
    }

    public void actionPerformed(ActionEvent evt) {
         Command back = evt.getCommand();

          if (back.equals(cmdinsert)) {
            this.setTransitionOutAnimator(Transition3D.createCube(750, true));
             Form f = new InsertProbleme("Ajouter Probleme");
            f.show();
        }
          if (back.equals(cmdretour)) {
            this.setTransitionOutAnimator(Transition3D.createCube(750, true));
           
        }
        
    
    }

    public void selectionChanged(int oldSelected, int newSelected) {
        

        
        
        
         if (oldSelected==newSelected) {
                this.setTransitionOutAnimator(Transition3D.createCube(750, true));
            
           int   index = l.getSelectedIndex();
        Form a =new ProblemeDetailForm("Detaille",prob[index]);
        a.show();

        }
        
    }


}
