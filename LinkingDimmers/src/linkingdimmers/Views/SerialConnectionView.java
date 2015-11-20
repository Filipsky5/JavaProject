/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkingdimmers.Views;

import static Defaults.Const.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.management.Notification;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.management.AttributeChangeNotification;
import javax.management.NotificationBroadcasterSupport;
import linkingdimmers.Models.Notifier;
import linkingdimmers.Models.SerialConnection;
/**
 *
 * @author Filip
 */
public class SerialConnectionView extends JPanel implements Runnable{
    int numberOfConnections;
    int sequenceNumber = 0;
    double oldResistance = 0;
    Point initiallPoint;
    Notifier notifier;
    ParallelConnectionView []pcvArray;
    SerialConnection serialConnection;
    
    private volatile Thread blinker;
    
    public SerialConnectionView(Point _initiallPoint, int _numberOfConnections, int parallelConnections, Notifier _notifier) {
        JPanel serialPanel = new JPanel();
        this.initiallPoint = new Point(_initiallPoint);
        numberOfConnections = _numberOfConnections;
        
        setBackground(Color.WHITE);
        setLocation(_initiallPoint.x, _initiallPoint.y);
        setSize(RESISTOR_VIEW_WIDTH*numberOfConnections + numberOfConnections*10, 10*RESISTOR_VIEW_HEIGHT);
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        BorderLayout bl = new BorderLayout(0,0);
        pcvArray = new ParallelConnectionView[numberOfConnections];
        for (int i = 0; i<numberOfConnections; ++i) {
            ParallelConnectionView pcv = new ParallelConnectionView(initiallPoint,parallelConnections);
            this.add(pcv,bl.CENTER);
            pcvArray[i] = pcv;
            initiallPoint.x += RESISTOR_VIEW_WIDTH;
        }
        serialConnection = new SerialConnection(pcvArray);
        notifier = _notifier;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
     
    }
    private double countResistance() {
        return serialConnection.countResistance();
    }
    
    private double [] countEachParallelResitance() {
        double [] valuesToReturn = new double [numberOfConnections];
         for (int i = 0; i<numberOfConnections; ++i) {
             valuesToReturn[i] = pcvArray[i].countResistance();
         }
        return valuesToReturn;
    }
    
     public void start() {
        blinker = new Thread(this);
        blinker.start();
    }
    
    public void stop() {
        blinker = null;
    }
    
    public void allPositions() {
         for (int i = 0; i<numberOfConnections; ++i) {
             System.out.printf(String.valueOf(pcvArray[i].getX()));
         }
    }

    @Override
    public void run() {
        double resistance = 0.0;
        Thread thisThread = Thread.currentThread();
        while (blinker == thisThread) {
            resistance = countResistance();
            notifier.sendResistornotificationWithValue(resistance,countEachParallelResitance());
           
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {}
        }
        
        
    }
    
}

