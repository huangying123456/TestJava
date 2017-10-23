package com.test;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TwoButton {
    JFrame frame ;
    JLabel label ;
    MyDrawPanel drawPanel;

    public static void main(String[] args) {
        TwoButton gui = new TwoButton() ;
        gui.go() ;
    }

    public void go() {
        frame = new JFrame() ;
        drawPanel = new MyDrawPanel() ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Label") ;
        labelButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("Change Color") ;
        colorButton.addActionListener(new ColorListener());

        label = new JLabel("I'm a label") ;


        frame.getContentPane().add(BorderLayout.SOUTH, labelButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, colorButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    class LabelListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println("into label listener");
        }
    }

    class ColorListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println("into label listener");
            drawPanel.repaint();
        }
    }
}

class MyDrawPanel extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g ;

        int red = (int)(Math.random()*255) ;
        int green = (int)(Math.random()*255) ;
        int blue = (int)(Math.random()*255) ;
        Color startColor = new Color(red,green,blue) ;

        red = (int)(Math.random()*255) ;
        green = (int)(Math.random()*255) ;
        blue = (int)(Math.random()*255) ;
        Color endColor = new Color(red,green,blue) ;

        GradientPaint gradient = new GradientPaint(20,20,startColor,100,100,endColor) ;
        g2d.setPaint(gradient) ;
        g2d.fillOval(20, 20,50, 50);
    }
}