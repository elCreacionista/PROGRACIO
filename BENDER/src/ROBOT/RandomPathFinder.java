package ROBOT;

import MAPA.Mapa;
import MAPA.Terra;

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

            System.out.println(this.bestPath);
        }
    }

    public void FindPath(){
        StringBuilder sb = new StringBuilder();
        int contador = 0;
        while(!End()){
            contador++;
            if (contador > 1000)
                break;
            String s = randomMovement();
            if (isPossible(s)){
                movebot(s);
                sb.append(s);
            }
        }
        String path = sb.toString();
        System.out.println(path);
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
            case "A" -> posy --;
            case "S" -> posx++;
            case "D" -> posy ++;
            case "W" -> posx--;
        }
        return this.mapa.getCasella(posx, posy) instanceof Terra;
    }
    public String randomMovement(){
        return switch ((int) Math.floor(Math.random() * 5)) {
            case 0 -> "A";
            case 1 -> "S";
            case 2 -> "W";
            case 3 -> "D";
            default -> "S";
        };
    }
    public void movebot(String m){
        switch (m){
            case "A" -> this.robot.moveWest();
            case "S" -> this.robot.moveSouth();
            case "D" -> this.robot.moveEast();
            case "W" -> this.robot.moveNorth();
        }
    }
}
