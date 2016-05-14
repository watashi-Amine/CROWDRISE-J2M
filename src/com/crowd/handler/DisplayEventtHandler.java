/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowd.handler;

import com.crowd.entities.evenement;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Edzio
 */
public class DisplayEventtHandler extends DefaultHandler{
      // this will hold all the data we read
    private Vector EvenementsVector;
    //
    String idevenTag = "close";
    String datedebutTag = "close";
    String datefinTag="close";
    String categorieTag="close";
    String nonevenTag="close";
    String DesTag="close";
    String idTag="close";
    String lonTag="close";
    String latTag="close";


    

    public DisplayEventtHandler() {
        EvenementsVector=new Vector();
    }
    
    public evenement[] getEvent(){
        evenement[] evenementss = new evenement[EvenementsVector.size()];
        EvenementsVector.copyInto(evenementss);
        return evenementss;     
    }
    
    private evenement currentEvent;
    
   
        public void startElement(String uri, String localName, String qName, Attributes atrbts) throws SAXException {
    if(qName.equals("MyEvents")){

    

    
    if (currentEvent!=null){
       throw new IllegalStateException("already processing a person");
    }
    currentEvent=new evenement();
    

    
    }else if (qName.equals("id")){
    idTag="open";
    } 
    else if(qName.equals("ID_EVENEMENT")){
    idevenTag="open";
    } else if(qName.equals("DATE_DEBUT")){
    datedebutTag="open";
    } else if(qName.equals("DATE_FIN")){
    datefinTag="open";
    }else if(qName.equals("DESCRIPTION")){
    DesTag="open";
    }

    else if(qName.equals("CATEGORIE_EVENEMENT")){
    categorieTag="open";
    } else if(qName.equals("longitude")){
    lonTag="open";
    } else if(qName.equals("latitude")){
    latTag="open";
    }
     else if(qName.equals("nomEvenement")){
   nonevenTag="open";
    }
 }
    
 
    public void endElement(String uri, String localName, String qName) throws SAXException {
    
    if(qName.equals("MyEvents")){
    // add completed Person object to collection
    EvenementsVector.addElement(currentEvent);
    
    // we are no longer processing a <person.../> tag
    currentEvent=null;
    
   }else if (qName.equals("id")){
    idTag="close";
    } else if(qName.equals("ID_EVENEMENT")){
    idevenTag="close";
    } else if(qName.equals("DATE_DEBUT")){
    datedebutTag="close";
    } else if(qName.equals("DATE_FIN")){
    datefinTag="close";
    } 
else if(qName.equals("DESCRIPTION")){
    DesTag="close";
    }
    else if(qName.equals("CATEGORIE_EVENEMENT")){
    categorieTag="close";
    } else if(qName.equals("longitude")){
    lonTag="close";
    } else if(qName.equals("latitude")){
    latTag="close";
    }
    else if(qName.equals("nomEvenement")){
    nonevenTag="close";
    }
 }
   
  
     public void characters(char[] ch, int start, int length) throws SAXException {
    // we're only interested in this inside a <phone.../> tag
    if (currentEvent != null) {
    // don't forget to trim excess spaces from the ends of the string
    if (idTag.equals("open")) {
    String id = new String(ch, start, length).trim();
    currentEvent.setId(Integer.parseInt(id));
    } else if (idevenTag.equals("open")){
    String ideven = new String(ch,start,length).trim();
    currentEvent.setId_evenement(Integer.parseInt(ideven));
    } else if (datedebutTag.equals("open")){
    String datedeb=new String(ch,start,length).trim();
    currentEvent.setDate_debut(datedeb);
    } else if (datefinTag.equals("open")){
    String datefin=new String(ch,start,length).trim();
    currentEvent.setDate_fin(datefin);
    }else if (DesTag.equals("open")){
    String Des=new String(ch,start,length).trim();
    currentEvent.setDescription(Des);
    }  
    else if (nonevenTag.equals("open")){
    String nomeven=new String(ch,start,length).trim();
    currentEvent.setNom_evenement(nomeven);
    } else if (categorieTag.equals("open")){
    String categeve=new String(ch,start,length).trim();
    currentEvent.setCATEGORIE_EVENEMENT(categeve);
    } 

    else if (lonTag.equals("open")){
    String lon=new String(ch,start,length).trim();
    currentEvent.setLongitude(Float.parseFloat(lon));
    }else if (latTag.equals("open")){
    String lat=new String(ch,start,length).trim();
    currentEvent.setLatitude(Float.parseFloat(lat));
   }
 }

     }
}     


