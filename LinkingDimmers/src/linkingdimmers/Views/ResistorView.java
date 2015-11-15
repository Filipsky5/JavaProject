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
    public ResistorView(Point _initialPoint) {
        this.initailPoint = new Point(_initialPoint);
        //setBackground(Color.WHITE);
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

        //setBorder(BorderFactory.createLineBorder(Color.WHITE));
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
            
            stripesUpButtons[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    boolean addValueToBands = resistor.addValueToBands(1, i);
                }
            } );
            
            stripesDownButtons[i] = new JButton(new ImageIcon(arrowDown));
            stripesDownButtons[i].setPreferredSize(new Dimension(10,10));
            stripesDownButtons[i].setMinimumSize(new Dimension(10,10));
            stripesDownButtons[i].setSize(new Dimension(10,10));
            stripesDownButtons[i].setLocation(STRIPE_WIDTH*2*i + 32, RESISTOR_HEIGHT+30);
            
            stripesDownButtons[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
                }
            } );
            
            System.out.println("Stripe Up "+ "x: " + (STRIPE_WIDTH*2*i + 32) + "y: " + 0 );
            System.out.println("Stripe Down "+ "x: " + (STRIPE_WIDTH*2*i + 32) + "y: " + (RESISTOR_HEIGHT+30) );
            this.add(stripesDownButtons[i]);
            this.add(stripesUpButtons[i]);
        }
       // this.invalidate();
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.gray);
        g.fillRoundRect(22, 20, RESISTOR_WIDTH - 4, 
                           RESISTOR_HEIGHT - 4, 30, 30); 
        for (int i = 0; i < NUMBER_OF_STRIPES; ++i) {
            g.setColor(Color.BLACK);
            g.fillRect(STRIPE_WIDTH*2*i + 32, 20, STRIPE_WIDTH, RESISTOR_HEIGHT - 4);
        }
  }
}
