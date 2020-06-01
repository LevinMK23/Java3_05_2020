package lesson3;

import java.io.*;

public class SerializationTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //User user = new User("Ivan", 25);
        //ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("src/main/java/lesson3/file.txt")));
        //os.writeObject(user);
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File("src/main/java/lesson3/file.txt")));
        User ivan = (User) is.readObject();
        System.out.println(ivan);
    }
}
