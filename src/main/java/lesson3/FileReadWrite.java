package lesson3;

import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) throws IOException {
        File src = new File("src/main/java/lesson3/dir1/dir2/BZ6A3606.jpg");
        System.out.println(src.length());
        System.out.println(src.getName());
        File dst = new File("src/main/java/lesson3/dir1/dir3/BZ6A3606_copy.jpg");
        dst.createNewFile();
        try(InputStream is = new FileInputStream(src);
                OutputStream os = new FileOutputStream(dst)) {
            while (is.available() > 0) {
                // 8192
                byte[] buffer = new byte[10000];
                int readedBytes = is.read(buffer);
                if (readedBytes == 10000) {
                    os.write(buffer);
                } else {
                    for (int i = 0; i < readedBytes; i++) {
                        os.write(buffer[i]);
                    }
                }
            }
        }
        System.out.println(dst.length());
        //copyBuffered();
    }

    static void copyBuffered() throws IOException {
        File src = new File("src/main/java/lesson3/dir1/dir2/BZ6A3606.jpg");
        System.out.println(src.length());
        System.out.println(src.getName());
        File dst = new File("src/main/java/lesson3/dir1/dir3/BZ6A3606_copy.jpg");
        dst.createNewFile();
        BufferedInputStream is = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(dst));
        while (is.available() > 0) {
            // 8192
            os.write(is.read());
        }
        is.close();
        os.close();
        System.out.println(dst.length());
    }
}
