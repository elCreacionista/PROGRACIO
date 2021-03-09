package ROBOT;

import MAPA.Casella;
import MAPA.Mapa;
import MAPA.OBJECTES.Teletransportador;
import MAPA.Terra;

import java.util.Arrays;
import java.util.List;

public class Caminar {
    Mapa mapa;
    Robot robot;
    List<int[]> Teletransportadors;
    /**
     * S (South), E (East), N (North), W (West).
     * */
    int ActualDir = 0;

    public String getDireccio(){
        return switch (this.ActualDir % 4) {
            case 1 -> "E";
            case 2 -> "N";
            case 3 -> "W";
            default -> "S";
        };
    }
    private Casella getCasella(){
        return this.mapa.getCasella(robot.posX, robot.posY);
    }

    public void CambiarDireccio(){
        this.ActualDir ++;
        if (ActualDir > 4)
            MirarSud();
    }
    public void MirarSud(){
        if (robot.invertit)
            this.ActualDir = 0;
        else
            this.ActualDir = 2;
    }
    public boolean isPossible(String s){
        int posx = this.robot.posX;
        int posy = this.robot.posY;
        switch (getDireccio()){
            case "W" -> posy --;
            case "S" -> posx++;
            case "E" -> posy ++;
            case "N" -> posx--;
        }
        return this.mapa.getCasella(posx, posy) instanceof Terra;
    }
    public void movebot(String m){
        switch (m){
            case "W" -> this.robot.moveWest(getCasella());
            case "S" -> this.robot.moveSouth(getCasella());
            case "E" -> this.robot.moveEast(getCasella());
            case "N" -> this.robot.moveNorth(getCasella());
        }
    }
    public boolean ComprovarBucle(){
        return true;
    }
    private int[] actualpos(){
        return new int[] {this.robot.posX, this.robot.posY};
    }

    public String FindPath(){
        StringBuilder sb = new StringBuilder();
        int contador = 0;
        while(!End()){
            String s = getDireccio();
            if (Teletransportador())
                this.robot.Teleport(getTeletransportador(actualpos()));

            else{
                if (isPossible(s)) {
                    movebot(s);
                    sb.append(s);
                } else {
                    CambiarDireccio();
                }
            }


            contador++;
            if (contador > 5000 && ComprovarBucle())
                break;
        }
        return sb.toString();


    }
    public boolean End(){
        return this.mapa.CasellaFi(this.robot.posX, this.robot.posY);
    }
    public boolean Teletransportador(){
        return this.mapa.getCasella(this.robot.posX, this.robot.posY).artifact instanceof Teletransportador;
    }

    public Caminar(String mapa){
        this.mapa = new Mapa(mapa);
        this.robot = new Robot(this.mapa.getBot());
        this.Teletransportadors = this.mapa.getTeletransportadors();
    }
    public int[] getTeletransportador(int[] pos){
        if (!this.Teletransportadors.contains(pos))
            return pos;
        if (this.Teletransportadors.size() == 1)
            return pos;
        if (this.Teletransportadors.size() == 2){
            if (this.Teletransportadors.get(0) == pos)
                return Teletransportadors.get(1);
            else
                return this.Teletransportadors.get(0);
        }
        return new int[]{1,2};
    }
}
