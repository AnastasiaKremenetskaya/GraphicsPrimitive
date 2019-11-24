package graphics;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class MySquare extends MyRectangle {

    protected double size;

    public MySquare(ArrayList<Point2D.Double> vertices) {
        super(vertices);
        size = countSize();
    }

    /**
     * Получить периметр
     *
     * @return периметр
     */
    public double getSize() {
        return size;
    }

    /**
     * Посчитать периметр
     *
     * @return периметр
     */
    protected double countSize() {
        return super.rectangle.width * 4;
    }
}
