package cz.uhk.vedit.model;

import java.awt.*;

public class Circle extends AbstractGraphicObject{
    protected int a;

    public Circle() {

    }

    public Circle(Point point, Color color, int a) {
        super(point, color);
        this.a = a;
    }

    public Circle(int x, int y, Color color, int a) {
        super(x, y, color);
        this.a = a;
    }



    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);

        g.drawRect(point.x, point.y, a*2,a*2);
    }

    @Override
    public boolean contains(Point p) {
        return false;
    }
}
