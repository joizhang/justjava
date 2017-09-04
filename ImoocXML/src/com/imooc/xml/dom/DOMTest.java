package com.imooc.xml.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// 创建一个DocumentBuilderFactory的对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 创建一个DocumentBuilder的对象
		try {
			// 创建一个DocumentBuilder对象
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 通过DocumentBuilder对象的parse方法加载books.xml
			Document document = db.parse("books.xml");
			// 获取book节点
			NodeList bookList = document.getElementsByTagName("book");
			// 遍历每一个book节点，通过nodeList的getLength()方法获取bookList的长度
			System.out.println("一共有" + bookList.getLength() + "本书");
			for(int i = 0; i < bookList.getLength(); i++) {
				System.out.println("==========下面开始遍历第" + (i + 1) + "本书的内容==========");
				
				// 通过item(i)获取一个book节点
				Node book = bookList.item(i);
				// 获取book节点的所以属性集合
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("第" + (i + 1) + "本书，共有" + attrs.getLength() + "个属性");
				// 遍历book的属性
				for(int j = 0; j < attrs.getLength(); j++) {
					// 通过item(i)方法获取book节点的某个属性
					Node attr = attrs.item(j);
					// 获取属性名
					System.out.print("属性名：" + attr.getNodeName());
					// 获取属性值
					System.out.println("--属性值：" + attr.getNodeValue());
				}
				
				/*// 前提：已经知道book节点只能有1个id属性
				// 将book节点强转为Element类型
				Element book = (Element) bookList.item(i);
				String attrValue = book.getAttribute("id");
				System.out.println("id属性的属性值为" + attrValue);*/
				
				// 解析book节点的子节点
				NodeList childNodes = book.getChildNodes();
				// 遍历childNodes获取每个节点的节点名和节点值，注意空白、换行符
				System.out.println("第" + (i + 1) + "本书共有" + childNodes.getLength() + "个子节点");
				for(int k = 0; k < childNodes.getLength(); k++) {
					// 区分出text类型的node以及element类型的node
					if(childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
						// 获取element类型节点的节点名
						System.out.print("第" + (k + 1) + "各节点的节点名：" + childNodes.item(k).getNodeName());
						//System.out.println("--节点值是：" + childNodes.item(k).getFirstChild().getNodeValue());
						System.out.println("--节点值是：" + childNodes.item(k).getTextContent());
					}
				}
				
				
				System.out.println("==========第" + (i + 1) + "本书的内容遍历结束==========\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
