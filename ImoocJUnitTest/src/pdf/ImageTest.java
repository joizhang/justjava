package pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ImageTest {
	public static void main(String[] args) {
		Document document = new Document(PageSize.A4);
		
        try {
        	File targetFile = new File("d:/chinese.pdf");
			if(targetFile.exists()) {
				targetFile.delete();
			}
			OutputStream os = new FileOutputStream(new File("d:/chinese.pdf"));
			
			PdfWriter.getInstance(document, os);
			document.open();
			ImageTest it = new ImageTest();
			
			//创建字体
			BaseFont SimSun = null;
			try {
				SimSun = BaseFont.createFont("C:/Windows/Fonts/simsun.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Font headFont = new Font(SimSun, 16f, Font.BOLD);
			Font keyFont = new Font(SimSun, 11.5f, Font.BOLD);
			Font textFont = new Font(SimSun, 11.5f, Font.NORMAL);
			
			//
			PdfPTable table = new PdfPTable(1);
			table.setWidthPercentage(15);
			
			PdfPCell cell = new PdfPCell();
			try {
				Image image = Image.getInstance("E:/重庆市招生考试服务有限责任公司/photo library/32090219921120006X.jpg");
				cell = it.createImageCell(image, Element.ALIGN_CENTER, true);
				table.addCell(cell);
			} catch (Exception e) {
				System.out.println(e.toString());
				cell = it.createCell("无照片", textFont, Element.ALIGN_CENTER, true);
				table.addCell(cell);
			}
			
			document.add(table);
		} catch (Exception e) {
			e.printStackTrace();
		}
        document.close();
	}
	
	public PdfPCell createImageCell(Image image, int align, boolean boderFlag){
		PdfPCell cell = new PdfPCell();
		PdfPCell zcell = new PdfPCell();
		PdfPTable table= createTable(1, 80);
		image.setWidthPercentage(0);
		//tImgCover.scaleAbsolute(60, 80);
		//tImgCover.scalePercent(50);
		zcell.setImage(image);
		zcell.setFixedHeight(110);
		table.addCell(zcell);
		
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(align);
		// tImgCover.setWidthPercentage(0);
//		tImgCover.scaleAbsolute(3, 4);
		// tImgCover.scaleAbsoluteHeight(108);
		cell.addElement(table);
		cell.setPadding(3.0f);
		if (!boderFlag) {
			cell.setBorder(0);
			cell.setPaddingTop(15.0f);
			cell.setPaddingBottom(8.0f);
		}
		return cell;
	}
	
	public PdfPCell createCell(String value, Font font, int align, boolean boderFlag) {
		PdfPCell cell = new PdfPCell();
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(align);
		cell.setPhrase(new Phrase(value, font));
		if (!boderFlag) {
			cell.setBorder(0);
			cell.setPaddingTop(15.0f);
			cell.setPaddingBottom(8.0f);
		}
		return cell;
	}
	
	public PdfPTable createTable(int colNumber, int TotalWidth) {
		PdfPTable table = new PdfPTable(colNumber);
		try {
			table.setTotalWidth(TotalWidth);
			//table.setWidths(new float[]{TotalWidth});
			table.setLockedWidth(true);
			// table.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.getDefaultCell().setBorderWidthRight(0);
			table.getDefaultCell().setBorder(1);
			//table.setWidthPercentage(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return table;
	}
}
