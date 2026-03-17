package cz.uhk.vedit.model;

import javax.print.DocFlavor;
import java.awt.*;

public class Rectangle extends AbstractGraphicObject{
    protected int a;
    protected int b;

    public Rectangle (Point point, Color color, int a, int b)
    {

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
    }

    @Override
    public boolean contains(Point p) {
        return false;
    }
}
