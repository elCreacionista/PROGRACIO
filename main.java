package Combat;

public class main {

    public static void main(String[] args) {
        Jugador j1 = new Jugador("Defensa man", 100, 10, 10, Rol.DEFENSIU);
        Jugador j2 = new Jugador("Atack man", 100, 10, 10, Rol.AGRESIU);


        Combat c = new Combat();
        Jugador guanyador = c.Combatre(j1, j2);
        System.out.println("WINNER");
        guanyador.GetStatics();

        /*for (int i = 0; i < 10; i++) {
            System.out.println(j1.getEstrategia() + "             " + j2.getEstrategia());
            c.CompararEstrategies(j1,j2);
            j1.Makemove();
            j2.Makemove();
        }*/
    }

}
