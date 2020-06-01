package lesson3;

import java.io.File;
import java.io.IOException;

public class FileTest {

    public static void main(String[] args) throws IOException {
        File file = new File("./file.txt");
        boolean created = file.createNewFile();
        System.out.println(created);
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        String path = "src/main/java/lesson3/dir1";
        File file1 = new File(path);
        boolean dirCreated = file1.mkdir();
        for (int i = 0; i < 5; i++) {
            path = path + "/dir" + (i+1);
            file1 = new File(path);
            file1.mkdir();
        }
        File leaf = new File("src/main/java/lesson3/dir1/dir1/dir2/dir3/dir4/dir5");
        while (leaf.getParent() != null) {
            leaf = new File(leaf.getParent());
            System.out.println(leaf.getAbsolutePath());
        }
        treeWalk(new File("C:\\"), "", 0);
        //Runtime runtime = Runtime.getRuntime();

    }

    static void treeWalk(File file, String prefix, int depth) {
        if (depth > 2) return;
        if (file.isDirectory()) {
            File [] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File cur : files) {
                    treeWalk(cur, prefix + "-", depth + 1);
                }
            }
        } else {
            System.out.println(file.getAbsolutePath());
        }
    }
}
