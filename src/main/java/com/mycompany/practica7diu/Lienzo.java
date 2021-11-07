
package com.mycompany.practica7diu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class Lienzo extends JPanel {
    private BufferedImage imagen;
    private Image imageShare;
    private Mat imageMat;

     public Lienzo(){
    }

    @Override
    public void paintComponent(Graphics g){
        this.setPreferredSize(new Dimension(imageShare.getWidth(null), imageShare.getHeight(null)));
        super.paintComponent(g);
        g.drawImage(imageShare, 0, 0, null);
    }
    
    public void openImage(String path){
        imageMat = Imgcodecs.imread(path);
        imageShare = HighGui.toBufferedImage(imageMat);
        this.repaint();
    }
    
    public void closeImage(){
        imageShare=null;
        imageMat=null;
        this.repaint();
    }
    
    @Override
    public int getHeight(){
        if(imageShare==null){
            return 0;
        }else{
            return imageShare.getHeight(null);
        }      
    }
    
    @Override
    public int getWidth(){
        if(imageShare==null){
            return 0;
        }else{
            return imageShare.getWidth(null);
        } 
    }

    public Mat getMatImage(){
        return imageMat;
    }
    
    
    
    
}
