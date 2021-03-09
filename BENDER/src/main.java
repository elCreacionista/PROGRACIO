import MAPA.Casella;
import MAPA.Terra;
import ROBOT.RandomPathFinder;
import ROBOT.SemiPathFinder;

import java.util.Scanner;

public class main {
    static Bender bender;
    public static void main(String[] args) {
        /*String mapa = "" +
                "########################\n" +
                "#X                     #\n" +
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
                "########################";*/
        String mapa =   "########################\n" +
                        "#X                    T#\n" +
                        "#                      #\n" +
                        "#                      #\n" +
                        "#T                    $#\n" +
                        "########################";
        bender = new Bender(mapa);
        System.out.println(bender.run());

    }
}
