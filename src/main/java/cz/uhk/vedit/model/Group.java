package cz.uhk.vedit.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Group extends AbstractGraphicObject{
    protected List<AbstractGraphicObject> items = new ArrayList<>();

    public void addGraphObject(AbstractGraphicObject o){ //delegatni metoda
        items.add(o); // delegace
    }

    public void deleteGraphObject(AbstractGraphicObject o){
        items.remove(o);
    }

    @Override
    public void draw(Graphics2D g) {
        items.forEach(it -> it.draw(g));
    }

    @Override
    public boolean contains(Point p) {
        for(var it : items){
            if(it.contains(p)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void moveBy(int dx, int dy) {
        items.forEach(it -> it.moveBy(dx,dy));
    }

    public List<AbstractGraphicObject> getItems() {
        return items;
    }
}
