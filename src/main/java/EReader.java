import java.io.*;
import java.util.ArrayList;

public class EReader {
    private BufferedReader bufferedReader;
    private EWriter eWriter;
    private ArrayList<String> values = new ArrayList<>();

    public EReader(EWriter eWriter, BufferedReader bufferedReader){
        this.eWriter = eWriter;
        this.bufferedReader = bufferedReader;
    }

    public void readFile() throws IOException {
        String value;
        eWriter.openDocument(); // pdf dosyasına yazmak için dosyayı aktif ediyoruz
        while (bufferedReader.ready()){
            value = bufferedReader.readLine();
            eWriter.writePDF(value);
        }
        eWriter.closeDocument(); // yazma işlemimiz bitince dosyayı kapatıyoruz.
        bufferedReader.close();
        System.err.println("İşlem Bitti - PDF Dosyası Hazır.");
    }
    public void readFileAndAddArrayList() throws IOException {
        String value;
        while (bufferedReader.ready()){
            value = bufferedReader.readLine();
            values.add(value);
        }
        bufferedReader.close();
        System.err.println("İşlem Bitti - Veriler ArrayList Eklendi ve PDF dosyasına aktarıldı.");
    }
    public ArrayList<String> getValues() {
        return values;
    }
}
