package lesson1.homework;


import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox1 = new Box<>();
        orangeBox.compare(appleBox);
        appleBox.dropTo(appleBox1);

    }
}
