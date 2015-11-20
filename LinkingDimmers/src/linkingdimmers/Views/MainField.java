/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkingdimmers.Views;

import static Defaults.Const.RESISTOR_VIEW_WIDTH;
import static Defaults.Const.RESISTOR_WIDTH;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import linkingdimmers.Models.Notifier;
import linkingdimmers.Models.PositionForBallCounter;
import linkingdimmers.Models.ResistanceListener;

/**
 *
 * @author Filip
 */
public class MainField extends javax.swing.JFrame implements ResistanceListener{

    /**
     * Creates new form MainField
     */
    public MainField() {
        initComponents();
    }
    private Notifier notifier;
    private Ball[] balls;
    private SerialConnectionView scv;
    PositionForBallCounter pfbc;
    int numberOfSerialConnections;
    int initialPointX;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        MenuPanel = new javax.swing.JPanel();
        SerialConnectionsSpinner = new javax.swing.JSpinner();
        SerialConnectionsAddButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SummaryResistanceLabel = new javax.swing.JLabel();
        ParallelConnectionsSpinner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        tensionLabel = new javax.swing.JLabel();
        TensionSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setBackground(new java.awt.Color(0, 255, 51));

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1780, Short.MAX_VALUE)
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        MenuPanel.setBackground(new java.awt.Color(102, 102, 255));

        SerialConnectionsSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        SerialConnectionsAddButton.setText("Add");
        SerialConnectionsAddButton.setActionCommand("AddSerialConnections");
        SerialConnectionsAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SerialConnectionsAddButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Serial Connections");

        jLabel2.setText("Summary Resistance");

        SummaryResistanceLabel.setText("Rz");

        ParallelConnectionsSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 7, 1));

        jLabel3.setText("Parallel Connections");

        tensionLabel.setText("Tension");

        TensionSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 230, 1));
        TensionSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TensionSpinnerStateChanged(evt);
            }
        });
        TensionSpinner.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TensionSpinnerPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanelLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(MenuPanelLayout.createSequentialGroup()
                            .addComponent(tensionLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TensionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(SummaryResistanceLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanelLayout.createSequentialGroup()
                            .addComponent(SerialConnectionsAddButton)
                            .addGap(18, 18, 18)
                            .addComponent(SerialConnectionsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(33, 33, 33))
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(ParallelConnectionsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SerialConnectionsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SerialConnectionsAddButton))
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(SummaryResistanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(ParallelConnectionsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tensionLabel)
                    .addComponent(TensionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(620, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(MenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    private void stopBallsThreads() {
//        if (balls != null) {
//            for (Ball b : balls) {
//                b.stop();
//            }
//        }
//    }
//    private void startAllThreads() {
//        if (balls != null) {
//            for (Ball b : balls) {
//                b.start();
//            }
//        }
//        
//    }
    private void SerialConnectionsAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SerialConnectionsAddButtonActionPerformed
        // TODO add your handling code here:
        if (scv != null) {
            scv.stop();
        }
        if (pfbc != null) {
            pfbc.stop();
        }
        pfbc = null;
        this.MainPanel.removeAll();
//        this.stopBallsThreads();
        Point initialPoint = new Point();
        initialPoint.x = 50;
        initialPoint.y = 50;
        initialPointX = initialPoint.x;
        notifier = new Notifier();
        notifier.addListener(this);
        
        numberOfSerialConnections = (int)SerialConnectionsSpinner.getValue();
        balls = new Ball[numberOfSerialConnections];
        
         scv =  new SerialConnectionView(initialPoint,numberOfSerialConnections,(int)ParallelConnectionsSpinner.getValue(), notifier);
        scv.start();
        this.MainPanel.add(scv);
        scv.allPositions();
        this.pack();
        
        this.setVisible(true);
//        startAllThreads();
        this.repaint();
        
       
        
        
    }//GEN-LAST:event_SerialConnectionsAddButtonActionPerformed

    private void TensionSpinnerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TensionSpinnerPropertyChange
        // TODO add your handling code here:
        if (pfbc!= null) {
            pfbc.tension = (int) TensionSpinner.getValue();
        }
    }//GEN-LAST:event_TensionSpinnerPropertyChange

    private void TensionSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TensionSpinnerStateChanged
        // TODO add your handling code here:
        if (pfbc!= null) {
            pfbc.tension = (int) TensionSpinner.getValue();
        }
    }//GEN-LAST:event_TensionSpinnerStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainField.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainField.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainField.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainField.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainField().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JSpinner ParallelConnectionsSpinner;
    private javax.swing.JButton SerialConnectionsAddButton;
    private javax.swing.JSpinner SerialConnectionsSpinner;
    private javax.swing.JLabel SummaryResistanceLabel;
    private javax.swing.JSpinner TensionSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel tensionLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void someoneSaidHello() {
        System.out.println("Hello there...");
    }

    @Override
    public void resistanceChanged(double resistance,double[] parallelResistance) {
        SummaryResistanceLabel.setText(String.valueOf(resistance));
    }
    @Override
    public void graphicsLoaded() {
        if (pfbc == null) {
            this.addWires(numberOfSerialConnections, initialPointX);
        }
    }
    
    public void addWires(int numberOfSerialConnections, int initialPointX) {
        int []xPositions = scv.allPositions();
        int x = (RESISTOR_VIEW_WIDTH - RESISTOR_WIDTH) / 2;
        x = RESISTOR_WIDTH + x;
        int correct = 5;
        int tension = (int) TensionSpinner.getValue();
        for (int i = 0 ; i < numberOfSerialConnections; ++i) {
            //int inititalPointX = i == 0 ? initialPointX : 0;
            Ball ball;
            double widthOfPreviousWire = i > 0 ? balls[i-1].road : 0.0;
            int previousX = i > 0 ? balls[i-1].initialX : 20;
            int xPosition =initialPointX + xPositions[i] + 110;//inititalPointX +(int)widthOfPreviousWire+previousX+RESISTOR_WIDTH+correct;//(int)widthOfPreviousWire + 60 + x + i*RESISTOR_WIDTH;
            int width;
            if (i == numberOfSerialConnections - 1) {// if it is last
                width = this.MainPanel.getWidth() - (x + RESISTOR_WIDTH);
                ball = new Ball(60,xPosition,10,tension,width);
            } else {
                width = xPositions[i+1] - xPositions[i] - 85;
                ball = new Ball(60,xPosition,10,tension,width);
            }
            this.MainPanel.add(ball);
            balls[i] = ball;
        }
        pfbc = new PositionForBallCounter(balls);
        pfbc.start();
    }
    

}
