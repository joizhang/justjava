package com.imooc.xml.jdom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class JDomTest {
	public static void main(String[] args) {
		//进行对books.xml文件的JDOM解析
		//准备工作
		//1、创建一个SAXBuilder的对象
		SAXBuilder saxBuilder = new SAXBuilder();
		try {
			//2、创建输入流，见xml文件加载到输入流中
			InputStream in = new FileInputStream("books.xml");
			//3、通过saxBuilder的builder方法，将输入流加载到saxBuilder
			Document document = saxBuilder.build(in);
			//4、通过document对象获取xml文件的根节点
			Element rootElement = document.getRootElement();
			//5、获取根节点下的子节点
			List<Element> bookList = rootElement.getChildren();
			//继续进行解析
			for(Element book : bookList) {
				System.out.println("开始解析第" + (bookList.indexOf(book) + 1) + "本书");
				
				//解析book的属性
				List<Attribute> attrList = book.getAttributes();
				//遍历attrList（针对不清楚book节点下属性及数量）
				for(Attribute attr : attrList) {
					//获取属性名 //获取属性值
					System.out.println("属性名：" + attr.getName() + "-----属性值：" + attr.getValue());
					
				}
				
				System.out.println("结束解析第" + (bookList.indexOf(book) + 1) + "本书");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
