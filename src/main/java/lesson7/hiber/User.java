package lesson7.hiber;

import lombok.Data;

@HiberTable(tableName = "users")
@Data
public class User {

    @HiberField(sqlType = "TEXT", fieldName = "name")
    public String name;

    @HiberField(sqlType = "INTEGER", fieldName = "age")
    public int age;

    @HiberField(sqlType = "INTEGER", fieldName = "id")
    public int id;

    public User(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
}
