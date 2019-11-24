package graphics;

public abstract class MyAreaPrimitive2D extends MyGraphicsPrimitive2D {

    protected double area; //площадь многоугольника

    abstract double countArea();

    /**
     * Вычислить площадь фигуры
     *
     * @return площадь фигуры
     */
    public double getArea(){
        return area;
    }
}
