package cz.uhk.vedit.model;

import java.awt.*;

/**
 * Predek vsech grafickych utvaru v editoru
 */

public abstract class AbstractGraphicObject {

    /**
     * Referencni bod od ktereho se bude tvar vykreslovat
     */
    protected Point point;



    /**
     * Barva utvaru
     */
    protected Color color;


    public AbstractGraphicObject() {

    }

    public AbstractGraphicObject(Point point, Color color) {
        this.point = point;
        this.color = color;
    }


    public AbstractGraphicObject(int x, int y, Color color) {
        setPoint(x,y);
        this.color = color;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setPoint(int x, int y){
        point = new Point(x,y);
    }


    public abstract void draw(Graphics2D g);

    public abstract boolean contains(Point p);

    public boolean contains(int x, int y){
        return contains(new Point(x,y));
    }

    public void moveBy(int dx, int dy){
        point.translate(dx,dy);
    }

}
