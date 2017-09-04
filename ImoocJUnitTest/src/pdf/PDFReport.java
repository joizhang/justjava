package pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Phrase;

public class PDFReport {
	
	public static void main(String[] args) {
		//设置为A4纸
		Document document = new Document(PageSize.A4);
		System.out.println((new File("C:/Windows/Fonts/simsun.ttf")).exists());
		
		try {
			//1、若目标文件存在则删除
			File targetFile = new File("D:\\test.pdf");
			if(targetFile.exists()) {
				targetFile.delete();
			}
			
			//2、
			PdfWriter.getInstance(document, new FileOutputStream("D:\\test.pdf"));
			document.open();
			PDFReport pr = new PDFReport();
			
			//3、新建字体-》宋体，document.open()后才可
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
			
			
			//4、表格为9列，宽度为100%
			float[] widths = {0.1f,0.12f,0.1f,0.1f,0.15f,0.1f,0.18f,0.09f,0.06f};
			PdfPTable table = new PdfPTable(widths);
			table.setWidthPercentage(100);
			
			//5、标题
			PdfPCell cell = new PdfPCell();
			cell = pr.createColspanCell("2015年重庆市普通高职（专科）学生“专升本”申请推荐及考试报名表", headFont,Element.ALIGN_CENTER, 9, false);
			table.addCell(cell);
			
			//样式定义行
			cell = pr.createCell(" ", textFont, Element.ALIGN_CENTER, false);
			table.addCell(cell);
			cell = pr.createCell(" ", textFont, Element.ALIGN_CENTER, false);
			table.addCell(cell);
			cell = pr.createCell(" ", textFont, Element.ALIGN_CENTER, false);
			table.addCell(cell);
			cell = pr.createCell(" ", textFont, Element.ALIGN_CENTER, false);
			table.addCell(cell);
			cell = pr.createCell(" ", textFont, Element.ALIGN_CENTER, false);
			table.addCell(cell);
			cell = pr.createCell(" ", textFont, Element.ALIGN_CENTER, false);
			table.addCell(cell);
			cell = pr.createCell(" ", textFont, Element.ALIGN_CENTER, false);
			table.addCell(cell);
			cell = pr.createCell(" ", textFont, Element.ALIGN_CENTER, false);
			table.addCell(cell);
			cell = pr.createCell(" ", textFont, Element.ALIGN_CENTER, false);
			table.addCell(cell);
			
			//、姓名
			cell = pr.createRowspanCell("姓名", keyFont, Element.ALIGN_CENTER, 2, true);
			table.addCell(cell);
			cell = pr.createRowspanCell("陆霞", textFont, Element.ALIGN_CENTER, 2, true);
			table.addCell(cell);
			
			//、性别
			cell = pr.createRowspanCell("性别", keyFont, Element.ALIGN_CENTER, 2, true);
			table.addCell(cell);
			cell = pr.createRowspanCell("女", textFont, Element.ALIGN_CENTER, 2, true);
			table.addCell(cell);
			
			//、身份证号码
			cell = pr.createCell("身份证号码", keyFont, Element.ALIGN_CENTER, true);
			table.addCell(cell);
			cell = pr.createColspanCell("500234199409116054", textFont, Element.ALIGN_CENTER, 2, true);
			table.addCell(cell);
			
			//、照片
			try {
				Image image = Image.getInstance("E:/重庆市招生考试服务有限责任公司/photo library/32090219921120006X.jpg");
				cell = pr.createRowspanColspanCell(image, Element.ALIGN_CENTER, 4, 2, true);
				table.addCell(cell);
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println(e.toString());
				cell = pr.createRowspanAndColspanCell("无照片", textFont, Element.ALIGN_CENTER, 4, 2, true);
				table.addCell(cell);
			}
			
			//、专升本报名号
			cell = pr.createCell("专升本报名号", keyFont, Element.ALIGN_CENTER, true);
			table.addCell(cell);
			cell = pr.createColspanCell("12300210007", textFont, Element.ALIGN_CENTER, 2, true);
			table.addCell(cell);
			
			//、民族
			cell = pr.createCell("民族", keyFont, Element.ALIGN_CENTER, true);
			table.addCell(cell);
			cell = pr.createCell("汉族", textFont, Element.ALIGN_CENTER, true);
			table.addCell(cell);
			
			//、政治面貌
			cell = pr.createCell("政治面貌", keyFont, Element.ALIGN_CENTER, true);
			table.addCell(cell);
			cell = pr.createCell("共青团员", textFont, Element.ALIGN_CENTER, true);
			table.addCell(cell);
			
			//、生源地
			cell = pr.createCell("生源地", keyFont, Element.ALIGN_CENTER, true);
			table.addCell(cell);
			cell = pr.createColspanCell("重庆", textFont, Element.ALIGN_CENTER, 2, true);
			table.addCell(cell);
			
			//、推荐学校及专业
			cell = pr.createColspanCell("推荐学校及专业", keyFont, Element.ALIGN_CENTER, 2, true);
			table.addCell(cell);
			cell = pr.createColspanCell("推荐学校及专业", textFont, Element.ALIGN_CENTER, 5, true);
			table.addCell(cell);
			
			//、第一志愿学校及专业
			cell = pr.createColspanCell("第一志愿学校及专业", keyFont, Element.ALIGN_CENTER, 2, true);
			table.addCell(cell);
			cell = pr.createColspanCell("推荐学校及专业", textFont, Element.ALIGN_CENTER, 3, true);
			table.addCell(cell);
			
			//、是否服从第一志愿学校调配
			cell = pr.createColspanCell("是否服从第一志愿学校调配", keyFont, Element.ALIGN_CENTER, 3, true);
			table.addCell(cell);
			cell = pr.createCell("", textFont, Element.ALIGN_CENTER, true);
			table.addCell(cell);
			
			//、第二志愿学校及专业
			cell = pr.createColspanCell("第二志愿学校及专业", keyFont, Element.ALIGN_CENTER, 2, true);
			table.addCell(cell);
			cell = pr.createColspanCell("", textFont, Element.ALIGN_CENTER, 3, true);
			table.addCell(cell);
			
			//、是否服从第二志愿学校和全市调配
			cell = pr.createColspanCell("是否服从第二志愿学校和全市调配", keyFont, Element.ALIGN_CENTER, 3, true);
			table.addCell(cell);
			cell = pr.createCell("", textFont, Element.ALIGN_CENTER, true);
			table.addCell(cell);
			
			//添加table
			document.newPage();
			document.add(table);
			document.newPage();
			//添加table
			document.add(table);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		document.close();
	}
	
	/**
	 * 正常情况
	 * @param value:输入数据
	 * @param font:字体
	 * @param boderFlag:是否有边框
	 */
	public PdfPCell createCell(String value, Font font, int align, boolean boderFlag) {
		PdfPCell cell = new PdfPCell();
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(align);
		cell.setPhrase(new Phrase(value, font));
		if (!boderFlag) {
			cell.setBorder(0);
			cell.setPaddingTop(15.0f);
			cell.setPaddingBottom(15.0f);
		}
		return cell;
	}
	
	/**
	 * 创建合并列
	 * @param value:输入数据
	 * @param font:字体
	 * @param align:数据显示位置
	 * @param colspan:所占列数
	 * @param boderFlag:是否有边框
	 */
	public PdfPCell createColspanCell(String value, Font font,
			int align, int colspan, boolean boderFlag) {
		PdfPCell cell = new PdfPCell();
		cell.setPhrase(new Phrase(value, font));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(align);
		cell.setColspan(colspan);
		cell.setPadding(5.0f);
		if (!boderFlag) {
			cell.setBorder(0);
			cell.setPaddingTop(15.0f);
			cell.setPaddingBottom(15.0f);
		}
		return cell;
	}
	
	/**
	 * 创建合并行
	 * @param value:输入数据
	 * @param font:字体
	 * @param verticalAlign:
	 * @param colspan:所占列数
	 * @param boderFlag:是否有边框
	 * @return
	 */
	public PdfPCell createRowspanCell(String value, Font font,
			int verticalAlign, int rowspan, boolean boderFlag) {
		PdfPCell cell = new PdfPCell();
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(verticalAlign);
		cell.setRowspan(rowspan);
		cell.setPhrase(new Phrase(value, font));
		cell.setPadding(3.0f);
		if (!boderFlag) {
			cell.setBorder(0);
			cell.setPaddingTop(15.0f);
			cell.setPaddingBottom(15.0f);
		}
		return cell;
	}
	
	/**
	 * 创建合并行列
	 * @param value:输入数据
	 * @param font:字体
	 * @param align:数据显示位置
	 * @param colspan:所占列数
	 * @param boderFlag:是否有边框
	 * @return
	 */
	public PdfPCell createRowspanAndColspanCell(String value, Font font,
			int align, int rowspan, int colspan, boolean boderFlag) {
		PdfPCell cell = new PdfPCell();
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(align);
		cell.setRowspan(rowspan);
		cell.setColspan(colspan);
		cell.setPhrase(new Phrase(value, font));
		cell.setPadding(3.0f);
		if (!boderFlag) {
			cell.setBorder(0);
			cell.setPaddingTop(15.0f);
			cell.setPaddingBottom(15.0f);
		}
		return cell;
	}
	
	/**
	 * 创建图像的合并行列
	 * @param image:图片
	 * @param align:数据显示位置
	 * @param colspan:所占列数
	 * @param boderFlag:是否有边框
	 * @return
	 */
	public PdfPCell createRowspanColspanCell(Image image, int align,
			int rowspan, int colspan, boolean boderFlag) {
		PdfPCell cell = new PdfPCell();
		PdfPCell imageCell = new PdfPCell();
		PdfPTable imageTable= new PdfPTable(1);
		//image.setWidthPercentage(10);
		image.scaleAbsolute(60, 90);
		//tImgCover.scalePercent(50);
		imageCell.setImage(image);
		//imageCell.setFixedHeight(50);
		imageCell.setBorder(0);
		imageTable.addCell(imageCell);
		
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(align);
		cell.setRowspan(rowspan);
		cell.setColspan(colspan);
		cell.addElement(imageTable);
		//cell.setPadding(3.0f);
		if (!boderFlag) {
			cell.setBorder(0);
		}
		return cell;
	}
	
	/**
	 * 创建表格
	 * @param colNumber:列数
	 * @param TotalWidth:总长度
	 */
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