package ROBOT;

import MAPA.Casella;
import MAPA.Mapa;
import MAPA.Terra;

/**
 *         String mapa = "" +
 *                 "##########\n" +
 *                 "# X      #\n" +
 *                 "######## #\n" +
 *                 "#        #\n" +
 *                 "# ######################\n" +
 *                 "# #   #               $#\n" +
 *                 "#   #   #  #############\n" +
 *                 "############";
 *
 *                 DDDDDDSSAAAAAAASSSDDWDDSDDWDDDDDDDDDDDDDDD
 * */


public class RandomPathFinder {
    Mapa mapa;
    Robot robot;
    String bestPath;

    public RandomPathFinder(String mapa){
        this.mapa = new Mapa(mapa);
        this.robot = new Robot(this.mapa.getBot());
        this.bestPath = "";
    }
    public void doPath(int times){
        for (int i = 0; i < times; i++) {
            FindPath();
            this.robot.Teleport(this.mapa.getBot());
        }
    }

    public void FindPath(){
        StringBuilder sb = new StringBuilder();
        int contador = 0;
        while(!End()){
            contador++;
            if (contador > 5000)
                break;
            String s = randomMovement();
            if (isPossible(s)){
                movebot(s);
                sb.append(s);
            }
        }
        String path = sb.toString();
        if (this.bestPath.equals("") || path.length() <= this.bestPath.length())
            this.bestPath = path;

    }
    public boolean End(){
        return this.mapa.CasellaFi(this.robot.posX, this.robot.posY);
    }
    public boolean isPossible(String s){
        int posx = this.robot.posX;
        int posy = this.robot.posY;
        switch (s){
            case "W" -> posy --;
            case "S" -> posx++;
            case "E" -> posy ++;
            case "N" -> posx--;
        }
        return this.mapa.getCasella(posx, posy) instanceof Terra;
    }
    public String randomMovement(){
        return switch ((int) Math.floor(Math.random() * 5)) {
            case 0 -> "W";
            case 1 -> "S";
            case 2 -> "E";
            case 3 -> "N";
            default -> "S";
        };
    }
    private Casella getCasella(){
        return this.mapa.getCasella(robot.posX, robot.posY);
    }
    public void movebot(String m){
        switch (m){
            case "W" -> this.robot.moveWest(getCasella());
            case "S" -> this.robot.moveSouth(getCasella());
            case "E" -> this.robot.moveEast(getCasella());
            case "N" -> this.robot.moveNorth(getCasella());
        }
    }
}
