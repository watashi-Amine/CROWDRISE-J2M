/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowd.gui;


import com.crowd.entities.Commentaire;
import com.crowd.entities.Projet;
import com.crowd.entities.evenement;
import com.crowd.handler.CommentHandler;
import com.crowd.handler.DisplayEventtHandler;
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



public class FormListProjet extends Form implements CommandListener,ActionListener,SelectionListener {
    Command cmdinsert = new Command("Ajouter");
    Command cmdretour = new Command("retour");

    Projet[] projet;
            List l =new List();

    Display Disp;
    
    public FormListProjet(String title) {
        super(title);
           this.Disp = CrowdRiseMidlet.Mc.Disp;
                l.setPreferredSize(new Dimension(250,400));

        
          ProjetHandler projetHandler = new ProjetHandler();
    String    url1 = "http://localhost/crowdRiseMobile/Projets/select.php" ;
        try {
          
              SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
       
             HttpConnection hc = (HttpConnection) Connector.open(url1);
           
            
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
                                
            parser.parse(dis, projetHandler);
            
            projet = projetHandler.getProjet();

            
            
            
            
            
            if (projet.length > 0) {
                for (int i = 0; i < projet.length; i++) {
                    l.addItem(projet[i].getNOM_PROJET());
                }
            }
        } catch (ParserConfigurationException ex) {
        } catch (SAXException ex) {
        } catch (IOException ex) {
        }   
        
  
        
        
        addCommand(cmdretour);
        l.addSelectionListener(this);
        addComponent(l);
        addCommandListener(this);

      
    }

   

    public void commandAction(javax.microedition.lcdui.Command c, Displayable d) {
    }

    public void actionPerformed(ActionEvent evt) {
         Command back = evt.getCommand();

       
          if (back.equals(cmdretour)) {
            this.setTransitionOutAnimator(Transition3D.createCube(750, true));
            
            Form m = new Menu("Menu");
           m.show();
        }
       
          
          
          
    }

    public void selectionChanged(int oldSelected, int newSelected) {
        
        if (oldSelected==newSelected) {
                this.setTransitionOutAnimator(Transition3D.createCube(750, true));
            
            int   index = l.getSelectedIndex();
        Form a =new ProjetDetailForm("Detaille",projet[index]);
        a.show();

        }
      

    }
 

}
