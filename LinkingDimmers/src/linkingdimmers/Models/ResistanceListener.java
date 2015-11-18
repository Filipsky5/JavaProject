package linkingdimmers.Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Filip
 */
public interface ResistanceListener {
    void someoneSaidHello();
    //void resistanceChanged(double resistance);
     void resistanceChanged(double resistance, double[] parallelResistance);

}
