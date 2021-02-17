package HERENCIA;

public class Empleat {
    double sou;
    Empleat(double sou){
        setSou(sou);
    }

    public void setSou(double sou) {
        this.sou = sou;
    }

    public double getSou() {
        return sou;
    }
}
class Encarregat extends Empleat{
    Encarregat(double sou) {
        super(sou * 1.1);
    }

    @Override
    public double getSou() {
        return super.getSou();
    }

    @Override
    public void setSou(double sou) {
        super.setSou(sou);
    }
}
