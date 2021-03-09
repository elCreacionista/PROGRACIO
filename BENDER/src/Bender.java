import MAPA.Mapa;
import ROBOT.Caminar;
import ROBOT.Robot;

public class Bender {
    Caminar c;


    Bender(String mapa){
        this.c = new Caminar(mapa);
    }
    public String run(){
        return this.c.FindPath();
    }

}
