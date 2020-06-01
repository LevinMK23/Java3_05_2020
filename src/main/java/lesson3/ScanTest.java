package lesson3;

import java.io.*;
import java.util.Scanner;

public class ScanTest {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/lesson3/file.txt");
        Scanner in = new Scanner(file);
        BufferedReader bin = new BufferedReader(new FileReader(file));
//        while (in.hasNext()) {
//            System.out.println(in.next());
//        }
        while (true) {
            String line = bin.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
    }
}
