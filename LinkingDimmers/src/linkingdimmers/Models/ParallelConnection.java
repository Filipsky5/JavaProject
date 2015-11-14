/*+
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkingdimmers.Models;

/**
 *
 * @author Filip
 */
public class ParallelConnection extends javax.swing.JPanel {
    private Resistor[] resistors;
    /**
     * Creates new form ParallelConnection
     */
    public ParallelConnection() {
        initComponents();
    }
    
    public ParallelConnection(Resistor[] _resistors) {
        this.resistors = _resistors;    
    }
    
    public double countResistance() {// wyliczanie oporu równoleglego
        double resistanceToReturn = 0.0;
        for (Resistor r : this.resistors) {
            resistanceToReturn += 1.0/r.countResistence();
        }
        return 1/resistanceToReturn;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}