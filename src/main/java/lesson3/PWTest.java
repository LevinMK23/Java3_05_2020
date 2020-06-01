package lesson3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class PWTest {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/lesson3/file.txt");
        file.createNewFile();
        try(PrintWriter out = new PrintWriter(new FileOutputStream(file, true))) {
            out.println("ABC");
        }
    }
}
