package cz.uhk.vedit.gui;

import cz.uhk.vedit.model.Rectangle;
import cz.uhk.vedit.model.Square;
import cz.uhk.vedit.model.Triangle;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

public class VeditFrame extends JFrame {
    private DrawPanel drawPanel = new DrawPanel();

    public VeditFrame(){
        super("FIM Vector Editor"); //setTitle

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(drawPanel, BorderLayout.CENTER);

        initSampleData();

        pack();
    }

    private void initSampleData() {
        drawPanel.addObject(new Square(100,100,Color.RED,50));
        drawPanel.addObject(new Square(200,100,Color.BLUE,80));
        drawPanel.addObject(new Square(300,300,Color.GREEN,30));
        drawPanel.addObject(new Rectangle(100,200,Color.GREEN,10,20));
        drawPanel.addObject(new Triangle(200,400,Color.BLACK,80));
    }
}
