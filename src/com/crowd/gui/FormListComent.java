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



public class FormListComent extends Form implements CommandListener,ActionListener,SelectionListener {
    Command cmdinsert = new Command("Ajouter");
    Command cmdretour = new Command("retour");
    Command cmdsortir = new Command("Menu");

    Commentaire[] comment;
    StringBuffer sb;
    
    Display Disp;
    Projet prd ;
    
    public FormListComent(String title,Projet p) {
        super(title);
           this.Disp = CrowdRiseMidlet.Mc.Disp;
prd=p;
        List l =new List();
                l.setPreferredSize(new Dimension(250,400));

        
         CommentHandler Handler = new CommentHandler();
    String    url1 = "http://localhost/crowdRiseMobile/Comment/rechercheParProjet.php" ;
        try {
          
              SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
       String    url = url1 +"?idProjet=" +p.getID_PROJET(); 
            
              
             HttpConnection hc = (HttpConnection) Connector.open(url);
           
            
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
                                
            parser.parse(dis, Handler);
            
            comment = Handler.getComment();

            System.out.println(comment);
            
            
            
            if (comment.length > 0) {
                for (int i = 0; i < comment.length; i++) {
                    l.addItem(comment[i].getBody());
                }
            }
        } catch (ParserConfigurationException ex) {
        } catch (SAXException ex) {
        } catch (IOException ex) {
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
            Form m = new InsertComment("Commenter",prd);
           m.show();
        }
          if (back.equals(cmdretour)) {
            this.setTransitionOutAnimator(Transition3D.createCube(750, true));
            
            Form m = new FormListComent("Commentaires",prd);
           m.show();
        }
          if (back.equals(cmdsortir)) {
            this.setTransitionOutAnimator(Transition3D.createCube(750, true));
            
            Form m = new Menu("Menu");
           m.show();
        }
    
    }

    public void selectionChanged(int oldSelected, int newSelected) {
        

    }


}
