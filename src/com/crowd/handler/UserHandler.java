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
    String firstname = "close";
    String password = "close";
    String pseudoTag = "close";
    String emailTag = "close";
    String mot_de_passeTag = "close";
    String adresseTag = "close";
    String telephoneTag = "close";
    String roleTag = "close";
    String dateTag = "close";

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
        } else if (qName.equals("FirstName")) {

            firstname = "open";

        } else if (qName.equals("password")) {
            password = "open";
        } else if (qName.equals("pseudo")) {
            pseudoTag = "open";
        } else if (qName.equals("email")) {
            emailTag = "open";
        } else if (qName.equals("mot_de_passe")) {
            mot_de_passeTag = "open";
        } else if (qName.equals("adresse")) {
            adresseTag = "open";
        } else if (qName.equals("telephone")) {
            telephoneTag = "open";
        } else if (qName.equals("role")) {
            roleTag = "open";
        } else if (qName.equals("date")) {
            dateTag = "open";
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("mydata")) {
            // we are no longer processing a <reg.../> tag
            utilisateur.addElement(currentUtilisateur);
            currentUtilisateur = null;
        } else if (qName.equals("Id")) {
            id = "close";
        } else if (qName.equals("FirstName")) {
            firstname = "close";
        } else if (qName.equals("password")) {
            password = "close";
        } 
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
     {
            // don't forget to trim excess spaces from the ends of the string

            if (id.equals("open")) {

                String id = new String(ch, start, length).trim();
                currentUtilisateur.setId_membre(Integer.parseInt(id));

            } else if (firstname.equals("open")) {

                String username = new String(ch, start, length).trim();
                currentUtilisateur.setUsername(username);
            } else if (password.equals("open")) {
                String password = new String(ch, start, length).trim();
                currentUtilisateur.setPassword(password);
            }
        }
    }
}
