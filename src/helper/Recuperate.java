/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import com.sun.lwuit.Image;

/**
 *
 * @author Amin
 */
public class Recuperate {

    public static Image GetImageServer(String url) {
        Image img = null;
        try {

            HttpConnection hc = (HttpConnection) Connector.open(url);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            img = Image.createImage(dis);
            hc.close();
            dis.close();
            return img;

        } catch (IOException ex) {
            System.out.println("Image From Server Problem" + ex);
        }

        return img;
    }

    public static String GetTextServer(String url) {

        HttpConnection hconx;
        DataInputStream allData;
        StringBuffer resultat = new StringBuffer("");
        int ascii;

        String ResultatString = null;
        try {
            hconx = (HttpConnection) Connector.open(url);
            allData = hconx.openDataInputStream();

            while ((ascii = allData.read()) != -1) {
                resultat.append((char) ascii);
            }

            ResultatString = resultat.toString();
            hconx.close();
            allData.close();

        } catch (IOException ex) {
            System.out.println("Text From Server problem : " + ex);
        }

        return ResultatString;
    }

    public static DataInputStream GetInputStreamServer(String url) {

        HttpConnection hconx;
        DataInputStream allData;

        try {
            hconx = (HttpConnection) Connector.open(url);
            allData = hconx.openDataInputStream();
            return allData;

        } catch (IOException ex) {
            System.out.println("Text From Server problem : " + ex);
        }

        return null;
    }

}
