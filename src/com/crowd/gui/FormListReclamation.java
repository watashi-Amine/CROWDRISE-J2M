/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowd.gui;


import com.crowd.entities.Commentaire;
import com.crowd.entities.Projet;
import com.crowd.entities.Reclamation;
import com.crowd.handler.CommentHandler;
import com.crowd.handler.DisplayReclamationHandler;
import com.crowd.midlet.CrowdRiseMidlet;
import com.sun.lwuit.Command;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
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



public class FormListReclamation extends Form implements CommandListener,ActionListener,SelectionListener {
    Command cmdinsert = new Command("Ajouter");
    Command cmdretour = new Command("retour");
    Command cmdmail = new Command("Envoyer un mail");
 List l =new List();
    Reclamation[] reclam;
    
    Display Disp;
    Reclamation Rec ;
    
    public FormListReclamation(String title) {
        super(title);
           this.Disp = CrowdRiseMidlet.Mc.Disp;
           
           
           
       

                l.setPreferredSize(new Dimension(250,400));

        
         DisplayReclamationHandler Handler = new DisplayReclamationHandler();
    String    url = "http://localhost/crowdRiseMobile/Reclamation/select.php" ;
        try {
          
              SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            
              
             HttpConnection hc = (HttpConnection) Connector.open(url);
           
            
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
                                
            parser.parse(dis, Handler);
            
            reclam = Handler.getReclamations();

            System.out.println(reclam);
            
            
            
            if (reclam.length > 0) {
                for (int i = 0; i < reclam.length; i++) {
                    l.addItem(reclam[i].getTITRE());
                }
            }
        } catch (ParserConfigurationException ex) {
        } catch (SAXException ex) {
        } catch (IOException ex) {
        }   
        
        addCommand(cmdinsert);
                addCommand(cmdmail);
                addCommand(cmdretour);

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
            Form m = new InsertReclamation("Ajouter Reclamation");
           m.show();
        }
          if (back.equals(cmdretour)) {
            this.setTransitionOutAnimator(Transition3D.createCube(750, true));
            
            Form m = new Menu("Commentaires");
           m.show();
        }
        
        if (back.equals(cmdmail)) {
            this.setTransitionOutAnimator(Transition3D.createCube(750, true));
            
            Form m = new FormMail("mail");
           m.show();
        }
    }

    public void selectionChanged(int oldSelected, int newSelected) {
       
   if (oldSelected==newSelected) {
                this.setTransitionOutAnimator(Transition3D.createCube(750, true));
            
            int   index = l.getSelectedIndex();
         Form a =new ReclamationDetailForm("Reclamation",reclam[index]);
        a.show();

        }
    }


}
