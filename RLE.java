package Code;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RLE {

    public static void compress(InputStream is, OutputStream os) throws Exception {

        byte[]  arr = is.readAllBytes();
        byte    anterior = arr[0];
        int     repetitions = 0;

        for (int i = 1; i < arr.length; i++) {

            if (anterior == arr[i]) {

                repetitions++;
            } else if (repetitions > 0) {

                writeCompressInOS(os,anterior,repetitions - 1);
                repetitions = 0;
            } else {

                os.write(anterior);
            }
            if(repetitions > 256) {

                writeCompressInOS(os, anterior, 255);
                repetitions = 0;
            }
            anterior = arr[i];

        }

        if (repetitions > 0) {
            writeCompressInOS(os,anterior,repetitions - 1);
        }
        else{
            os.write(anterior);
            System.out.print(anterior);
        }
        System.out.println();
    }
    public static void writeCompressInOS(OutputStream os, byte bt, int times) throws IOException {
        os.write(bt);
        os.write(bt);
        os.write(times);
        System.out.print(bt + "" + bt + times);
    }
    public static void writeDecompressInOS(OutputStream os, byte bt, int times) throws IOException {
        for (int i = 0; i < times; i++) {
            os.write(bt);
            System.out.print(bt);
        }
    }

    public static void decompress(InputStream is, OutputStream os) throws Exception {
        byte[]  arr = is.readAllBytes();
        byte    anterior = arr[0];

        boolean repeat = false;


        for (int i = 1; i < arr.length; i++) {

            if (repeat){
                anterior = arr[i];
                repeat = false;
                continue;
            }

            if (anterior != arr[i]){
                writeDecompressInOS(os, anterior,1);
                repeat = false;
                anterior = arr[i];
                continue;
            }
            writeDecompressInOS(os, anterior, (arr[++i] & 0xFF) + 2);
            repeat = true;
        }
        if (!repeat){
            writeDecompressInOS(os, anterior,1);
        }
        System.out.println();
    }
}
