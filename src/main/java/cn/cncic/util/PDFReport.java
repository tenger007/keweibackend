package cn.cncic.util;


import java.io.FileOutputStream;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfWriter; 

public class PDFReport {

    
    public static void main(String[] args) throws Exception, DocumentException {
        
        //调用第一个方法，向d盘生成一个名字为ITextTest.pdf 的文件  
        try {  
            writeSimplePdf();  
        }   
        catch (Exception e) { e.printStackTrace(); }  
          
          
        //调用第二个方法，向d盘名字为ITextTest.pdf的文件，添加章节。  
        try {  
            writeCharpter();  
        }   
        catch (Exception e) { e.printStackTrace(); }  
          
          
    }  
      
  
    public static void writeSimplePdf() throws Exception {  
          
        // 1.新建document对象  
        // 第一个参数是页面大小。接下来的参数分别是左、右、上和下页边距。  
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);  
          
        // 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。  
        // 创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。  
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\Mywork\\ITextTest.pdf"));  
          
        // 3.打开文档  
        document.open();  
          
        // 4.向文档中添加内容  
        // 通过 com.lowagie.text.Paragraph 来添加文本。可以用文本及其默认的字体、颜色、大小等等设置来创建一个默认段落  
        document.add(new Paragraph("First page of the document."));  
        document.add(new Paragraph("Some more text on the   first page with different color and font type.", FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD)));  
          
        // 5.关闭文档  
        document.close();  
    }  
  
      
    /** 
     * 添加含有章节的pdf文件 
     *  
     * @throws Exception 
     */  
    public static void writeCharpter() throws Exception {  
          
        // 新建document对象 第一个参数是页面大小。接下来的参数分别是左、右、上和下页边距。  
        Document document = new Document(PageSize.A4, 20, 20, 20, 20);  
          
        // 建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。  
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\Mywork\\ITextTest.pdf"));  
          
        // 打开文件  
        document.open();  
          
        // 标题  
        document.addTitle("Hello mingri example");  
          
        // 作者  
        document.addAuthor("wolf");  
          
        // 主题  
        document.addSubject("This example explains how to add metadata.");  
        document.addKeywords("iText, Hello mingri");  
        document.addCreator("My program using iText");  
          
        // document.newPage();  
        // 向文档中添加内容  
        document.add(new Paragraph("\n"));  
        document.add(new Paragraph("\n"));  
        document.add(new Paragraph("\n"));  
        document.add(new Paragraph("\n"));  
        document.add(new Paragraph("\n"));  
        document.add(new Paragraph("First page of the document."));  
        document.add(new Paragraph("First page of the document."));  
        document.add(new Paragraph("First page of the document."));  
        document.add(new Paragraph("First page of the document."));  
        document.add(new Paragraph("Some more text on the first page with different color and font type.", FontFactory.getFont(FontFactory.defaultEncoding, 10, Font.BOLD)));  
        Paragraph title1 = new Paragraph("Chapter 1", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC));  
          
        // 新建章节  
        Chapter chapter1 = new Chapter(title1, 1);  
        chapter1.setNumberDepth(0);  
        Paragraph title11 = new Paragraph("This is Section 1 in Chapter 1", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD));  
        Section section1 = chapter1.addSection(title11);  
        Paragraph someSectionText = new Paragraph("This text comes as part of section 1 of chapter 1.");  
        section1.add(someSectionText);  
        someSectionText = new Paragraph("Following is a 3 X 2 table.");  
        section1.add(someSectionText);  
        document.add(chapter1);  
          
        // 关闭文档  
        document.close();  
    } 
}