package cz.uhk.vedit.gui;

import cz.uhk.vedit.model.*;
import cz.uhk.vedit.model.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.TreeMap;

public class VeditFrame extends JFrame {
    private DrawPanel drawPanel = new DrawPanel();
    Group gr = new Group();

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

        int minX = 20;
        int minY = 20;
        int maxX = 780;
        int maxY = 580;
        int minA = 20;
        int maxA = 200;
        int minB = 20;
        int maxB = 200;
        Random rand = new Random();




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
                drawPanel.addObject(new Triangle(10, 60, Color.ORANGE, 50));

            }
        };

        var actRectangle = new AbstractAction("Rectangle") {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.addObject(new Rectangle(10, 10, Color.ORANGE, 50, 100));

            }
        };


        var RandActSquare = new AbstractAction("RSquare") {

            @Override
            public void actionPerformed(ActionEvent e) {
                int RanX = rand.nextInt(((maxX-minX)+1)) + minX;
                int RanY = rand.nextInt(((maxY-minY)+1)) + minY;
                int RanA = rand.nextInt(((maxA-minA)+1)) + minA;
                if (RanX + RanA >= 800){
                    RanX = RanX /2;
                    RanA = RanA /2;
                }

                if (RanY + RanA >= 600){
                    RanY = RanY /2;
                    RanA = RanA /2;
                }

                int r = rand.nextInt(256);
                int g = rand.nextInt(256);
                int b = rand.nextInt(256);

                Color randomColor = new Color(r, g, b);


                drawPanel.addObject(new Square(RanX, RanY, randomColor, RanA));

            }
        };

        var RandActRectangle = new AbstractAction("RRectangle") {
            @Override
            public void actionPerformed(ActionEvent e) {
                int RanX = rand.nextInt(((maxX-minX)+1)) + minX;
                int RanY = rand.nextInt(((maxY-minY)+1)) + minY;
                int RanA = rand.nextInt(((maxA-minA)+1)) + minA;
                int RanB = rand.nextInt(((maxB-minB)+1)) + minB;

                if (RanX + RanA >= 800){
                    RanX = RanX /2;
                    RanA = RanA /2;
                }

                if (RanY + RanB >= 600){
                    RanY = RanY /2;
                    RanB = RanB /2;
                }


                int r = rand.nextInt(256);
                int g = rand.nextInt(256);
                int b = rand.nextInt(256);

                Color randomColor = new Color(r, g, b);
                drawPanel.addObject(new Rectangle(RanX, RanY, randomColor, RanA, RanB));

            }
        };

        var RandActTriangle = new AbstractAction("RTriangle") {
            @Override
            public void actionPerformed(ActionEvent e) {
                int RanX = rand.nextInt(((maxX-minX)+1)) + minX;
                int RanY = rand.nextInt(((maxY-minY)+1)) + minY;
                int RanA = rand.nextInt(((maxA-minA)+1)) + minA;

                if (RanX + RanA >= 800){
                    RanX = RanX /2;
                    RanA = RanA /2;
                }

                if (RanY + RanA >= 600 ){
                    RanY = RanY /2;
                    RanA = RanA /2;
                }

                if (RanA > RanY)
                {
                    RanY = RanY *2;
                    RanA = RanA /2;
                }

                int r = rand.nextInt(256);
                int g = rand.nextInt(256);
                int b = rand.nextInt(256);

                Color randomColor = new Color(r, g, b);


                drawPanel.addObject(new Triangle(RanX, RanY, randomColor, RanA));

            }
        };

        var RandActCircle = new AbstractAction("RCircle") {
            @Override
            public void actionPerformed(ActionEvent e) {
                int RanX = rand.nextInt(((maxX-minX)+1)) + minX;
                int RanY = rand.nextInt(((maxY-minY)+1)) + minY;
                int RanA = rand.nextInt(((maxA-minA)+1)) + minA;

                if (RanX + RanA >= 800){
                    RanX = RanX /2;
                    RanA = RanA /2;
                }

                if (RanY + RanA >= 600){
                    RanY = RanY /2;
                    RanA = RanA /2;
                }


                int r = rand.nextInt(256);
                int g = rand.nextInt(256);
                int b = rand.nextInt(256);

                Color randomColor = new Color(r, g, b);

                RanA = RanA/2;
                drawPanel.addObject(new Circle(RanX, RanY, randomColor, RanA));

            }
        };




        var DeleteGroup = new AbstractAction("DeleteGroup") {
            @Override
            public void actionPerformed(ActionEvent e) {
            var itemsInGroup = gr.getItems();

            itemsInGroup.clear();
            drawPanel.removeObject(gr);

            }
        };




        tb.add(actSquare);
        tb.add(actRectangle);
        tb.add(actTriangle);
        tb.add(actCircle);
        tb.addSeparator();
        tb.add(RandActSquare);
        tb.add(RandActRectangle);
        tb.add(RandActCircle);
        tb.add(RandActTriangle);
        tb.addSeparator();
        tb.add(DeleteGroup);
        return (tb);
    }


    private void initSampleData() {
        drawPanel.addObject(new Square(75,480,Color.CYAN,15));
        drawPanel.addObject(new Square(110,480,Color.CYAN,15));
        drawPanel.addObject(new Rectangle(85,520,Color.GREEN,30,10));
        drawPanel.addObject(new Triangle(93,510,Color.BLACK,15));
        drawPanel.addObject(new Circle(50,450,Color.RED,50));

        drawPanel.addObject(gr);
        gr.addGraphObject(new Square(680,450,Color.MAGENTA, 100));
        gr.addGraphObject(new Circle(680,450,Color.MAGENTA, 50));
    }
}
