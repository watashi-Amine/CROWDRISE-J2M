/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crowd.handler;

import com.crowd.entities.Solution;
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
public class SolutionHandler extends DefaultHandler {
    private Vector solutions;
    private Solution currentSolution;
    private String idSolutionTag="close";
    private String idProblemeTag="close";
    private String author_idTag="close";
    private String descriptionTag="close";
    private String fichierTag="close";
    private String dureeTag="close";
    private String budjetsTag="close";
   
    public SolutionHandler(){
        solutions=new Vector();
    }



  
    public Solution[] getSolutions() {
        Solution[] solTab = new Solution[this.solutions.size()];
        this.solutions.copyInto(solTab);
        return solTab;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equals("solution")) 
        {

            if (currentSolution!= null)
            {
                throw new IllegalStateException("step___open");
            }
            currentSolution = new Solution();
          }
      else if (qName.equals("id")) {
            author_idTag = "open";
        }
      else if (qName.equals("idProbleme")) {
            idProblemeTag = "open";
        } 
           else if (qName.equals("idSolution")) {
            idSolutionTag = "open";
        } else if (qName.equals("description")) {
            descriptionTag = "open";
        } else if (qName.equals("duree")) {
            dureeTag = "open";
        }else if (qName.equals("budjetS")) {
            budjetsTag = "open";
        }
   }

    
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("solution"))
        {
            solutions.addElement(currentSolution);
            currentSolution = null;
        }
        else if (qName.equals("id")) {
            author_idTag = "close";
        }
        else if (qName.equals("idProbleme")) {
            idProblemeTag = "close";
        } 
           else if (qName.equals("idSolution")) {
            idSolutionTag = "close";
        }  else if (qName.equals("description")) {
            descriptionTag = "close";
        } else if (qName.equals("duree")) {
            dureeTag = "close";
        }else if (qName.equals("budjets")) {
            budjetsTag = "close";
        }

    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentSolution != null) {
            
             if (author_idTag.equals("open")) {
            currentSolution.setAuthor_id(Integer.parseInt(new String(ch, start, length).trim()));
        }
             
            if (idProblemeTag.equals("open")) {
            currentSolution.setIdprobleme(Integer.parseInt(new String(ch, start, length).trim()));
        }
            if (idSolutionTag.equals("open")) {
                currentSolution.setIdsolution(Integer.parseInt(new String(ch, start, length).trim()));
            }
           
           if (descriptionTag .equals("open")) {
                 currentSolution.setDescription(new String(ch, start, length).trim());
           }
           if (dureeTag .equals("open")) {
                 currentSolution.setDuree(new String(ch, start, length).trim());
           }
          
            else if (budjetsTag .equals("open")) {
                 currentSolution.setBudjets(new String(ch, start, length).trim());

        
    }
    
            System.out.println(currentSolution.toString());
  
 }
}
 
    
          
    
}
