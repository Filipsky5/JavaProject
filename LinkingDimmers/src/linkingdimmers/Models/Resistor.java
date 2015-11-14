/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkingdimmers.Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 * 
 */
public class Resistor {
    List<Color> Bands;
    Color Multiplier;
    
    public Resistor (Color[] stripes) {
       this.Bands = new ArrayList<Color>();
       for (Color r : stripes) {
           this.Bands.add(r);
       }
       Multiplier = stripes[stripes.length - 1];
   }
    
    public double countResistence() {
        double valueOfresistance = 0.0;
        for (Color c : Bands) {
            valueOfresistance += c.getValue();
        }
        valueOfresistance *= Multiplier.getMultiplier();
        return valueOfresistance;
    }
    
    public boolean addValueToBands(double value, int indexOfStripe) {
        if (indexOfStripe >= Bands.size()) {
            return false;
        }
        int valueOfStripe = Bands.get(indexOfStripe).getValue();
        valueOfStripe += value;
        if (valueOfStripe > 9 || valueOfStripe < 0) {
            return false;
        }
        Bands.set(indexOfStripe,Color.getColorForValue(valueOfStripe));
        return true;
    }
    public boolean addValueToMultiplier(double value, int indexOfStripe) {
        
        double valueOfMul = Multiplier.getMultiplier();
        valueOfMul += value;
        Multiplier = Color.getColorForMultiplier(value);
        return true;
    }
}
