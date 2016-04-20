/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowd.midlet;

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
import javax.microedition.midlet.MIDlet;




/**
 * @author MohamedAmine
 */
public class CrowdRiseMidlet extends MIDlet {
    
    public   Display Disp ;
   public static CrowdRiseMidlet Mc ; 
    private Resources r;
    public void startApp() {
       Mc=this;
        Disp.init(this);
        
            try {
            r = Resources.open("/com/crowd/res/bn.res");
            System.out.println("cbn hmd !!!!!!!!!!!!!!!!!!!!!");
            UIManager.getInstance().addThemeProps(r.getTheme("Theme 1"));
        } catch (IOException ex) {
            ex.getMessage();
            System.out.println("zut c pas bon !!!!!!!!!!!!!!!!");
        }
        
        
        
      
     Form  a = new Menu("Menu");
     a.show();
         
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
