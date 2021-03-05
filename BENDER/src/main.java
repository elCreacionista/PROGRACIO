import MAPA.Casella;
import MAPA.Terra;
import ROBOT.RandomPathFinder;

import java.util.Scanner;

public class main {
    static Bender bender;
    public static void main(String[] args) {
        String mapa = "" +
                "#########\n" +
                "##X  #  #\n" +
                "##      #\n" +
                "#  #    #\n" +
                "####    #\n" +
                "# $     #\n" +
                "#  #  I #\n" +
                "#########";
        System.out.println(mapa);
        RandomPathFinder rpf = new RandomPathFinder(mapa);

        rpf.doPath(50);


        /*String mapa = "#  # #\n" +
                      "# #  #\n" +
                      "##I  #\n" +
                      "# II$#";*/
        /*bender = new Bender(mapa);
        Scanner sc = new Scanner(System.in);
        */
    }
}
