package HERENCIA;


public class Shape {
    public static void main(String[] args) {
        Shape[] formes = new Shape[3];
        formes[0] = new Cercle(3000, "green", true);
        formes[1] = new Rectangle(100,140, "orange", false);
        formes[2] = new Square(1, "grey", false);
        for (Shape forme : formes) {
            System.out.println(forme.toString());
        }
    }
    String color;
    boolean filled;

    Shape() {
    }

    Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    @Override
    public String toString() {
        return " de color " + color + ", filled " + filled;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public boolean isFilled() {
        return filled;
    }
}
class Cercle extends Shape {
    double radius;

    Cercle() {
    }

    Cercle(double radius) {
        this.radius = radius;
    }

    Cercle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * Math.PI;
    }

    public String toString() {
        return "Circle de color " + color + ", filled " + filled + " el radi és " + radius;
    }
}


class Rectangle extends Shape {
    double width;
    double lenght;

    Rectangle(double width, double lenght) {
        this.width = width;
        this.lenght = lenght;
    }

    Rectangle(double width, double lenght, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.lenght = lenght;
    }

    public double getWidth() {
        return width;
    }

    public double getLenght() {
        return lenght;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }

    public double getArea() {
        return width * lenght;
    }

    public double getPerimeter() {
        return (2 * width) + (2 * lenght);
    }

    public String toString() {
        return "Rectangle de width de " + width + ", lenght " + lenght + ", area " + getArea() + " Perimetre " +
                getPerimeter() + " " + super.toString();

    }
}
class Square extends Rectangle{

    Square(double side) {
        super(side, side);
    }

    Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }
    public double getSide() {
        return lenght;
    }

    public void setSide(double side) {
        this.width = side;
        this.lenght = side;
    }

    @Override
    public String toString() {
        return "Cuadrat de width de " + width + ", lenght " + lenght + ", area " + getArea() + " Perimetre " +
                getPerimeter() + " " + super.toString();
    }
}