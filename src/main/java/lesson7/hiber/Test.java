package lesson7.hiber;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, NoSuchMethodException {
        HiberCore core = new HiberCore();
        core.processComponents(Animal.class);
        core.insertObject(new Animal("Cat", 5));
        Animal animal = (Animal) core.getObject(Animal.class, 1);
    }
}
