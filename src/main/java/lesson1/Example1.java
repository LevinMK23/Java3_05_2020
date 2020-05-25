package lesson1;

import java.util.ArrayList;

public class Example1 {

    static <T> T func(T param) {
        return param;
    }

    public static void main(String[] args) {
        Object o1 = "123";
        Object o2 = 15;
        System.out.println(o1.getClass());
        System.out.println(((CharSequence)o1).length());
        //System.out.println(((String)o2).length());
        ArrayList<String> list;
        System.out.println(func("136216").length());
    }
}
