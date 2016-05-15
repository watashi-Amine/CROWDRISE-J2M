package com.crowd.handler;

import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.crowd.entities.Utilisateur;

/**
 *
 * @author Fattouma
 */
public class UserHandler extends DefaultHandler {

    private Utilisateur currentUtilisateur;
    private Vector utilisateur;
    String id = "close";
    String username = "close";
    String email = "close";
    String enabled = "close";
    String password = "close";
    String NOM = "close";
    String PRENOM = "close";
    String date_naissance = "close";
    String telephone = "close";

    public UserHandler() {
        utilisateur = new Vector();
    }

    public Utilisateur[] getUtilisateur() {
        Utilisateur[] utilisateurs = new Utilisateur[utilisateur.size()];
        utilisateur.copyInto(utilisateurs);
        return utilisateurs;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("mydata")) {
            if (currentUtilisateur != null) {
                throw new IllegalStateException("already processing an utilisateur");
            }
            currentUtilisateur = new Utilisateur();

        } else if (qName.equals("Id")) {
            id = "open";
        } else if (qName.equals("username")) {

            username = "open";

        } else if (qName.equals("email")) {
            email = "open";
        } else if (qName.equals("enabled")) {
            enabled = "open";
        } else if (qName.equals("password")) {
            password = "open";
        } else if (qName.equals("NOM")) {
            NOM = "open";
        } else if (qName.equals("PRENOM")) {
            PRENOM = "open";
        } else if (qName.equals("date_naissance")) {
            date_naissance = "open";
        } else if (qName.equals("telephone")) {
            telephone = "open";
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("mydata")) {
            // we are no longer processing a <reg.../> tag
            utilisateur.addElement(currentUtilisateur);
            currentUtilisateur = null;
        } else if (qName.equals("Id")) {
            id = "close";
        } else if (qName.equals("username")) {
            username = "close";
        } else if (qName.equals("email")) {
            email = "close";
        }else if (qName.equals("enabled")) {
            enabled = "close";
        } else if (qName.equals("password")) {
            password = "close";
        } else if (qName.equals("NOM")) {
            NOM = "close";
        } else if (qName.equals("PRENOM")) {
            PRENOM = "close";
        } else if (qName.equals("date_naissance")) {
            date_naissance = "close";
        } else if (qName.equals("telephone")) {
            telephone = "close";
        }  
        
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
     {
            // don't forget to trim excess spaces from the ends of the string

            if (id.equals("open")) {

                String id = new String(ch, start, length).trim();
                currentUtilisateur.setId_membre(Integer.parseInt(id));

            } else if (username.equals("open")) {

                String usernamec = new String(ch, start, length).trim();
                currentUtilisateur.setUsername(usernamec);
            } else if (email.equals("open")) {
                String emailc = new String(ch, start, length).trim();
                currentUtilisateur.setEmail(emailc);
            } else if (enabled.equals("open")) {
                String enabledc = new String(ch, start, length).trim();
                currentUtilisateur.setEnabled(true );
            } else if (password.equals("open")) {
                String passwordc = new String(ch, start, length).trim();
                currentUtilisateur.setPassword(passwordc);
            } else if (NOM.equals("open")) {
                String NOMc = new String(ch, start, length).trim();
                currentUtilisateur.setNom(NOMc);
            } else if (PRENOM.equals("open")) {
                String PRENOMc = new String(ch, start, length).trim();
                currentUtilisateur.setPrenom(PRENOMc);
            } else if (date_naissance.equals("open")) {
                String date_naissancec = new String(ch, start, length).trim();
                currentUtilisateur.setDate_naissance(date_naissancec);
            } else if (telephone.equals("open")) {
                String telephonec = new String(ch, start, length).trim();
                currentUtilisateur.setPassword(telephonec);
            }
            
        }
    }
}
