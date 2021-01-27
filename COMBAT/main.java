package Combat;

import java.util.Arrays;
import java.util.Objects;

public class main {
    public static Jugador randJugador(){
        char[] c = new char[3];
        StringBuilder nom = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            c[i] = (char)(65 + (Math.random()*25));
            nom.append(c[i]);
        }
        int vida = (int)(60 + (Math.random()*100));
        int atac = (int)(Math.random()*20);
        int defensa = (int)(Math.random()*20);
        return new Jugador(nom.toString(),vida, atac, defensa, Rol.randRol());
        //return new Jugador(nom.toString(), 100,10,10,Rol.randRol());
    }

    public static void main(String[] args) {
        Jugador[] jugadors = new Jugador[200];
        Combat c = new Combat();
        for (int i = 0; i < jugadors.length; i++) {
            jugadors[i] = randJugador();
        }
        for (int i = 0; i < jugadors.length; i++) {
            for (int j = 0; j < jugadors.length; j++) {
                if (i != j){
                    c.Combatre(jugadors[i], jugadors[j]);

                }
            }
        }

        for (int i = 0; i < jugadors.length; i++) {
            jugadors[i].GetAllStatics();
        }
        System.out.println();
        EstrategiesGlobals(jugadors);
    }



    public static void EstrategiesGlobals(Jugador[] jugadors){
        int total = jugadors.length;
        String[] noms = {"AGRESIU", "DEFENSIU" , "ENGANYADOR" , "MANIOBRER" ,
                "MIXTE" , "LLADRE" , "CLASE1" , "CLASE2", "EQUILIBRAT"};
        int[] rols = new int[9];
        int[] victoriesGlobals = new int[9];
        float[] mitjaV = new float[9];
        /**              CALCULAR MITJANES     */
        for (int i = 0; i < total; i++) {
            switch (jugadors[i].rol){
                case AGRESIU: rols[0]++; victoriesGlobals[0] += jugadors[i].victories;break;
                case DEFENSIU:rols[1]++; victoriesGlobals[1] += jugadors[i].victories;break;
                case ENGANYADOR:rols[2]++; victoriesGlobals[2] += jugadors[i].victories;break;
                case MANIOBRER:rols[3]++; victoriesGlobals[3] += jugadors[i].victories;break;
                case MIXTE:rols[4]++; victoriesGlobals[4] += jugadors[i].victories;break;
                case LLADRE:rols[5]++; victoriesGlobals[5] += jugadors[i].victories;break;
                case CLASE1:rols[6]++; victoriesGlobals[6] += jugadors[i].victories;break;
                case CLASE2:rols[7]++; victoriesGlobals[7] += jugadors[i].victories;break;
                case EQUILIBRAT:rols[8]++; victoriesGlobals[8] += jugadors[i].victories;break;

            }
        }


        for (int i = 0; i < 9; i++) {
            mitjaV[i] = (float)victoriesGlobals[i] / rols[i];
            System.out.println(noms[i] + ": JUGADORS " + rols[i] + " VICTORIES " + victoriesGlobals[i] + " MITJA " + mitjaV[i]);
        }
    }

}
