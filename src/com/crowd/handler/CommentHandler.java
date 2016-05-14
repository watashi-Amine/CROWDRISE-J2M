package com.crowd.handler;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.crowd.entities.*;


public class CommentHandler extends DefaultHandler {
    // this will hold all the data we read
    private Vector CommentVector;
     String id = "close";
    String thread_id = "close";
    String body = "close";
        String created_at = "close";
    String author_id = "close";
        String idProjet = "close";

         private Commentaire currentCommentaire;

    
    
    
    public CommentHandler() {
        CommentVector = new Vector();
    }
 
    public Commentaire[] getComment() {
        Commentaire[] CommnetTab = new Commentaire[CommentVector.size()];
        CommentVector.copyInto(CommnetTab);
        return CommnetTab;
    }
 
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
 
   
 //   private PhoneNumber currentPhoneNumber;
 
    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
 
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("Comment")) {
	 if (currentCommentaire != null) {
                throw new IllegalStateException("already processing a Project");
            }
            
            currentCommentaire = new Commentaire();
          
            
        }
        else if (qName.equals("id")) {
            
           id = "open";
            
        }
         else if (qName.equals("thread_id")) {
            thread_id= "open";
         
        } 
         else if (qName.equals("body")) {
            
           body = "open";
            
        }
         else if (qName.equals("created_at")) {
            
           created_at = "open";
        }
         else if (qName.equals("author_id")) {
            
           author_id = "open";
        }
        
          else if (qName.equals("idProjet")) {
            
           idProjet = "open";
        }
        
    }
 
    // endElement is the closing part ("</tagname>"), or the opening part if it ends with "/>"
    // so, a tag in the form "<tagname/>" generates both startElement() and endElement()
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("Comment")) {
	 CommentVector.addElement(currentCommentaire);
            currentCommentaire = null;
        }
        else if (qName.equals("id")) {
            
           id = "close";
            
        }
         else if (qName.equals("thread_id")) {
            thread_id= "close";
         
        } 
         else if (qName.equals("body")) {
            
           body = "close";
            
        }
         else if (qName.equals("created_at")) {
            
           created_at = "close";
        }
         else if (qName.equals("author_id")) {
            
          author_id = "close";
        }
        
                
         else if (qName.equals("idProjet")) {
            
          idProjet = "close";
        }
    }
 
    // "characters" are the text inbetween tags
    public void characters(char[] ch, int start, int length) throws SAXException {
      if (currentCommentaire != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (id.equals("open")) {
                String idcom = new String(ch, start, length).trim();
                currentCommentaire.setId(Integer.parseInt(idcom) );
            } else if (thread_id.equals("open")) {
                String threadcom = new String(ch, start, length).trim();
                currentCommentaire.setThread_id(threadcom);
            } else if (body.equals("open")) {
                String bodycom = new String(ch, start, length).trim();
                currentCommentaire.setBody(bodycom);
            }else if (created_at.equals("open")) {
                String creaCom = new String(ch, start, length).trim();
                currentCommentaire.setCreated_at(creaCom);
            } else if (author_id.equals("open")) {
                String authcom = new String(ch, start, length).trim();
                currentCommentaire.setAuthor_id(Integer.parseInt(authcom));
            }
            
                    else if (idProjet.equals("open")) {
                String idprocom = new String(ch, start, length).trim();
                currentCommentaire.setIdProjet(Integer.parseInt(idprocom));
            }
        }
}
}