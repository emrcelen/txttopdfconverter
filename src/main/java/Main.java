import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
            itextStart("jvg");
            asposeStart("aspose");
    }

    private static void itextStart(String fileName){
        try {
            EWriter eWriter = new EWriter(fileName);
            EReader eReader = new EReader(eWriter,new BufferedReader(new FileReader("src/text.txt")));
            //eReader.readFile(); // pdf ekleme işlemini de aynı anda gerçekleştiriyor.
            eReader.readFileAndAddArrayList();
            eWriter.openDocument();
            eWriter.writePDF(eReader.getValues());
            eWriter.closeDocument();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void asposeStart(String fileName){
        EAsposeWriter eAsposeWriter = new EAsposeWriter(new File("src/text.txt"));
        eAsposeWriter.writePDF(fileName);
    }
}
