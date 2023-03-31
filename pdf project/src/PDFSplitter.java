
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

public class PDFSplitter {

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.pdf");
        PDDocument document = PDDocument.load(inputFile);
        Splitter splitter = new Splitter();
        List<PDDocument> pages = splitter.split(document);
        int pageNum = 1;
        for (PDDocument page : pages) {
            String outputFileName = "output_" + pageNum + ".pdf";
            page.save(outputFileName);
            pageNum++;
            page.close();
        }
        document.close();
    }
}
