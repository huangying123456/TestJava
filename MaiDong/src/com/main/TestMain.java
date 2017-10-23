package com.main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ListenYoung on 15/10/15.
 */
public class TestMain {
    private JFrame frame;
    private JPanel panel;

    private JButton startButtion;
    private JLabel conLabel;
    private JLabel rowLabel;
    private JLabel lineLabel;

    private JTextField rowField;
    private JTextField lineField;

    private Font font;

    public TestMain() {
        this.frame = new JFrame("抽奖环节");
        this.panel = new JPanel();
        this.conLabel = new JLabel("恭喜第");
        this.rowLabel = new JLabel("排 ， 第");
        this.lineLabel = new JLabel("列的同学！");
        this.rowField = new JTextField(5);
        this.lineField = new JTextField(5);
        this.startButtion = new JButton("开始抽奖");
        this.font = new Font(null , Font.CENTER_BASELINE , 18);

        this.panel.setLayout(null);

        this.conLabel.setBounds(100, 180, 100, 80);
        this.rowField.setBounds(220, 180, 100, 80);
        this.rowLabel.setBounds(340, 180, 100, 80);
        this.lineField.setBounds(460, 180, 100, 80);
        this.lineLabel.setBounds(580, 180, 100, 80);
        this.startButtion.setBounds(350 , 300 , 140 , 90);


        this.conLabel.setFont(this.font);
        this.rowField.setFont(this.font);
        this.rowLabel.setFont(this.font);
        this.lineField.setFont(this.font);
        this.lineLabel.setFont(this.font);
        this.startButtion.setFont(this.font);

        this.panel.add(this.conLabel);
        this.panel.add(this.rowField);
        this.panel.add(this.rowLabel);
        this.panel.add(lineField);
        this.panel.add(lineLabel);
        this.panel.add(this.startButtion);

        this.frame.add(this.panel);

        this.rowField.setEditable(false);
        this.lineField.setEditable(false);

        this.frame.setSize(800, 600);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);

    }

    public static void main(String[] args){
        new TestMain();
    }
}
