package lesson7.hiber;

@HiberTable(tableName = "animals")
public class Animal {
    @HiberField(sqlType = "TEXT", fieldName = "type")
    String type;
    @HiberField(sqlType = "INTEGER", fieldName = "age")
    int age;

    public Animal(String type, int age) {
        this.type = type;
        this.age = age;
    }
}
