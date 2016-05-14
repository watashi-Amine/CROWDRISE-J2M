/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowd.handler;
import com.crowd.entities.Reclamation;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Taha
 */
public class DisplayReclamationHandler extends DefaultHandler {
//     this will hold all the data we read
    private Vector RecVector;
    
    String Titre = "close";
     String CONTENU = "close";
//    String Contenue = "close";
//    String Notification = "close";

//    private StringBuffer ID_RECLAMATION;

    public DisplayReclamationHandler() {
        RecVector=new Vector();
    }
    
    public Reclamation[] getReclamations(){
        Reclamation[] reclamations = new Reclamation[RecVector.size()];
        RecVector.copyInto(reclamations);
        return reclamations;     
    }
    
//     VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private Reclamation currentRec;
    
//       XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
//     startElement is the opening part of the tag "<tagname...>"
        public void startElement(String uri, String localName, String qName, Attributes atrbts) throws SAXException {
    if(qName.equals("reclamation")){
    
    if (currentRec!=null){
       throw new IllegalStateException("already processing a person");
    }
    currentRec=new Reclamation();
    }
      
    else if (qName.equals("TITRE")){
    Titre="open";
    }
    
    
    else if (qName.equals("CONTENU")){
    CONTENU="open";
    }
    
    
        }



//    } else if(qName.equals("Contenue")){
//    Contenue="open";
//    } else if(qName.equals("Notification")){
//    Notification="open";
//    } 
    
 
    
//     XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)

        /* public void startElement(String uri, String localName, String qName, Attributes atrbts) throws SAXException {
        if(qName.equals("MyProds")){
        currentProduit=new Product();
        
        String idP=atrbts.getValue("id_prod");
        String prixP=atrbts.getValue("prix_prod");
        String libP=atrbts.getValue("libelle_prod");
        String descP=atrbts.getValue("description_prod");
        String dateP=atrbts.getValue("dateAjout_prod");
        String categP=atrbts.getValue("categorie_prod");
        String validP=atrbts.getValue("valid_prod");
        String idUsrP=atrbts.getValue("id_user_prod");
        
        currentProduit.setId_Prod(idP);
        currentProduit.setPrix_Prd(prixP);
        currentProduit.setLibelle_prd(libP);
        currentProduit.setDespcription_prd(descP);
        currentProduit.setDateAjout_prd(dateP);
        currentProduit.setCategorie_prd(categP);
        currentProduit.setValid(validP);
        currentProduit.setIdUsr(idUsrP);
        }else if(qName.equals("prix_prod")){
        prixTag="open";
        String prixP=atrbts.getValue("prix_prod");
        currentProduit.setPrix_Prd(prixP);
        
        }
        }*/
    
    
//   endElement is the closing part ("</tagname>"), or the opening part if it ends with "/>"
//     so, a tag in the form "<tagname/>" generates both startElement() and endElement()
    public void endElement(String uri, String localName, String qName) throws SAXException {
    
    if(qName.equals("reclamation")){
        
        RecVector.addElement(currentRec);
        currentRec =null;
        
        
    }
//     add completed Person object to collection
//    RecVector.addElement(currentRec);
//    
//     we are no longer processing a <person.../> tag
//    currentRec=null;
//    
    else if (qName.equals("TITRE")){
    Titre="close";
    }
    else if (qName.equals("CONTENU")){
    CONTENU="close";
    }
    }
//    } else if(qName.equals("Contenue")){
//    Contenue="close";
//    } else if(qName.equals("Notification")){
//    Notification="close";
//    } 
 
   
    /* public void endElement(String uri, String localName, String qName) throws SAXException {
    if(qName.equals("MyProds")){
    produitsVector.addElement(currentProduit);
    currentProduit=null;
    }else if(qName.equals("prix_prod")){
    prixTag="close";
    }
    }*/
//      "characters" are the text inbetween tags
     public void characters(char[] ch, int start, int length) throws SAXException {
//     we're only interested in this inside a <phone.../> tag
    if (currentRec!= null) {
//     don't forget to trim excess spaces from the ends of the string
    if (Titre.equals("open")) {
    String Titre= new String(ch, start, length).trim();
    currentRec.setTITRE(Titre);
    }
    if (CONTENU.equals("open")) {
    String cont= new String(ch, start, length).trim();
    currentRec.setCONTENUE(cont);
    }
    
    
    
    }}
//    } else if (Contenue.equals("open")){
//     Contenue=new String(ch,start,length).trim();
//    currentRec.setCONTENUE(Contenue);
//    } else if (Notification.equals("open")){
//    int Notification= Integer.parseInt(new String(ch, start, length).trim());
//    currentRec.setNOTIFICATION(Notification);
//
//   }
 }
 
     /* public void characters(char[] ch, int start, int length) throws SAXException {
     if(currentProduit!=null){
     String idP=new String(ch,start,length).trim();
     currentProduit.setId_Prod(idP);
     String prixP=new String(ch,start,length).trim();
     currentProduit.setPrix_Prd(prixP);
     String libP=new String(ch,start,length).trim();
     currentProduit.setLibelle_prd(libP);
     String descP=new String(ch,start,length).trim();
     currentProduit.setDespcription_prd(descP);
     String dateP=new String(ch,start,length).trim();
     currentProduit.setDateAjout_prd(dateP);
     String categP=new String(ch,start,length).trim();
     currentProduit.setCategorie_prd(categP);
     String validP=new String(ch,start,length).trim();
     currentProduit.setValid(validP);
     String idUsrP=new String(ch,start,length).trim();
     currentProduit.setIdUsr(idUsrP);
     } else if (prixTag.equals("open")){
     String prixP=new String(ch,start,length).trim();
     currentProduit.setPrix_Prd(prixP);
     }
     }*/

