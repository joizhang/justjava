package pdf;  
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStream;  
import com.itextpdf.text.Document;  
import com.itextpdf.text.DocumentException;  
import com.itextpdf.text.Font;  
import com.itextpdf.text.Paragraph;  
import com.itextpdf.text.pdf.BaseFont;  
import com.itextpdf.text.pdf.PdfWriter;  
/** 
 * <b>PDF2Chinese。</b> 
 * <p><b>详细说明：</b></p> 
 * <!-- 在此添加详细说明 --> 
 * 三种方法解决iText中文问题。 
 * <p><b>修改列表：</b></p> 
 * <table width="100%" cellSpacing=1 cellPadding=3 border=1> 
 * <tr bgcolor="#CCCCFF"><td>序号</td><td>作者</td><td>修改日期</td><td>修改内容</td></tr> 
 * <!-- 在此添加修改列表，参考第一行内容 --> 
 * <tr><td>1</td><td>Oliver</td><td>2010-10-8 上午09:40:44</td><td>建立类型</td></tr> 
 *  
 * </table> 
 * @version 1.0 
 * @author Oliver 
 * @since 1.0 
 */  
public class FontTest  
{  
    public static void main(String[] args) throws DocumentException, IOException  
    {  
        Document document = new Document();  
        OutputStream os = new FileOutputStream(new File("d:/chinese.pdf"));  
        PdfWriter.getInstance(document,os);
        document.open();  
        //方法一：使用Windows系统字体(TrueType)  
        BaseFont baseFont = BaseFont.createFont("C:/Windows/Fonts/SIMYOU.TTF",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);  
          
        //方法二：使用iTextAsian.jar中的字体  
        //BaseFont baseFont = BaseFont.createFont("STSong-Light",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);  
          
        //方法三：使用资源字体(ClassPath)  
        ////BaseFont baseFont = BaseFont.createFont("/SIMYOU.TTF",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);  
          
        Font font = new Font(baseFont);  
        document.add(new Paragraph("解决中文问题了！",font));  
        document.close();  
    }  
}  