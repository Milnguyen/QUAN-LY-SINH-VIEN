package Util;

import Model.Student;
import java.io.*;
import java.util.List;

public class FileUtil {

    public static void writeFile(String path, List<Student> list) throws IOException {
        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(list);
        oos.close();
    }

    public static List<Student> readFile(String path)
            throws IOException, ClassNotFoundException {
        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(path));
        List<Student> list = (List<Student>) ois.readObject();
        ois.close();
        return list;
    }
}
