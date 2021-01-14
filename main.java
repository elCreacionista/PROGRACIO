package Combat;

public class main {

    public static void main(String[] args) {
        Jugador j1 = new Jugador("Pep", 100, 10, 10, Rol.DEFENSIU);
        Jugador j2 = new Jugador("Maik", 100, 10, 10, Rol.AGRESIU);

        System.out.println(j1.getRol() + "             " + j2.getRol());
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println(j1.getEstrategia() + "             " + j2.getEstrategia());
            j1.Makemove();
            j2.Makemove();
        }
    }

}
