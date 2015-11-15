/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkingdimmers.Views;

import static Defaults.Const.RESISTOR_VIEW_HEIGHT;
import static Defaults.Const.RESISTOR_VIEW_WIDTH;
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
        setPreferredSize(new Dimension(RESISTOR_VIEW_WIDTH, RESISTOR_VIEW_HEIGHT*10));
        setMinimumSize(new Dimension(RESISTOR_VIEW_WIDTH, RESISTOR_VIEW_HEIGHT*10));
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        for (int i = 0;i<10; ++i) {
            this.add(new ResistorView(initiallPoint));
            initiallPoint.y += RESISTOR_VIEW_HEIGHT;
        }
        
    }
     @Override
    protected void paintComponent(Graphics g) {
        
    }
    
}
