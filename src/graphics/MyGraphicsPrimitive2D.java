package graphics;

import java.awt.*;
import java.awt.geom.Point2D;

abstract class MyGraphicsPrimitive2D{

    Shape shape;//Графический примитив

    /**
     * Переместить примитив на заданное смещение
     *
     * @param x смещение по оси х
     * @param y смещение по оси y
     */
    abstract void move(double x, double y);

    /**
     * Занимает / покрывает / охватывает ли указанную позицию
     *
     * @param c - позиция
     * @return true, если есть пересечение; false иначе.
     */
     abstract boolean isInside(Point2D.Double c);

    /**
     * Отрисовывает графический примитив
     */
    public void draw(Graphics2D g2) {
        assert shape != null;
        g2.draw(shape);
    }

    /**
     * Описывает примитив прямоугольной областью
     */
    public Rectangle circleShape()  {
        return shape.getBounds();
    }
}
