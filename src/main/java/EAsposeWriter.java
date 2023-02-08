import com.aspose.words.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class EAsposeWriter {
    private File file;
    private Document document;

    public EAsposeWriter(File file){
        this.file = file;
        try {
            this.document = new Document(String.valueOf(file));
        } catch (Exception e) {
            System.err.println("Hata: " + e.getMessage());
            System.exit(0);
        }
    }

    public void writePDF(String fileName){
        try {
            document.getWatermark().setText("watermark",setTextWaterMark());
            document.save("src/"+fileName+".pdf",SaveFormat.PDF);
            System.err.println("İşlem Bitti - Aspose ile PDF dosyası hazırlandı.");

        } catch (Exception e) {
            System.err.println("Hata: " + e.getMessage());
        }
    }

    private TextWatermarkOptions setTextWaterMark(){
        TextWatermarkOptions options = new TextWatermarkOptions();
        options.setFontFamily("Arial");
        options.setFontSize(12);
        options.setColor(Color.BLACK);
        options.setLayout(WatermarkLayout.DIAGONAL);
        options.isSemitrasparent(true);
        return options;
    }

}
