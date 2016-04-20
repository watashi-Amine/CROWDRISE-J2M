package com.crowd.handler;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import com.crowd.entities.*;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class ProjetHandler extends DefaultHandler {
    // this will hold all the data we read
    private Vector projetVector;
     String ID_PROJETTag = "close";
    String NOM_PROJETTag = "close";
    String RESUMETag = "close";
        String BUDJETTag = "close";
    String imageFileTag = "close";
    
    
     private Projet currentProjet;
       private categorieProjet currentcategorieProjet;
          private typeProjet currenttypeProjett;
    
    
    
    
    
    
    public ProjetHandler() {
        projetVector = new Vector();
    }
 
    public Projet[] getProjet() {
        Projet[] projetTab = new Projet[projetVector.size()];
        projetVector.copyInto(projetTab);
        return projetTab;
    }
 
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
 
   
 //   private PhoneNumber currentPhoneNumber;
 
    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
 
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("projet")) {
	 if (currentProjet != null) {
                throw new IllegalStateException("already processing a Project");
            }
            
            currentProjet = new Projet();
          
            
        }
        else if (qName.equals("ID_PROJET")) {
            
           ID_PROJETTag = "open";
            
        }
         else if (qName.equals("NOM_PROJET")) {
            NOM_PROJETTag= "open";
         
        } 
         else if (qName.equals("RESUME")) {
            
           RESUMETag = "open";
            
        }
         else if (qName.equals("BUDJET")) {
            
           BUDJETTag = "open";
        }
         else if (qName.equals("imageFile")) {
            
           imageFileTag = "open";
        }
    }
 
    // endElement is the closing part ("</tagname>"), or the opening part if it ends with "/>"
    // so, a tag in the form "<tagname/>" generates both startElement() and endElement()
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("projet")) {
	 projetVector.addElement(currentProjet);
            currentProjet = null;
        }
        else if (qName.equals("ID_PROJET")) {
            
           ID_PROJETTag = "close";
            
        }
         else if (qName.equals("NOM_PROJET")) {
            NOM_PROJETTag= "close";
         
        } 
         else if (qName.equals("RESUME")) {
            
           RESUMETag = "close";
            
        }
         else if (qName.equals("BUDJET")) {
            
           BUDJETTag = "close";
        }
         else if (qName.equals("imageFile")) {
            
           imageFileTag = "close";
        }
    }
 
    // "characters" are the text inbetween tags
    public void characters(char[] ch, int start, int length) throws SAXException {
      if (currentProjet != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (ID_PROJETTag.equals("open")) {
                String ID_PROJET = new String(ch, start, length).trim();
                currentProjet.setID_PROJET(Integer.parseInt(ID_PROJET) );
            } else if (NOM_PROJETTag.equals("open")) {
                String NOM_PROJET = new String(ch, start, length).trim();
                currentProjet.setNOM_PROJET(NOM_PROJET);
            } else if (RESUMETag.equals("open")) {
                String RESUME = new String(ch, start, length).trim();
                currentProjet.setRESUME(RESUME);
            }else if (BUDJETTag.equals("open")) {
                String BUDJET = new String(ch, start, length).trim();
                currentProjet.setBUDJET(Double.parseDouble(BUDJET));
            } else if (imageFileTag.equals("open")) {
                String imageFile = new String(ch, start, length).trim();
                currentProjet.setImage(imageFile);
            }
        }
}
}