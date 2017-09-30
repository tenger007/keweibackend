package cn.cncic.util;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class HelloWorldPDF {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
    	Document document = new Document();
    	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\Mywork\\Helloword.pdf"));
    	document.open();
    	document.add(new Paragraph("Hello Cncic"));
    	document.close();
    	writer.close();
    }
}
