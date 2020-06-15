package lesson7;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class FieldsAndMethods {

    @NeedInvoke(value = "GOOD!")
    public void foo1() {
        System.out.println("foo1");
    }

    @NeedInvoke(value = "GOOD!")
    public void foo2() {
        System.out.println("foo2");
    }

    static void printFieldsInfo(Class<?> cl) {
        Field [] fields = cl.getFields();
        for (Field field : fields) {
            System.out.println(field.toString());
        }
        System.out.println("______________________");
        fields = cl.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.toString());
        }
    }

    static void hackString(String s)
            throws NoSuchFieldException, IllegalAccessException {
        Class cl = s.getClass();
        Field field = cl.getDeclaredField("value");
        field.setAccessible(true);
        char [] data = (char[]) field.get(s);
        data[0] = '1';
    }

    String a;

    static void printMethodsInfo(Class<?> cl) {
        Method [] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    static Object invokeMethod(String s) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = s.getClass().getDeclaredMethod("indexOf", String.class);
        method.setAccessible(true);
        return method.invoke(s, "abc");
    }

    static void printConstructorsInfo(Class cl) {
        for (Constructor c : cl.getConstructors()) {
            System.out.println(c);
        }
    }

    public static void main(String[] args)
            throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
//        printMethodsInfo(String.class);
//        printFieldsInfo(String.class);
//        String s = "222";
//        hackString(s);
//        System.out.println(s);
//        System.out.println(invokeMethod("123abcde333"));
//        printConstructorsInfo(String.class);
//        Constructor constructor = String.class.getConstructor(byte[].class, Charset.class);
//        constructor.setAccessible(true);
//        String instance = (String) constructor.newInstance("Привет Мир!".getBytes(), StandardCharsets.UTF_8);
//        System.out.println(instance);
//        System.out.println(Arrays.toString("Hello".getBytes(StandardCharsets.UTF_8)));
        invokeIfNeed();
    }

    private static void invokeIfNeed() throws InvocationTargetException, IllegalAccessException {
        Class cl = FieldsAndMethods.class;
        Method [] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(NeedInvoke.class)) {
                method.invoke(new FieldsAndMethods());
                System.out.println(method.getDeclaredAnnotation(NeedInvoke.class).value());
            }
        }
    }
}
