package graphics;

import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public abstract class MyAbstractPolygon extends MyAreaPrimitive2D {

    protected Path2D abstractPolygon = new Path2D.Double(); //абстрактный многоугольник
    protected ArrayList<Point2D.Double> vertexPool =  new <Point2D.Double>ArrayList();//вершины


    public MyAbstractPolygon(ArrayList<Point2D.Double> vertices) {

        if (vertices.size() < 3)
            throw new IllegalArgumentException("Error: Polygon must contain at least 3 vertices");

        this.vertexPool.addAll(vertices);


        //Обозначить начало ломаной
        abstractPolygon.moveTo(vertexPool.get(0).x, vertexPool.get(0).y);

        //Создать из вершин ломаную
        vertexPool.stream().skip(1).forEach(vertex -> this.abstractPolygon.lineTo(vertex.x, vertex.y));
       // vertexPool.forEach((vertex) -> this.abstractPolygon.lineTo(vertex.x, vertex.y));

        //Замкнуть ее
        abstractPolygon.closePath();

        //Присвоить родителю полученный примитив
        super.shape = this.abstractPolygon;

        //Получить площадь
        area = countArea();
    }

    /**
     * Переместить примитив на заданное смещение
     *
     * @param x смещение по оси х
     * @param y смещение по оси y
     */
    @Override
    public void move(double x, double y) {
        vertexPool.forEach((v) -> this.abstractPolygon.moveTo(v.x+ x, v.y + y));
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

        if (this.abstractPolygon.contains(c))
            success = true;

        if (success)
            System.out.println("Point intersects polygon");
        else
            System.out.println("Point doesn't intersect polygon");

        return success;
    }

    /**
     * Вычислить площадь фигуры
     *
     * @return площадь фигуры
     */
    @Override
    protected double countArea() {
        double area = 0;

        for (int i = 0; i < this.vertexPool.size()-1; i++){
            area += vertexPool.get(i).x * vertexPool.get(i + 1).y+vertexPool.get(i).y * vertexPool.get(i + 1).x;
        }

        return area/2;
    }
}
