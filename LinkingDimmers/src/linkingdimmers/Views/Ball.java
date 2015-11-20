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
public class Ball extends JPanel {
     
    public int initialX;
    public int x;
    public int y;
    public double road;
    public double resistance;
    public double tension;
    public double intensity;
    public double time;
    String name;
    
    

    public synchronized void setNewResistance(double _resistance) {
        resistance = _resistance;
    }
    
    public synchronized double getResistance() {
        return resistance;
    }

    
    public Ball(int _y,int _x, double _resistance, double _tension, int _road) {
        this.y = _y;
        this.initialX = _x;
        this.resistance = _resistance;
        this.tension = _tension;
        road = _road;
        
        this.setLayout(null);
        this.setLocation(_x, _y);
        this.y = 20 + (int)(RESISTOR_HEIGHT / 2.0);
        this.setSize(new Dimension((int) road,100));
        setOpaque(true);
        setBackground(BACKGROUND_COLOR);
       
        //setBorder(BorderFactory.createLineBorder(Color.BLUE));
    }
  
   
  
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println(name+" "+x+" "+y);
        g.setColor(Color.BLACK);
        g.fillRect(0,y,(int) this.road, 1);
        g.fillRect(5, y, 1, RESISTOR_VIEW_HEIGHT - y);
        g.fillRect((int) (this.road - 5), y, 1, RESISTOR_VIEW_HEIGHT - y); 
        int r = 20;//(int)(50/230 * (tension / resistance));
        g.setColor(Color.orange);
        g.fillOval(x, (int) (y - r / 2.0),r,r);
    }   
}

