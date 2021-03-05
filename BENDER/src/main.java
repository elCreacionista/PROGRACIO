import MAPA.Casella;
import MAPA.Terra;
import ROBOT.RandomPathFinder;
import ROBOT.SemiPathFinder;

import java.util.Scanner;

public class main {
    static Bender bender;
    public static void main(String[] args) {
        String mapa = "" +
                "########################\n" +
                "# X                    #\n" +
                "#                      #\n" +
                "#                      #\n" +
                "#                      #\n" +
                "#                      #\n" +
                "#                      #\n" +
                "#                      #\n" +
                "#                      #\n" +
                "#                      #\n" +
                "#                      #\n" +
                "#                      #\n" +
                "#                     $#\n" +
                "########################";
        System.out.println(mapa);
        SemiPathFinder spf = new SemiPathFinder(mapa);

        spf.doPath(100);
        spf.improvePath();
        spf.improvePath();
        spf.improvePath();
        spf.improvePath();
        spf.improvePath();
        spf.improvePath();



        /*String mapa = "#  # #\n" +
                      "# #  #\n" +
                      "##I  #\n" +
                      "# II$#";*/
        /*bender = new Bender(mapa);
        Scanner sc = new Scanner(System.in);
        */
    }
}
