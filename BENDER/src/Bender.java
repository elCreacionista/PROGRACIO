import MAPA.Mapa;
import ROBOT.Robot;

public class Bender {
    Mapa mapa;
    Robot robot;


    Bender(String mapa){
        this.mapa = new Mapa(mapa);
        this.robot = new Robot();
    }
    public String run(){
        return "SSS";
    }

    public Mapa getMapa() {
        return mapa;
    }
}
