package lesson1.homework;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> fruits;
    private float weight;

    public Box() {
        fruits = new ArrayList<>();
        weight = 0;
    }

    public void clearBox() {
        weight = 0;
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
        weight += fruit.getWeight();
    }

    public float getWeight() {
        return weight;
    }

    public boolean compare(Box<? extends Fruit> otherBox) {
        return getWeight() == otherBox.getWeight();
    }

    public void dropTo(Box<T> otherBox) {
        clearBox();
        for(T fruit : fruits) {
            otherBox.addFruit(fruit);
        }
        fruits.clear();
    }
}
