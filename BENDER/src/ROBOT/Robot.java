package ROBOT;

import MAPA.Casella;
import MAPA.Mapa;
import MAPA.OBJECTES.Inversor;
import MAPA.OBJECTES.Teletransportador;

public class Robot {

    public int posX;
    public int posY;
    public boolean invertit = false;

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
    private void invertir(){
        this.invertit = !this.invertit;
    }
    public void moveNorth(Casella c){
        this.posX --;
        if (c.artifact instanceof Inversor)
            this.invertir();
    }
    public void moveWest(Casella c){
        this.posY --;
        if (c.artifact instanceof Inversor)
            this.invertir();
    }
    public void moveSouth(Casella c){
        this.posX ++;
        if (c.artifact instanceof Inversor)
            this.invertir();
    }
    public void moveEast(Casella c){
        this.posY ++;
        if (c.artifact instanceof Inversor)
            this.invertir();
    }
}
