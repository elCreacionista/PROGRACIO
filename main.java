package Code;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertArrayEquals;

public class main {
    /*
        t(new byte[]{1,1,4}, new byte[]{1,1,1,1,1,1});
        t(new byte[]{1,1,0}, new byte[]{1,1});
        t(new byte[]{1,2,3}, new byte[]{1,2,3});
        t(new byte[]{1, 1, 0, 2, 2, 0, 3, 3, 0}, new byte[]{1, 1, 2, 2, 3, 3});
        t(new byte[]{1, 2, 3, 3, 1, 4}, new byte[]{1, 2, 3, 3, 3, 4});
        t(new byte[]{1,2,3,3,0}, new byte[]{1, 2, 3, 3});*/
    public static void main(String[] args) throws Exception {

        byte[] ar = new byte[560];
        for (int i = 0; i < ar.length; i++) {
            if (i <= 260)
                ar[i] = 100;
            else ar[i] = (byte) 101;
        }

        t(new byte[]{100,100,(byte) 255, 100, 100, 1}, ar);


    }
    private static void t(byte[] expected, byte[] input) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        RLE.decompress(new ByteArrayInputStream(input), bos);
    }

}