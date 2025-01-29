package net.harvest_ice.utils;

import net.harvest_ice.utils.*;
import java.awt.GridLayout;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private float priceBigger = 2;
    private JButton faster;
    private float priceFaster = 5;
    private Font font;
    private Click userClick;

    public Display(Click userClick)
    {
        this.userClick = userClick;
        this.frame = new JFrame("Harvest Ice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);

        this.moneyDisplay = new JLabel("0", JLabel.CENTER);
        this.buttons = new JPanel();
        this.bigger = new JButton("Bigger");
        this.faster = new JButton("Faster");

        this.buttons.add(this.bigger);
        bigger.setText("Bigger:" + String.format("%.2f", priceBigger) + "¤");
        linkBigger();
        this.buttons.add(this.faster);
        faster.setText("Faster:" + String.format("%.2f", priceFaster) + "¤");
        linkFaster();

        this.frame.setLayout(new GridLayout(2,1));
        frame.add(this.moneyDisplay);
        frame.add(this.buttons);
       
        try
        {
            InputStream fontStream = getClass().getResourceAsStream("/Erika_Ormig.ttf");
            this.font =  Font.createFont(Font.TRUETYPE_FONT, fontStream);
            this.font = this.font.deriveFont(50f);
            moneyDisplay.setFont(font);
            bigger.setFont(font);
            faster.setFont(font);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Can't open font!");

            this.font = new Font("Arial", Font.PLAIN, 24);
            moneyDisplay.setFont(font);
            bigger.setFont(font);
            faster.setFont(font);
        }
    }

    public void update(Click current)
    {
        this.moneyDisplay.setText(current.toString());
    }

    private void linkBigger()
    {
        this.bigger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (userClick.purchaseMoreTime(priceBigger))
                {
                    priceBigger *= 1.3;
                    bigger.setText("Bigger:" + String.format("%.2f", priceBigger) + "¤");
                }
            }
        });
    }

    private void linkFaster()
    {
        this.faster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (userClick.purchaseLessTime(priceFaster))
                {
                    priceFaster *= 1.3;
                    faster.setText("Faster:" + String.format("%.2f", priceFaster) + "¤");
                }
            }
        });
    }


}
