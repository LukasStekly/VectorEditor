package cz.uhk.vedit.gui;

import cz.uhk.vedit.model.*;
import cz.uhk.vedit.model.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.TreeMap;

public class VeditFrame extends JFrame {
    private DrawPanel drawPanel = new DrawPanel();

    public VeditFrame(){
        super("FIM Vector Editor"); //setTitle

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(drawPanel, BorderLayout.CENTER);
        
        add(createToolbar(), BorderLayout.NORTH);

        initSampleData();

        pack();
    }

    private JToolBar createToolbar() {
        var tb = new JToolBar(JToolBar.HORIZONTAL);
        //pridame obyc tlacitko
//        var btnSquare = new JButton(("Square"));
//        tb.add(btnSquare);
//        btnSquare.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                drawPanel.addObject(new Square(10,10,Color.ORANGE,50));
//                drawPanel.repaint();
//            }
//        });
        var actSquare = new AbstractAction("Square") {

            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.addObject(new Square(10, 10, Color.ORANGE, 50));

            }
        };

        var actCircle = new AbstractAction("Circle") {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.addObject(new Circle(10, 10, Color.ORANGE, 50));

            }
        };

        var actTriangle = new AbstractAction("Triangle") {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.addObject(new Triangle(10, 10, Color.ORANGE, 50));

            }
        };

        var actRectangle = new AbstractAction("Rectangle") {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.addObject(new Rectangle(10, 10, Color.ORANGE, 50, 100));

            }
        };


        tb.add(actSquare);
        tb.add(actRectangle);
        tb.add(actTriangle);
        tb.add(actCircle);
        return (tb);
    }


    private void initSampleData() {
        drawPanel.addObject(new Square(300,200,Color.CYAN,50));
        drawPanel.addObject(new Square(440,200,Color.CYAN,50));
        drawPanel.addObject(new Rectangle(350,380,Color.GREEN,90,50));
        drawPanel.addObject(new Triangle(370,320,Color.BLACK,50));
        drawPanel.addObject(new Circle(195,100,Color.RED,200));

        Group gr = new Group();
        drawPanel.addObject(gr);
        gr.addGraphObject(new Square(500,300,Color.MAGENTA, 100));
        gr.addGraphObject(new Circle(500,300,Color.MAGENTA, 50));
    }
}
