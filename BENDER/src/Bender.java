import MAPA.Mapa;
import ROBOT.Robot;

public class Bender {
    Mapa mapa;
    Robot robot;


    public void movebot(String m){
        switch (m){
            case "A" -> this.robot.moveWest();
            case "S" -> this.robot.moveSouth();
            case "D" -> this.robot.moveEast();
            case "W" -> this.robot.moveNorth();
        }
    }
    Bender(String mapa){
        this.mapa = new Mapa(mapa);
        this.robot = new Robot(this.mapa.getBot());
    }
    public String run(){
        return "SSS";
    }

    public Mapa getMapa() {
        return mapa;
    }
   public void drawMap(){
        this.mapa.drawMap(this.robot.posX, this.robot.posY);
   }
}
