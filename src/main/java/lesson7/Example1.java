package lesson7;

import java.util.ArrayList;
import java.util.Arrays;

public class Example1 {

    public static void main(String[] args) {
        String s = "abc";
        Class<?> sc = s.getClass();
        System.out.println(sc.getName());
        System.out.println(sc.getSimpleName());
        System.out.println(Arrays.toString(sc.getSigners()));
        System.out.println(sc);
        System.out.println(Runnable.class);
        System.out.println(void.class);
        System.out.println(int.class);
        System.out.println(Void.class);
    }

}
