/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowd.midlet;

import com.crowd.gui.ConnexionForm;
import com.crowd.gui.Menu;
import com.sun.lwuit.Button;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.FlowLayout;
import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.util.Resources;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.midlet.MIDlet;




/**
 * @author MohamedAmine
 */
public class CrowdRiseMidlet extends MIDlet {
    
    public   Display Disp ;
    public  javax.microedition.lcdui.Display Displcdui= javax.microedition.lcdui.Display.getDisplay(this);
   public static CrowdRiseMidlet Mc ; 
   public static CrowdRiseMidlet Mclcdui ; 
    private Resources r;
              Player p;
     InputStream is= getClass().getResourceAsStream("/SoundMP3/ShakeYourBootay.wav");
            
            
    public void startApp() {
       Mc=this;
       Mclcdui=this;
        Disp.init(this);
       
            try {
            r = Resources.open("/com/crowd/res/araga.res");
            UIManager.getInstance().addThemeProps(r.getTheme("Theme 1"));
        } catch (IOException ex) {
            ex.getMessage();
        }
          try {
          p=Manager.createPlayer(is, "audio/x-wav");
      } catch (IOException ex) {
          ex.printStackTrace();
      } catch (MediaException ex) {
          ex.printStackTrace();
      }
      try {
          p.start();
      } catch (MediaException ex) {
          ex.printStackTrace();
      }
        
        
  

Form f = new ConnexionForm("Bonjour :) ");
f.show();
         
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
