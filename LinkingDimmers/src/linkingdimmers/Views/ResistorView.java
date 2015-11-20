/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkingdimmers.Views;


import static Defaults.Const.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import linkingdimmers.Models.*;

/**
 *
 * @author Filip
 */
public final class ResistorView extends JPanel {
    JButton []stripesUpButtons; 
    JButton []stripesDownButtons;
    Point initailPoint;
    JPanel panel;
    Resistor resistor;
    boolean isInitial;
    public ResistorView (Point _initialPoint, boolean _isInitial) {
        this.isInitial = _isInitial;
        this.initViews(_initialPoint);
    }

    private void initViews(Point _initialPoint) {
        this.initailPoint = new Point(_initialPoint);
        //setBackground(BACKGROUND_COLOR);
        this.setLayout(null);
        setLocation(initailPoint.x, initailPoint.y);
        setSize(80, 40);
        setPreferredSize(new Dimension(RESISTOR_VIEW_WIDTH,RESISTOR_VIEW_HEIGHT));
        setMinimumSize(new Dimension(RESISTOR_VIEW_WIDTH,RESISTOR_VIEW_HEIGHT));
        setOpaque(true);
        try {
            this.addButtons();
        } catch (IOException ex) {
            System.out.print("Erro while adding image");
       }
        StripeColor [] sc = new StripeColor[NUMBER_OF_STRIPES];
        for (int i = 0; i < NUMBER_OF_STRIPES; ++i) {
            sc[i] = StripeColor.BLACK;
        }
        resistor = new Resistor(sc);
    }
    private void addButtons() throws IOException {
        stripesUpButtons = new JButton[NUMBER_OF_STRIPES];
        stripesDownButtons = new JButton[NUMBER_OF_STRIPES];
        BufferedImage arrowDown;
        BufferedImage arrowUp;
        arrowDown = ImageIO.read(new File("C:\\Users\\Filip\\Documents\\JavaProject\\LinkingDimmers\\src\\Image\\arrowDown.png"));
        arrowUp = ImageIO.read(new File("C:\\Users\\Filip\\Documents\\JavaProject\\LinkingDimmers\\src\\Image\\arrowUp.png"));
        
        for (int i =0; i < NUMBER_OF_STRIPES; ++i) {
           
            stripesUpButtons[i] = new JButton(new ImageIcon(arrowUp));
            stripesUpButtons[i].setPreferredSize(new Dimension(10,10));
            stripesUpButtons[i].setMinimumSize(new Dimension(10,10));
            stripesUpButtons[i].setLocation(STRIPE_WIDTH*2*i + 32, 0);
            stripesUpButtons[i].setSize(new Dimension(10,10));
            
            stripesUpButtons[i].addActionListener((ActionEvent e) -> {
                JButton source = (JButton)e.getSource();
                int index = 0;
                for (int j = 0; j < stripesUpButtons.length; ++j) {
                    if (stripesUpButtons[j] == source) {
                        index = j;
                    }
                }
                boolean addValueToBands;
                if (index == NUMBER_OF_STRIPES - 1) {
                    addValueToBands = resistor.addValueToMultiplier(10, index);
                    
                } else {
                    addValueToBands = resistor.addValueToBands(1, index);
                }
                this.repaint();
                System.out.println("Button up at index: " + index + "pressed" );
                
            });
            
            stripesDownButtons[i] = new JButton(new ImageIcon(arrowDown));
            stripesDownButtons[i].setPreferredSize(new Dimension(10,10));
            stripesDownButtons[i].setMinimumSize(new Dimension(10,10));
            stripesDownButtons[i].setSize(new Dimension(10,10));
            stripesDownButtons[i].setLocation(STRIPE_WIDTH*2*i + 32, RESISTOR_HEIGHT+30);
            
            stripesDownButtons[i].addActionListener((ActionEvent e) -> {
                JButton source = (JButton)e.getSource();
                int index = 0;
                for (int j = 0; j < stripesDownButtons.length; ++j) {
                    if (stripesDownButtons[j] == source) {
                        index = j;
                    }
                }
                boolean addValueToBands;
                if (index == NUMBER_OF_STRIPES - 1) {
                    addValueToBands = resistor.addValueToMultiplier(0.1, index);
                    
                } else {
                    addValueToBands = resistor.addValueToBands(-1, index);
                }
                this.repaint();
                System.out.println("Button down at index: " + index + "pressed" );
                    
              });
            
            System.out.println("Stripe Up "+ "x: " + (STRIPE_WIDTH*2*i + 32) + "y: " + 0 );
            System.out.println("Stripe Down "+ "x: " + (STRIPE_WIDTH*2*i + 32) + "y: " + (RESISTOR_HEIGHT+30) );
            this.add(stripesDownButtons[i]);
            this.add(stripesUpButtons[i]);
        }
       // this.invalidate();
    }
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2d = (Graphics2D)graphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        float r = (float) (84.0/255.0);
        float g = (float) (84.0/255);
        float b = (float) (84.0/255.0);
        Color grey = new Color(r,g,b);
        g2d.setColor(grey);
        int resistorXPosition = 22;
        int resistorYPosition = 20;
        g2d.fillRoundRect(resistorXPosition, resistorYPosition, RESISTOR_WIDTH, 
                           RESISTOR_HEIGHT, 30, 30); 
        for (int i = 0; i < NUMBER_OF_STRIPES; ++i) {
            Color c = resistor.colorOfStripeAtIndex(i);
            g2d.setColor(c);
            g2d.fillRect(STRIPE_WIDTH*2*i + resistorXPosition + 10, resistorYPosition, STRIPE_WIDTH, RESISTOR_HEIGHT);
        }
        this.addWires(g2d,resistorXPosition,resistorYPosition);
  }
    private void addWires(Graphics2D graphics, int resistorXPosition, int resistorYPosition) {
        graphics.setColor(Color.BLACK);
        int firstWirePoint = isInitial ? 0 : 5;
        int middleYPositionOfResistor = resistorYPosition + (int)(RESISTOR_HEIGHT / 2.0);
        
        graphics.fillRect(firstWirePoint, middleYPositionOfResistor, resistorXPosition - firstWirePoint , 1); // left middle wire
        
        graphics.fillRect(5, middleYPositionOfResistor, 1, RESISTOR_VIEW_HEIGHT - middleYPositionOfResistor); // left down wire
        
        graphics.fillRect(5, 0, 1, RESISTOR_VIEW_HEIGHT - middleYPositionOfResistor); // left up wire
        
        
        int rightMiddleWireXPosition = resistorXPosition + RESISTOR_WIDTH; 
        graphics.fillRect(rightMiddleWireXPosition, middleYPositionOfResistor, RESISTOR_VIEW_WIDTH - rightMiddleWireXPosition , 1); // right middle wire
        
        graphics.fillRect(RESISTOR_VIEW_WIDTH - 5, middleYPositionOfResistor, 1, RESISTOR_VIEW_HEIGHT - middleYPositionOfResistor); // right down wire
        
        
        
        graphics.fillRect(RESISTOR_VIEW_WIDTH - 5, 0, 1, RESISTOR_VIEW_HEIGHT - middleYPositionOfResistor); // right up wire
        
        
    }
    
    // Model
    public double countResistance() {
        return resistor.countResistence();
    }
}
