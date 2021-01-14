package Combat;


public class Combat {

    String[][][] taula;
    Combat(){
        taula = new String[4][4][2];
        /**     estrategia jug,estrategia adv, estat jug i adv */

        taula[0][0] = new String[]{"dany", "dany"};
        taula[0][1] = new String[]{"igual", "guarit"};
        taula[0][2] = new String[]{"igual", "dany"};
        taula[0][3] = new String[]{"igual", "dany"};

        taula[1][0] = new String[]{"guarit", "igual"};
        taula[1][1] = new String[]{"guarit", "guarit"};
        taula[1][2] = new String[]{"danyx2", "igual"};
        taula[1][3] = new String[]{"penal", "igual"};

        taula[2][0] = new String[]{"dany", "igual"};
        taula[2][1] = new String[]{"igual", "danyx2"};
        taula[2][2] = new String[]{"dany", "dany"};
        taula[2][3] = new String[]{"penal", "igual"};

        taula[3][0] = new String[]{"dany", "igual"};
        taula[3][1] = new String[]{"igual", "penal"};
        taula[3][2] = new String[]{"igual", "penal"};
        taula[3][3] = new String[]{"penal", "penal"};


    }

    public Jugador Combatre(Jugador j1, Jugador j2){

        while (j1.Vida > 0 && j2.Vida > 0){
            j1.Makemove();
            j2.Makemove();
            CompararEstrategies(j1, j2);
            j1.GetStatics();
            j2.GetStatics();

        }
        if (j1.Vida < 0)
            return j2;
        else
            return j1;
    }
    public void CompararEstrategies(Jugador j1, Jugador j2){
       int nombrej1 = j1.getNombreEstrategia();
       int nombrej2 = j2.getNombreEstrategia();

       int valorj1 = j1.LlencarMonedes();
       int valorj2 = j2.LlencarMonedes();

        switch (taula[nombrej1][nombrej2][0]){
            case "dany": j1.Dany(valorj2); break;
            case "danyx2": j1.Dany(valorj2 * 2); break;
            case "guarit": j1.Guarit(valorj1); break;
            case "penal": j1.Penal(valorj2); break;
            case "igual": break;
        }
        switch (taula[nombrej1][nombrej2][1]){
            case "dany": j2.Dany(valorj1); break;
            case "danyx2": j2.Dany(valorj1 * 2); break;
            case "guarit": j2.Guarit(valorj2); break;
            case "penal": j2.Penal(valorj1); break;
            case "igual": break;
        }
    }
}
