import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class writeFile<T> {
    public  void writeToFile(T[] array, String fileName) {

        try(FileWriter writer = new FileWriter(fileName, false)) {

        for (T el: array) {
            T s = el;//Integer.toString(el);
            writer.write(s.toString());
            writer.append('\n');
            writer.flush();

        }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
