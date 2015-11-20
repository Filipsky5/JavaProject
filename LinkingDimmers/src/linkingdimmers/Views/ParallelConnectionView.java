/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkingdimmers.Views;

import static Defaults.Const.NUMBER_OF_STRIPES;
import static Defaults.Const.RESISTOR_VIEW_HEIGHT;
import static Defaults.Const.RESISTOR_VIEW_WIDTH;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import linkingdimmers.Models.ParallelConnection;

/**
 *
 * @author Filip
 */
public class ParallelConnectionView extends JPanel {
    Point initiallPoint;
    private List<ResistorView> resistors;
    private ParallelConnection parallelConnection;
    
    public ParallelConnectionView(Point _initiallPoint, int numberOfConnections) {
        //JPanel panel = new JPanel();
        this.initiallPoint = new Point(_initiallPoint);
        
        this.resistors = new ArrayList<ResistorView>();
        
         setBackground(Color.YELLOW);
        // setLayout(null);
        //setLocation(initiallPoint.x, initiallPoint.y);
       // FlowLayout flow = new FlowLayout();
        //setLayout(null);
        setPreferredSize(new Dimension(RESISTOR_VIEW_WIDTH, RESISTOR_VIEW_HEIGHT*numberOfConnections + numberOfConnections * 10));
        setMinimumSize(new Dimension(RESISTOR_VIEW_WIDTH, RESISTOR_VIEW_HEIGHT*numberOfConnections + numberOfConnections * 10));
        setSize(new Dimension(RESISTOR_VIEW_WIDTH, RESISTOR_VIEW_HEIGHT*numberOfConnections + numberOfConnections * 10));
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        
        /*JButton addButton = new JButton();
        addButton.setPreferredSize(new Dimension(30,20));
        addButton.setMinimumSize(new Dimension(30, 20));
        addButton.addActionListener((ActionEvent e) -> {
            this.addResistor();
         });
        this.add(addButton);
        
        JButton removeButton = new JButton();
        removeButton.setPreferredSize(new Dimension(30, 20));
        removeButton.setMinimumSize(new Dimension(30, 20));
        removeButton.addActionListener((ActionEvent e) -> {
            this.removeResistor();
         });
        removeButton.setText("-");
        
        this.add(removeButton);*/
        for (int i = 0;i<numberOfConnections; ++i) {
            ResistorView resistor = new ResistorView(initiallPoint, (i == 0));
            this.add(resistor);
            initiallPoint.y += RESISTOR_VIEW_HEIGHT;
            this.resistors.add(resistor);
        }
        parallelConnection = new ParallelConnection(this.resistors);
        
    }
//    void addResistor() {
//        ResistorView resistor = new ResistorView(initiallPoint);
//        this.add(resistor);
//        initiallPoint.y += RESISTOR_VIEW_HEIGHT;
//        this.resistors.add(resistor);
//        this.repaint();
//    }
//    void removeResistor() {
//        ResistorView resistor = this.resistors.get(this.resistors.size() - 1);
//        this.remove(resistor);
//        initiallPoint.y -= RESISTOR_VIEW_HEIGHT;
//        this.resistors.remove(resistor);
//        validate();
//        repaint();
//    }
     @Override
    protected void paintComponent(Graphics g) {
        
    }
    
    
    //Model
    public double countResistance() {
       return parallelConnection.countResistance();
    }
    
}
