package graphics;

import java.awt.*;
import java.awt.geom.Point2D;

public class MyCircle extends MyAreaPrimitive2D{

    private Point2D.Double center;
    private double radius;

    MyCircle(Point2D.Double center, double radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("Error: Radius must be positive");

        this.center = center;
        this.radius = radius;
    }

    @Override
    void draw(Graphics2D g2) {
        g2.fillOval((int)Math.round(center.x), (int)Math.round(center.y), (int)Math.round(radius), (int)Math.round(radius));
    }
    /**
     * Вычислить площадь фигуры
     *
     * @return площадь фигуры
     */
    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    /**
     * Переместить примитив на заданное смещение
     *
     * @param x смещение по оси х
     * @param y смещение по оси y
     */
    @Override
    void move(double x, double y) {
        center.setLocation(this.center.x + x, this.center.y + y);
    }

    /**
     * Занимает / покрывает / охватывает ли указанную позицию
     *
     * @param c - позиция
     * @return true, если есть пересечение; false иначе.
     */
    @Override
    boolean isInside(Point2D.Double c) {
        boolean success = false;

        if (Math.sqrt((this.center.x - c.x) * (this.center.x - c.x) + (this.center.y - c.y) * (this.center.y  - c.y)) < radius) {
            success = true;
            System.out.println("Point intersects circle");
        }
        else
            System.out.println("Point doesn't intersect circlet");

        return success;
    }
}
