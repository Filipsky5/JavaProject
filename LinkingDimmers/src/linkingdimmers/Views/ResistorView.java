/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkingdimmers.Views;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Filip
 */
public final class ResistorView extends JComponent {
   
    Point initailPoint;
    public ResistorView(Point _initialPoint) {
        JPanel buttonPanel = new JPanel();
        this.initailPoint = new Point(_initialPoint);
        
        //setBackground(Color.WHITE);
        setLocation(initailPoint.x, initailPoint.y);
        setSize(80, 40);
        setPreferredSize(new Dimension(80,40));
        setMinimumSize(new Dimension(80,40));
        setOpaque(true);
        //setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.gray);
        g.fillRoundRect(2, 2, this.getWidth() - 4, 
                           this.getHeight() - 4, 30, 30); 
  }
}
