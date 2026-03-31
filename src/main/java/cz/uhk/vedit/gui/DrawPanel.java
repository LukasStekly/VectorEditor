package cz.uhk.vedit.gui;
import cz.uhk.vedit.model.AbstractGraphicObject;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class DrawPanel extends JPanel {
    private List<AbstractGraphicObject> objects = new ArrayList<>();
    private AbstractGraphicObject selected;
    private Point oldMouse; // minula pozice mysi pri tazeni

    public DrawPanel(){
        initGui();
    }

    public DrawPanel(List<AbstractGraphicObject> objects) {
        this.objects = objects;
        initGui();
    }

    private void initGui(){
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(800,600));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                 selected = findObjectUnderMouse(e.getPoint());
                 if (selected != null){
                 oldMouse = e.getPoint();
                }
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selected != null) {
                    int dx = e.getX() - oldMouse.x;
                    int dy = e.getY() - oldMouse.y;
                    selected.moveBy(dx,dy);
                    oldMouse = e.getPoint();
                    repaint(); // musime prekleslit pro presun
                }
            }
        });
    }

    private AbstractGraphicObject findObjectUnderMouse(Point point) {
        /*
         * for (var o : objects) {
         *             if(o.contains(point)){
         *                 return o;
         *             }
         *         }
         *         tohle je stejne jako to dole
         */
        return objects.stream().filter(o -> o.contains(point)).findFirst().orElse(null);
    }

    public void addObject(AbstractGraphicObject obj){
        objects.add(obj);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ((Graphics2D)g).setStroke(new BasicStroke(2f));
        for (var obj : objects)
        {
            obj.draw((Graphics2D) g);
        }
    }
}
