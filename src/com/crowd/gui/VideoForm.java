/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowd.gui;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.crowd.midlet.CrowdRiseMidlet;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.GUIControl;


public class VideoForm extends Form implements CommandListener,Runnable{
    Display disp;
    Player player = null;
    Player player2 = null;
    Command Retourcmd = new Command("Retour", Command.SCREEN, 0);
    Command passcmd = new Command("passer", Command.SCREEN, 0);



    public VideoForm(String title, Display disp) {
        super(title);
        this.disp=disp;
        addCommand(Retourcmd);
        addCommand(passcmd);

        this.setCommandListener(this);
        try {
            loadPlayer();
            GUIControl guiControl = (GUIControl) player.getControl("javax.microedition.media.control.GUIControl");
            if (guiControl == null) {
                throw new Exception("No GUIControl!!");
            }
            Item videoItem = (Item) guiControl.initDisplayMode(GUIControl.USE_GUI_PRIMITIVE, null);
            this.insert(0, videoItem);
            player.start();
            player2.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        disp.setCurrent(this);
    }

    public void commandAction(Command c, Displayable d) {
        
        if (c == Retourcmd) {
            
                   player.close();
                   player2.close();
            
            com.sun.lwuit.Form f = new Menu("Menu");
            f.show();
        }
        
            if (c == passcmd ) {
            
                  player.close();
                   player2.close();
                
                
            com.sun.lwuit.Form f = new FormListProjet("Projets");
            f.show();
        }
        //       if(c==Retour){
//           ListeChoix choix =new ListeChoix(disp);
//                    Midlet.mMidlet.disp.setCurrent( choix );
//                    player.close();
//                    player2.close();
//
//       }

    }

    public void run() {
        
    }
    
    private void loadPlayer() throws Exception {
    player = Manager.createPlayer("http://localhost/crowdRiseMobile/Probleme/charity.gif");
    player.realize();
    player2 = Manager.createPlayer("http://localhost/crowdRiseMobile/Probleme/charity.wav");
    player2.realize();
    }

}
