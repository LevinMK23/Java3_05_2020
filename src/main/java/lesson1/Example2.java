package lesson1;

import java.util.List;

public class Example2<T> {

    private T value;

    //& ? extends super

    void setValue(T value) {
        this.value = value;
    }

    T getValue(){
        return value;
    }

    public static void main(String[] args) {
        Example2<String> e1 = new Example2<>();
        e1.setValue("ad");
        System.out.println(e1.getValue());
        // Cup<T>
        Cup<Tea> cup1 = new Cup<>(new Tea());
        Cup<Coffee> cup2 = new Cup<>(new Coffee());
        Cup<Liquid> cup3 = new Cup<>(new Liquid() {
            @Override
            int energy() {
                return 17;
            }
        });
        System.out.println(cup1.drink());
        System.out.println(cup2.drink());
        System.out.println(cup3.drink());
        Two<String, Integer> pair = new Two<>("123", 15);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
        Converter<Integer, Double> co = new Converter<>();
        System.out.println(co.func(12));
        //get extends put super
        Class<? super Integer> cl = Integer.class;
    }
}
