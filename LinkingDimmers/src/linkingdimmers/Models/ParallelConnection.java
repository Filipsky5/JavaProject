/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkingdimmers.Models;

import java.util.List;
import linkingdimmers.Views.ResistorView;

/**
 *
 * @author Filip
 */
public class ParallelConnection {
    private List<ResistorView>  resistors;
    /**
     * Creates new form ParallelConnection
     */
    public ParallelConnection() {
    }
    
    public ParallelConnection(List<ResistorView> _resistors) {
        this.resistors = _resistors;    
    }
    
    public double countResistance() {// wyliczanie oporu równoleglego
        double resistanceToReturn = 0.0;
        for (ResistorView r : this.resistors) {
            double resistance = r.countResistance();
            if (resistance != 0) {
                resistanceToReturn += 1.0/r.countResistance();
            }
        }
        return resistanceToReturn == 0 ? 0 : 1/resistanceToReturn;
    }
  
}
