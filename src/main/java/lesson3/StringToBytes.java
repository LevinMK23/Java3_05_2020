package lesson3;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringToBytes {
    public static void main(String[] args) {
        byte [] string = "Привет".getBytes(StandardCharsets.UTF_8);
        System.out.println(new String(string));
        System.out.println(Arrays.toString(string));
    }
}
