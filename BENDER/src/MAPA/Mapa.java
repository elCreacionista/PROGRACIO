package MAPA;

import MAPA.OBJECTES.Buid;
import MAPA.OBJECTES.Fi;
import MAPA.OBJECTES.Inversor;
import MAPA.OBJECTES.Teletransportador;

import java.util.Arrays;

public class Mapa {
    int[] botpos;
    Casella[][] mapa;
    public Mapa(String mapa){
        this.CrearMapa(mapa);
    }

    private void CrearMapa(String mapa){
        this.mapa = new Casella[getColumns(mapa)][];
        int[] rows = getRows(mapa);
        mapa = normalizemapa(mapa);
        int caselles = 0;
        for (int i = 0; i < rows.length; i++) {
            this.mapa[i] = new Casella[rows[i]];
            for (int j = 0; j < rows[i]; j++) {
                switch (mapa.charAt(caselles)) {
                    case '#' -> this.mapa[i][j] = new Paret();
                    case 'X' -> {
                        this.mapa[i][j] = new Terra(new Buid());
                        this.botpos = new int[]{i, j};
                    }
                    case ' ' -> this.mapa[i][j] = new Terra(new Buid());
                    case 'I' -> this.mapa[i][j] = new Terra(new Inversor());
                    case '$' -> this.mapa[i][j] = new Terra(new Fi());
                    case 'T' -> this.mapa[i][j] = new Terra(new Teletransportador());
                }
                caselles++;
            }
        }
    }
    public Casella getCasella(int px, int py){
        return this.mapa[px][py];
    }
    public boolean CasellaFi(int px, int py){
        return this.mapa[px][py].artifact instanceof Fi;
    }
    public int getColumns(String m){
        int columnes = 0;
        for (int i = 0; i < m.length(); i++) {
            if ((int) m.charAt(i) == 10)
                columnes++;
        }
        return columnes + 1;
    }

    public int[] getRows(String m){
        int[] rows = new int[getColumns(m)];
        int actualrow = 0;
        for (int i = 0; i < m.length(); i++) {
            if ((int) m.charAt(i) == 10){
                actualrow++;
            } else
                rows[actualrow] ++;
        }
        return rows;
    }


    public Casella[][] getMapa() {
        return mapa;
    }

    private String normalizemapa(String m){
        return m.replace(System.getProperty("line.separator") , "");
    }
    public void drawMap(int botpx, int botpy){
        for (int i = 0; i < this.mapa.length; i++) {
            for (int j = 0; j < this.mapa[i].length; j++) {
                if (i == botpx && j == botpy)
                    System.out.print("X");
                else
                    System.out.print(this.mapa[i][j].toString());
            }
            System.out.println("");
        }
    }

    public int[] getBot() {
        return botpos;
    }
}
