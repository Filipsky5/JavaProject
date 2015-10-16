/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkingdimmers;

/**
 *
 * @author student
 * 
 */

public enum Color {
    BLACK(1),BROWN(2),RED(3),ORANGE(4),YELLOW(5),GREEN(6),BLUE(7),PURPLE(7),GREY(8),WHITE(9),GOLD(10),SILVER(11);
    
    private final int value;
    private Color(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public double getMultiplier() {
        switch (value) {
            case(1):
                return 1;
            case(2):
                return 10;
            case(3):
                return 100;
            case(4):
                return 1000;
            case(5):
                return 10000;
            case(6):
                return 100000;
            case(7):
                return 1000000;
            case(8):
                return 10000000;
            case(9):
                return 100000000;
            case(10):
                return 0.1;
            case(11):
                return 0.01;
            default:
                return 1;
        }
    }
}

public class Resistor {
    Color[] LocalResistor;
    
    public float countResistence(int numberOfStripes) {
        double valueOfresistance = LocalResistor[0].getValue() + LocalResistor[1].getValue();
        valueOfresistance *= LocalResistor[2].getMultiplier();
        return valueOfresistance;
    }
    
    public Resistor (int numberOfStripes, Color[] StripesColors) {
       this.LocalResistor = StripesColors;
        
    }
    
   
    
}
