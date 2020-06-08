package lesson4;

import java.io.*;
import java.util.ArrayList;

public class ChatHistory {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\mlev1219\\IdeaProjects\\Java3_05_2020\\src\\main\\java\\lesson4\\history.txt");
//        try(PrintWriter out = new PrintWriter(file)) {
//            StringBuilder s = new StringBuilder();
//            s.append("mike: 1");
//            while (s.length() < 80) s.append(' ');
//            out.println(s.toString());
//            s = new StringBuilder();
//            s.append("mike: 2");
//            while (s.length() < 80) s.append(' ');
//            out.println(s.toString());
//            s = new StringBuilder();
//            s.append("mike: 3");
//            while (s.length() < 80) s.append(' ');
//            out.println(s.toString());
//            s = new StringBuilder();
//            s.append("mike: 4");
//            while (s.length() < 80) s.append(' ');
//            out.println(s.toString());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        System.out.println(rf.length());
        long len = rf.length();
        long strs = len / 80;
        long dif = (strs - 3) * 80;
        rf.skipBytes((int) dif);
        String line;
        while ((line = rf.readLine()) != null) {
            System.out.println(line);
        }
        //System.out.println(list);
    }
}
