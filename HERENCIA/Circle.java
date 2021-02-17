package HERENCIA;

public class Circle{
    public static void main(String[] args) {
        Circle circle = new Circle(4);
        Cylinder cilindre = new Cylinder(1,5);

        System.out.println("L'àrea del " + circle.toString() + " es " + circle.getArea());
        System.out.println("L'àrea del " + cilindre.toString() + " es " + cilindre.getArea());

    }
    double radius;
    String Color;
    Circle(){}
    Circle(double radius){
        this.radius = radius;
        this.Color = "red";
    }
    public double getRadius(){
        return radius;
    }
    public double getArea(){
        return radius * Math.PI;
    }
    public String toString(){
        return "Circle";
    }
}

class Cylinder extends Circle{
    double height;
    Cylinder(){}
    Cylinder(double radius){
        super(radius);
    }
    Cylinder(double radius, double height){
        super(radius);
        this.height = height;
    }
    public double getHeight(){
        return this.height;
    }
    public double getVolume(){
        return super.getArea() * getHeight();
    }
    @Override
    public double getArea(){
        return (2 * Math.PI * radius * height) + (2*super.getArea());
    }

    public String toString(){
        return "Cilindre";
    }
}