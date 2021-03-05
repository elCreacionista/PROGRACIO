package ROBOT;

import MAPA.Mapa;

public class Robot {

    public int posX;
    public int posY;

    public Robot(int[] pos){
        this.posX = pos[0];
        this.posY = pos[1];

    }
    public void Teleport(int[] pos){
        this.posX = pos[0];
        this.posY = pos[1];
    }
    public void Teleport(int px, int py){
        this.posX = px;
        this.posY = py;
    }
    public void moveNorth(){
        this.posX --;
    }
    public void moveWest(){
        this.posY --;
    }
    public void moveSouth(){
        this.posX ++;
    }
    public void moveEast(){
        this.posY ++;
    }
}
