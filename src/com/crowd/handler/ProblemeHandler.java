/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crowd.handler;

import com.crowd.entities.Probleme;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Ben Hmida Mahdi
 */
public class ProblemeHandler extends DefaultHandler{
    
    private Vector problemes;
    private Probleme currentProbleme;
    
     private String iduserTag= "close";
    private String idProblemeTag= "close";
    private String nomProblemeTag= "close";
    private  String typeProblemeTag= "close";
    private  String competenceTag= "close";
    private  String descriptionTag= "close";
    private  String budgetTag= "close";
    private  String dureeTag= "close";
    private String fichierTag= "close";
    private String datePubTag= "close";
   private String imageTag= "close";

    private StringBuffer id_prob;
    
    public ProblemeHandler(){
        problemes=new Vector();
    }
    public Vector getProbleme(){
        return problemes;
    }
    
    
    public void setProbleme(Vector problemes) {
        this.problemes = problemes;
    }
    public Probleme[] getTabProbleme() {
        Probleme[] probTab = new Probleme[this.problemes.size()];
        this.problemes.copyInto(probTab);
        return probTab;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("probleme")) {

            if (currentProbleme != null) {
                throw new IllegalStateException("already processing probleme");
            }
            currentProbleme = new Probleme();
        
        } else if (qName.equals("id")) {
            iduserTag = "open";
        } else if (qName.equals("idProbleme")) {
            idProblemeTag = "open";
        } else if (qName.equals("nomProbleme")) {
            nomProblemeTag = "open";
        } else if (qName.equals("typeProbleme")) {
            typeProblemeTag = "open";
        } else if (qName.equals("description")) {
            descriptionTag = "open";
        } else if (qName.equals("duree")) {
            dureeTag = "open";
        } else if (qName.equals("budjetP")) {
            budgetTag = "open";
        }  else if (qName.equals("datePublication")) {
            datePubTag = "open";
        }   

    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("probleme")) {
            problemes.addElement(currentProbleme);
            currentProbleme = null;
         
        } else if (qName.equals("id")) {
            iduserTag = "close";
        } else if (qName.equals("idProbleme")) {
            idProblemeTag = "close";
        } else if (qName.equals("nomProbleme")) {
            nomProblemeTag = "close";
        } else if (qName.equals("typeProbleme")) {
            typeProblemeTag = "close";
        }  else if (qName.equals("description")) {
            descriptionTag = "close";
        } else if (qName.equals("duree")) {
            dureeTag = "close";
        } else if (qName.equals("budjetP")) {
            budgetTag = "close";
        } 
    }

    
    
    // "characters" are the text inbetween tags
    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentProbleme != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (iduserTag.equals("open")) {
                currentProbleme.setIdUser(Integer.parseInt(new String(ch, start, length).trim()));
            }else if (idProblemeTag.equals("open")) {
                currentProbleme.setIdProbleme(Integer.parseInt(new String(ch, start, length).trim()));
            }
            else if (nomProblemeTag.equals("open")) {
                currentProbleme.setNomProbleme(new String(ch, start, length).trim());
                
            }else if (typeProblemeTag.equals("open")) {
                currentProbleme.setTypeProbleme(new String(ch, start, length).trim());
            } else if (descriptionTag.equals("open")) {
                currentProbleme.setDescription(new String(ch, start, length).trim());
            } else if (dureeTag.equals("open")) {
                currentProbleme.setDuree(new String(ch, start, length).trim());
            } else if (budgetTag.equals("open")) {
                currentProbleme.setBudge(new String(ch, start, length).trim());
            }
            
        }
        
    }
    
    
}
