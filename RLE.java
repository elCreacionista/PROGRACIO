package Code;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class RLE {

    public static void compress(InputStream is, OutputStream os) throws Exception {

        byte[]  arr = is.readAllBytes();
        byte    anterior = arr[0];
        int     repetitions = 0;

        for (int i = 1; i < arr.length; i++) {

            if (anterior == arr[i]) {

                repetitions++;
            } else if (repetitions > 0) {

                writeInOS(os,anterior,repetitions - 1);
                repetitions = 0;
            } else {

                os.write(anterior);
            }
            if(repetitions > 256) {

                writeInOS(os, anterior, 255);
                repetitions = 0;
            }
            anterior = arr[i];

        }

        if (repetitions > 0) {
            writeInOS(os,anterior,repetitions - 1);
        }
        else{
            os.write(anterior);
            System.out.print(anterior);
        }
        System.out.println();
    }
    public static void writeInOS(OutputStream os, byte bt, int times) throws IOException {
        os.write(bt);
        os.write(bt);
        os.write(times);
        System.out.print(bt + "" + bt + times);
    }

    public static void decompress(InputStream is, OutputStream os) throws Exception {

    }
}
