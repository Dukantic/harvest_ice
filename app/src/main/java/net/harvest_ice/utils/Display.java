package net.harvest_ice.utils;


import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class Display {
    private JFrame frame ;
    private JLabel moneyDisplay;
    private JPanel buttons;
    private JButton bigger;
    private JButton faster;
    private Font font;

    public Display()
    {
        this.frame = new JFrame("Harvest Ice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);

        this.moneyDisplay = new JLabel("0", JLabel.CENTER);
        this.buttons = new JPanel();
        this.bigger = new JButton("Bigger");
        this.faster = new JButton("Faster");

        this.buttons.add(this.bigger);
        this.buttons.add(this.faster);

        this.frame.setLayout(new GridLayout(2,1));
        frame.add(this.moneyDisplay);
        frame.add(this.buttons);
        
        this.font = new Font("Arial", Font.PLAIN, 20); // Nom, style, taille
        moneyDisplay.setFont(font);
        bigger.setFont(font);
        faster.setFont(font);
    }

}
