package graphics;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class MyRectangle extends MyAbstractPolygon{

    protected Rectangle rectangle;

    public MyRectangle(ArrayList<Point2D.Double> vertices) {
        super(vertices);

        rectangle  = super.shape.getBounds();
    }

    /**
     * Получить ширину прямоугольника
     *
     * @return ширина
     */
    public double getRectangleWidth(){
        return rectangle.getWidth();
    }

    /**
     * Получить высоту прямоугольника
     *
     * @return высота
     */
    public double getRectangleHeight(){
        return rectangle.getHeight();
    }

    /**
     * Получить левую верхнюю вершину
     *
     * @return координата вершины
     */
    public Point2D.Double getLeftTopVertex() {
        return new Point2D.Double(rectangle.getMinX(), rectangle.getMaxY());
    }

    /**
     * Получить правую нижнюю вершину
     *
     * @return координата вершины
     */
    public Point2D.Double getRightBottomVertex() {
        return new Point2D.Double(rectangle.getMinX(), rectangle.getMaxY());
    }
}
