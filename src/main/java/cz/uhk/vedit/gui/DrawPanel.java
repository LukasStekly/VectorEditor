package cz.uhk.vedit.gui;
import cz.uhk.vedit.model.AbstractGraphicObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class DrawPanel extends JPanel {
    private List<AbstractGraphicObject> objects = new ArrayList<>();

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
    }

    public void addObject(AbstractGraphicObject obj){
        objects.add(obj);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (var obj : objects)
        {
            obj.draw((Graphics2D) g);
        }
    }
}
