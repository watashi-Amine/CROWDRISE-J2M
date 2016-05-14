/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowd.gui;


import com.crowd.entities.Projet;
import com.crowd.entities.categorieProjet;
import com.crowd.entities.typeProjet;
import com.crowd.handler.ProjetHandler;
import com.crowd.midlet.CrowdRiseMidlet;
import com.sun.lwuit.Command;
import com.sun.lwuit.Component;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.List;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.events.SelectionListener;
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



public class ListProjet extends List implements CommandListener,ActionListener,SelectionListener,ListCellRenderer {
    Command cmdinsert = new Command("Ajouter");

    Projet[] projet;
    StringBuffer sb;
    categorieProjet[] cat;
        typeProjet[] type;

    Display Disp;
    
    
    public ListProjet(String title) {
      
        
               this.Disp = CrowdRiseMidlet.Mc.Disp;
             this.addSelectionListener(this);
             this.addActionListener(new ActionListener() {
                   public void actionPerformed(ActionEvent evt) {

  
        int   index = getSelectedIndex();
        Form a =new ProjetDetailForm("Detaille",projet[index]);
        a.show();

                   }
               });
             
           
                 
                 
                 
      
               
        setCommandList(true);
        
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
                    addItem(projet[i].getNOM_PROJET());
                }
            }
        } catch (ParserConfigurationException ex) {
        } catch (SAXException ex) {
        } catch (IOException ex) {
        }   
  
    }

   

    public void commandAction(javax.microedition.lcdui.Command c, Displayable d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void actionPerformed(ActionEvent evt) {
    
    }

    public void selectionChanged(int oldSelected, int newSelected) {
        
//        if (oldSelected != newSelected) {
//            
//        
//        int   index =this.getSelectedIndex();
//        System.out.println("AAAAAAAAAAAA"+this.getSelectedIndex());
//        Form a =new ProjetDetailForm("Detaille",projet[index]);
//        }
    }
public Component getListCellRendererComponent(List list, Object value, int index, boolean isSelected){
       Label l = new Label(value.toString());
if (isSelected) {
              l.setFocus(true);
              l.getStyle().setBgTransparency(100);
          } else {
              l.setFocus(false);
              l.getStyle().setBgTransparency(0);
         }
         return l;
}    public Component getListFocusComponent(List list){
       return null;
}

}
