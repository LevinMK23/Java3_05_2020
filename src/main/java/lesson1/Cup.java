package lesson1;

public class Cup<T extends Liquid> {

    T liquid;

    public Cup(T liquid) {
        this.liquid = liquid;
    }

    int drink() {
        return liquid.energy();
    }
}
