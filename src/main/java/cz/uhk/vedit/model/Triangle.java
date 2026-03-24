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
        double vc = a * Math.sqrt(3)/2;
        double dy = point.y -p.y;
        int dx = (int) Math.round(dy / Math.tan(Math.PI/3));
        return point.y >= p.y && p.y >= point.y-vc && point.x + dx <= p.x && p.x <= point.x + a -dx;
    }
}
