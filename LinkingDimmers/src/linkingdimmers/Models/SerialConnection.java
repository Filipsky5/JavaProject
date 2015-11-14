/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkingdimmers.Models;

/**
 *
 * @author Filip
 */
public class SerialConnection {
    private ParallelConnection[] parallelConnections;
    
    public SerialConnection(ParallelConnection[] _parallelConnections) {
        this.parallelConnections = _parallelConnections;
    }
    
    public double countResistance() {
        double resistance = 0.0;
        for (ParallelConnection p : parallelConnections) {
            resistance += p.countResistance();
        }
        return resistance;
    }
    
}

