package com.stLab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.Formatter;

public class App extends JFrame{


    private JPanel panel1;
    private JButton buttonN;
    private JButton buttonR;
    private JCheckBox CheckBox;
    private JLabel textS;


    boolean isFlag() {
        return CheckBox.isSelected();
    }
    JPanel getPanel1() {
        return panel1;
    }

    public App() {
        buttonR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                IDrawer id = new WDrawer();
                IMatrix m = new MatrixS(4,4,id);
                initMatrix.fill(m,10,30);
                m.Draw();
            }
        });
        buttonN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IDrawer id = new CDrawer();
                IMatrix m = new MatrixN(5,5,id);
                initMatrix.fill(m,14,25);
                m.Draw();
                m = new RenumDec(m);
                m.Draw();
            }
        });
    }

    public static App app = new App();

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(app.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


