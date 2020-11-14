package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeCollector {
    private List<Shape> shapeCollection = new ArrayList<>();

    public void addFigure(Shape shape){
        shapeCollection.add(shape);
    }

    public boolean removeFigure(Shape shape){
        if(shapeCollection.contains(shape)) {
            shapeCollection.remove(shape);
            return true;
        }
        return false;
    }

    public Shape getFigure(int n){
        Shape shape = null;
        if (n >= 0 && n < shapeCollection.size()) {
            shape = shapeCollection.get(n);
        }
        return shape;
    }

    public List<Shape> showFigures(){
        return Collections.unmodifiableList(shapeCollection);
    }

}
