import MAPA.Casella;
import MAPA.Terra;

public class main {
    static Bender bender;
    public static void main(String[] args) {
        String mapa = "" +
                "#########\n" +
                "# X     #\n" +
                "#       #\n" +
                "#       #\n" +
                "#       #\n" +
                "# $     #\n" +
                "#     I #\n" +
                "#########";
        /*String mapa = "#  # #\n" +
                      "# #  #\n" +
                      "##I  #\n" +
                      "# II$#";*/
        bender = new Bender(mapa);
        bender.mapa.drawMap();
    }
}
