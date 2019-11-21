package graphics;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class MyLineSegment extends MyGraphicsPrimitive2D {

    private Point2D.Double a;
    private Point2D.Double b;

    MyLineSegment(Point2D.Double a, Point2D.Double b) {
        if (a == b)
            throw new IllegalArgumentException("Error: Line segment must have length");

        this.a = a;
        this.b = b;
        //для отрисовки
        super.shape = new Line2D.Double(a.x, a.y, b.x, b.y);
    }

    /**
     * Переместить примитив на заданное смещение
     *
     * @param x смещение по оси х
     * @param y смещение по оси y
     */
    @Override
    public void move(double x, double y) {
        a.setLocation(this.a.x + x, this.a.y + y);
        b.setLocation(this.b.x + x, this.b.y + y);
        super.shape = new Line2D.Double(a.x, a.y, b.x, b.y);
    }

    /**
     * Занимает / покрывает / охватывает ли указанную позицию
     *
     * @param c - позиция
     * @return true, если есть пересечение; false иначе.
     */
    @Override
    public boolean isInside(Point2D.Double c) {
        boolean success = false;

        //Если вектора коллинеарны
        if (areColinear(c)) {
            //Скалярное произведение должно быть меньше, либо равно 0
            double scalarProduct = dotProduct(c, a) * dotProduct(c, b);

            success = !(scalarProduct > 0);
        }

        if (success)
            System.out.println("Point intersects line segment");
        else
            System.out.println("Point doesn't intersect line segment");

        return success;
    }

    /**
     * Проверить коллинеарность отрезка с указанной точкой
     *
     * @param point2D - точка
     * @return true, если коллинеарны; false иначе
     */
    private boolean areColinear(Point2D.Double point2D) {
        boolean success = false;

        int result = (int) Math.round(((b.y - a.y) * (point2D.x - b.x) - (point2D.y - b.y) * (b.x - a.x)));

        if (result == 0)
            success = true;

        return success;
    }

    private static double dotProduct(final Point2D a, final Point2D b) {
        return a.getX() * b.getX() + a.getY() * b.getY();
    }
}