/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkingdimmers.Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Filip
 */
public class ParallelConnectionView extends JPanel {
    Point initiallPoint;
    public ParallelConnectionView(Point _initiallPoint) {
        //JPanel panel = new JPanel();
        this.initiallPoint = new Point(_initiallPoint);
        
         setBackground(Color.YELLOW);
        setLocation(initiallPoint.x, initiallPoint.y);
       // FlowLayout flow = new FlowLayout();
        //setLayout(null);
        setPreferredSize(new Dimension(80, 500));
        setMinimumSize(new Dimension(80, 500));
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        for (int i = 0;i<10; ++i) {
            this.add(new ResistorView(initiallPoint));
            initiallPoint.y += 50;
        }
        
    }
     @Override
    protected void paintComponent(Graphics g) {
        
    }
    
}
