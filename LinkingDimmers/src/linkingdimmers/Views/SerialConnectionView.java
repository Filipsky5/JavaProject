/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkingdimmers.Views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Filip
 */
public class SerialConnectionView extends JPanel {
    int numberOfConnections;
    Point initiallPoint;
    public SerialConnectionView(Point _initiallPoint, int _numberOfConnections) {
        JPanel serialPanel = new JPanel();
        this.initiallPoint = new Point(_initiallPoint);
        numberOfConnections = _numberOfConnections;
        
        setBackground(Color.WHITE);
        setLocation(_initiallPoint.x, _initiallPoint.y);
        setSize(100*numberOfConnections, 500);
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        for (int i = 0; i<numberOfConnections; ++i) {
            ParallelConnectionView pcv = new ParallelConnectionView(initiallPoint);
            this.add(pcv);
            initiallPoint.x += 100;
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
     
    }
    
}
