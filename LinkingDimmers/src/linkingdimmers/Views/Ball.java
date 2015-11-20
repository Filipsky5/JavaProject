/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkingdimmers.Views;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import static Defaults.Const.*;
import java.awt.Dimension;
import javax.swing.BorderFactory;

/**
 *
 * @author Filip
 */
public class Ball extends JPanel implements Runnable{
     
    int initialX;
    int x;
    int y;
    public double road;
    private double resistance;
    double intensity;
    double time;
    String name;
    
    private volatile Thread blinker;
    

    public synchronized void setNewResistance(double _resistance) {
        resistance = _resistance;
    }
    
    public synchronized double getResistance() {
        return resistance;
    }

    
    public Ball(int _y,int _x, double _resistance, double _intensity, int _road) {
        this.y = _y;
        this.initialX = _x;
        this.resistance = _resistance;
        this.intensity = _intensity;
        road = _road;
        
        this.setLayout(null);
        this.setLocation(_x, _y);
        this.y = 5;
        this.setSize(new Dimension((int) road,10));
        setOpaque(true);
        setBackground(new Color(0,0,0,64));
       
        //setBorder(BorderFactory.createLineBorder(Color.BLUE));
    }
  
    public void run() {
        
  
        name = Thread.currentThread().getName();
        Thread thisThread = Thread.currentThread();
        while (blinker == thisThread) {
            double tension = intensity * getResistance();
            x =  (int)(tension * time);
            time +=0.5;
            if (x > road) {
                x = 0;
                time = 0;
            }
           // x +=initialX;
            System.out.println(name);
            this.repaint();

            try {
                Thread.sleep(50);
            } catch (Exception ex) {}
        }
    }
    
    public void start() {
        blinker = new Thread(this);
        blinker.start();
    }
    
    public void stop() {
        blinker = null;
    }
  
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println(name+" "+x+" "+y);
         
        g.setColor(Color.orange);
        g.fillOval(x,y,3,3);
    }   
}

