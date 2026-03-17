package cz.uhk.vedit.model;

import java.awt.*;

public class Triangle extends AbstractGraphicObject{
    //point.x-r, point.y-r, 2*r, 2*r

    protected int a;

    public Triangle() {

    }

    public Triangle(Point point, Color color, int a) {
        super(point, color);
        this.a = a;
    }

    public Triangle(int x, int y, Color color, int a) {
        super(x, y, color);
        this.a = a;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.drawLine(point.x, point.y, point.x + a, point.y);
        int y2 =(int) (a* Math.sqrt(3)/2);
        g.drawLine(point.x+a, point.y, point.x + a / 2, point.y-y2);
        g.drawLine(point.x, point.y,  point.x + a / 2, point.y-y2);
    }

    @Override
    public boolean contains(Point p) {
        return false;
    }
}
