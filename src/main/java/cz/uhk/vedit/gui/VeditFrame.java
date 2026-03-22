package cz.uhk.vedit.gui;

import cz.uhk.vedit.model.Circle;
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
        drawPanel.addObject(new Square(300,200,Color.CYAN,50));
        drawPanel.addObject(new Square(440,200,Color.CYAN,50));
        drawPanel.addObject(new Rectangle(350,380,Color.GREEN,90,50));
        drawPanel.addObject(new Triangle(370,320,Color.BLACK,50));
        drawPanel.addObject(new Circle(195,100,Color.RED,200));
    }
}
