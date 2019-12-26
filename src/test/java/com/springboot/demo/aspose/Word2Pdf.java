//package com.springboot.demo.aspose;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import junit.framework.Test;
//import com.aspose.words.Document;
//import com.aspose.words.SaveFormat;
//
///**
// * @program demo-test
// * @description: word文档转成pdf可以使用
// * @author: jason
// * @create: 2019-09-02 14:40
// */
//public class Word2Pdf {
//	public static boolean getLicense() {
//		boolean result = false;
//		try {
//			java.io.InputStream is = Test.class.getClassLoader().getResourceAsStream("license.xml"); //  wordlicense.xml应放在..\WebRoot\WEB-INF\classes路径下
//			com.aspose.words.License aposeLic = new com.aspose.words.License();
//			aposeLic.setLicense(is);
//			 result = true;
//		 }
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
//	public static void word2pdf(String docxPath, String pdfPath) {
//		 if (!getLicense()) {          // 验证License 若不验证则转化出的PDP文档会有水印产生
//			 return;
//		 }
//		 try {
////			File file = new File("/Users/jason/Documents/IdeaProjects/demo-test/src/test/java/com/springboot/demo/aspose/testSpire.pdf");  //新建一个空白pdf文档
//			File file = new File(pdfPath);  //新建一个空白pdf文档
//			FileOutputStream os = new FileOutputStream(file);
//			Document doc = new Document(docxPath);                    //Address是将要被转化的word文档
//			doc.save(os, SaveFormat.PDF);                            //全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换            os.close();
//		 }
//		 catch (Exception e) {
//			 e.printStackTrace();
//		 }
//	}
//
//
//	public static void main(String[] args) {
//		String docxPath="/Users/jason/Documents/IdeaProjects/demo-test/src/test/java/com/springboot/demo/aspose/test3_new.docx";
//		String pdfPath="/Users/jason/Documents/IdeaProjects/demo-test/src/test/java/com/springboot/demo/aspose/test_itext.pdf";
//		word2pdf(docxPath,pdfPath);
//	}
//}
