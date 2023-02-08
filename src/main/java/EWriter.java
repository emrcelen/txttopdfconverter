import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class EWriter {
    private Document document; // pdf belgesine içerik eklemek için.
    private PdfWriter pdfWriter; // Bir pdf belgesi oluşturmak için kullanıyoruz.
    private Chunk chunk; // metin dizisini temsil ediyor.
    private BaseFont bf;

    public EWriter(String pdfFileName){
        try {
            this.document = new Document();
            this.pdfWriter = PdfWriter.getInstance(this.document, new FileOutputStream("src/"+pdfFileName+".pdf"));
            // UTF-8 desteği olan bir font nesnesi oluşturuyoruz.
            bf = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException documentException) {
            System.err.println(documentException.getMessage());
            System.exit(0);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println(fileNotFoundException.getMessage());
            System.exit(0);
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
            System.exit(0);
        }
    }

    public void openDocument(){
        document.open();
    }
    public void closeDocument(){
        document.close();
        pdfWriter.close();
    }

    public void writePDF(String value){
        // Kaynak : https://www.baeldung.com/java-pdf-creation
        // Font font = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.RED);
        Font font = new Font(bf,12,Font.NORMAL,BaseColor.BLACK); // utf-8 desteği için.
        try {
            chunk = new Chunk(value,font);
            document.add(new Paragraph(chunk));

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    public void writePDF(ArrayList<String> values){
        // Kaynak : https://www.baeldung.com/java-pdf-creation
        // Font font = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.RED);
        Font font = new Font(bf,12,Font.NORMAL,BaseColor.BLACK); // utf-8 desteği için.
        try {
            StringBuilder sb = new StringBuilder();
            for (String value : values) {
                sb.append(value+"\n");
            }
            chunk = new Chunk(sb.toString(),font);
            document.add(new Paragraph(chunk));

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
