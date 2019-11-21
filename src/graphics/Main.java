package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Main extends JPanel {
    //Тестовые точки
    Point2D P1 = new Point2D.Double(10.0, 10.0);
    Point2D P2 = new Point2D.Double(80.0, 100.0);
    Point2D P3 = new Point2D.Double(50.0, 100.0);
    //Тестовая линия
    //MyLineSegment line = new MyLineSegment(new Point2D.Double(10.0, 10.0), new Point2D.Double(80.0, 100.0));
    MyCircle circle = new MyCircle(new Point2D.Double(10.0, 10.0), 10.0);
    //ArrayList<Point2D.Double> vertexPool = new <Point2D.Double>ArrayList(); //вершины
    //private MyRectangle rectangle = new MyRectangle(vertexPool);

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        //Задать нормальные координаты
        AffineTransform transform = AffineTransform.getTranslateInstance(0, getHeight());
        transform.scale(1, -1);
        g2.setTransform(transform);

        //Задать цвет и толщину линии
        String hexColor = "0x45e5B";
        g2.setColor(Color.decode(hexColor));
        g2.setStroke(new BasicStroke(5));

        //Отрисовать объект
        //line.move(31.0, 13.0);
        circle.draw(g2);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("MyGraphicsPrimitive2D");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new Main());
        f.setSize(290, 325);
        f.setLocation(550, 25);
        f.setVisible(true);
    }
}
