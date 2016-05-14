/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowd.gui;


import com.crowd.entities.Probleme;
import com.crowd.entities.Solution;
import com.crowd.handler.CommentHandler;
import com.crowd.handler.SolutionHandler;
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
import org.xml.sax.helpers.DefaultHandler;




public class FormListSolution extends Form implements CommandListener,ActionListener,SelectionListener {
    Command cmdinsert = new Command("Ajouter");
    Command cmdretour = new Command("retour");
        List l =new List();

    Solution[] solus;
    
    Display Disp;
    Probleme prb ;
    
    public FormListSolution(String title,Probleme p)  {
        super(title);
           this.Disp = CrowdRiseMidlet.Mc.Disp;
                l.setPreferredSize(new Dimension(250,400));
        System.out.println(p.getIdProbleme());
        System.out.println("!!!!!!!!!!!!");
 prb=p;
 
         SolutionHandler soltHandler = new SolutionHandler();
 String    url = "http://localhost/crowdRiseMobile/Probleme/getXmlSolution.php?id="+p.getIdProbleme() ;
        try {
          
              SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
       
             HttpConnection hc = (HttpConnection) Connector.open(url);
           
            
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
                                
            parser.parse(dis, soltHandler);        
            solus = soltHandler.getSolutions();

            
            
            
            
            
            if (solus.length > 0) {
                for (int i = 0; i < solus.length; i++) {
                    l.addItem(solus[i].getDescription());
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
            Form f= new InsertSolution("Ajout",prb);
            f.show();
         
        }
          if (back.equals(cmdretour)) {
            this.setTransitionOutAnimator(Transition3D.createCube(750, true));
            
            Form m = new ProblemeDetailForm("Commentaires",prb);
           m.show();
        }
        
    
    }

    public void selectionChanged(int oldSelected, int newSelected) {
        
  if (oldSelected==newSelected) {
                   if (oldSelected==newSelected) {
                this.setTransitionOutAnimator(Transition3D.createCube(750, true));
            
            int   index = l.getSelectedIndex();
        Form a =new SolutionDetailForm("Detaille",solus[index]);
        a.show();

        }
      
        }
    }


}
