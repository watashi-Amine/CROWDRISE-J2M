package com.crowd.gui;

import com.crowd.entities.evenement;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.MIDlet;

import com.jappit.midmaps.googlemaps.GoogleMaps;
import com.jappit.midmaps.googlemaps.GoogleMapsCoordinates;
import com.jappit.midmaps.googlemaps.GoogleStaticMap;
import com.jappit.midmaps.googlemaps.GoogleStaticMapHandler;
import com.sun.lwuit.Form;
import com.sun.lwuit.animations.Transition3D;
import googlemapapi2.GoogleMapsTestCanvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;

public class GoogleMap extends GoogleMapsTestCanvas implements GoogleStaticMapHandler,CommandListener
{
	GoogleMaps gMaps = null;
	GoogleStaticMap map = null;
	    Command cmd = new Command("Menu", Command.BACK, 0);

	public GoogleMap(MIDlet m, Displayable testListScreen,evenement e)
	{
		super(m, testListScreen);
		            System.out.println("zsssssssssssssssssss");

		gMaps = new GoogleMaps();
		
		map = gMaps.createMap(getWidth(), getHeight(), GoogleStaticMap.FORMAT_PNG);
		
		map.setHandler(this);
		
		map.setCenter(new GoogleMapsCoordinates(e.getLatitude(), e.getLongitude()));
		
		map.setZoom(15);
		
		map.update();
                addCommand(cmd);
                setCommandListener(this);
	}
	
	protected void paint(Graphics g)
	{
		map.draw(g, 0, 0, Graphics.TOP | Graphics.LEFT);
	}
	public void GoogleStaticMapUpdateError(GoogleStaticMap map, int errorCode, String errorMessage)
	{
		          System.out.println("map error");
	}
	public void GoogleStaticMapUpdated(GoogleStaticMap map)
	{
		repaint();
	}
        
          public void commandAction(Command c, Displayable d) {
        if (c == cmd) {
            Form m = new Menu("Menu");
           m.show();
        }}
}