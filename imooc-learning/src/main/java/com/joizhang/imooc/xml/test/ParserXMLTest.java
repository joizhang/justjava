package com.joizhang.imooc.xml.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jdom2.Attribute;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.imooc.xml.sax.SAXParserHandler;
import com.imooc.xml.sax.entity.Book;


public class ParserXMLTest {
	public void domXmlParser() {
		ArrayList<Book> bookLists = new ArrayList<Book>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse("books.xml");
			NodeList bookList = document.getElementsByTagName("book");
			for (int i = 0; i < bookList.getLength(); i++) {
				Node book = bookList.item(i);
				Book bookEntity = new Book();
				NamedNodeMap attrs = book.getAttributes();
				for (int j = 0; j < attrs.getLength(); j++) {
					Node attr = attrs.item(j);
					if (attr.getNodeName().equals("id")) {
						bookEntity.setId(attr.getNodeValue());
					}
				}
				NodeList childNodes = book.getChildNodes();
				for (int k = 0; k < childNodes.getLength(); k++) {
					if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
						String name = childNodes.item(k).getNodeName();
						String value = childNodes.item(k).getFirstChild().getNodeValue();
						if (name.equals("name")) {
							bookEntity.setName(value);
						}
						else if (name.equals("author")) {
							bookEntity.setAuthor(value);
						}
						else if (name.equals("year")) {
							bookEntity.setYear(value);
						}
						else if (name.equals("price")) {
							bookEntity.setPrice(value);
						}
						else if (name.equals("language")) {
							bookEntity.setLanguage(value);
						}
					}
				}
				bookLists.add(bookEntity);
				bookEntity = null;
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saxXmlParser(){
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			SAXParserHandler handler = new SAXParserHandler();
			parser.parse("books.xml", handler);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void jdomXmlParser() {
		ArrayList<Book> booksList = new ArrayList<Book>();
		SAXBuilder saxBuilder = new SAXBuilder();
		InputStream in;
		try {
			in = new FileInputStream("books.xml");
			InputStreamReader isr = new InputStreamReader(in, "UTF-8");
			org.jdom2.Document document = saxBuilder.build(isr);
			org.jdom2.Element rootElement = document.getRootElement();
			List<org.jdom2.Element> bookList = rootElement.getChildren();
			for (org.jdom2.Element book : bookList) {
				Book bookEntity = new Book();
				List<Attribute> attrList = book.getAttributes();
				for (Attribute attr : attrList) {
					String attrName = attr.getName();
					String attrValue = attr.getValue();
					if (attrName.equals("id")) {
						bookEntity.setId(attrValue);
					}
				}
				List<org.jdom2.Element> bookChilds = book.getChildren();
				for (org.jdom2.Element child : bookChilds) {
					if (child.getName().equals("name")) {
						bookEntity.setName(child.getValue());
					}
					else if (child.getName().equals("author")) {
						bookEntity.setAuthor(child.getValue());
					}
					else if (child.getName().equals("year")) {
						bookEntity.setYear(child.getValue());
					}
					else if (child.getName().equals("price")) {
						bookEntity.setPrice(child.getValue());
					}
					else if (child.getName().equals("language")) {
						bookEntity.setLanguage(child.getValue());
					}
				}
				booksList.add(bookEntity);
				bookEntity = null;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void dom4jXmlParser(){
		ArrayList<Book> booksList = new ArrayList<Book>();
		SAXReader reader = new SAXReader();
		try {
			org.dom4j.Document document = reader.read(new File("books.xml"));
			org.dom4j.Element bookStore = document.getRootElement();
			List<org.dom4j.Element> bookEles = bookStore.elements();
			for (org.dom4j.Element book : bookEles) {
				Book bookEntity = new Book();
				List<org.dom4j.Attribute> bookAttrs = book.attributes();
				for (org.dom4j.Attribute attr : bookAttrs) {
					if (attr.getName().equals("id")) {
						bookEntity.setId(attr.getValue());
					}
				}
				List<org.dom4j.Element> bookss = book.elements();
				for (org.dom4j.Element bookChild : bookss) {
					String name = bookChild.getName();
					String value = bookChild.getStringValue();
					if (name.equals("name")) {
						bookEntity.setName(value);
					}
					else if (name.equals("author")) {
						bookEntity.setAuthor(value);
					}
					else if (name.equals("year")) {
						bookEntity.setYear(value);
					}
					else if (name.equals("price")) {
						bookEntity.setPrice(value);
					}
					else if (name.equals("language")) {
						bookEntity.setLanguage(value);
					}
				}
				booksList.add(bookEntity);
				bookEntity = null;
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPerformance() throws Exception{
		System.out.println("性能测试:");
		
		//测试DOM的性能:
		long start = System.currentTimeMillis();
		domXmlParser();
		System.out.println("DOM:"+ (System.currentTimeMillis() - start) );
		
		//测试SAX的性能:
		start = System.currentTimeMillis();
		saxXmlParser();
		System.out.println("SAX:"+ (System.currentTimeMillis() - start) );
		
		//测试JDOM的性能:
		start = System.currentTimeMillis();
		jdomXmlParser();
		System.out.println("JDOM:"+ (System.currentTimeMillis() - start) );
		
		//测试DOM4J的性能:
		start = System.currentTimeMillis();
		dom4jXmlParser();
		System.out.println("DOM4J:"+ (System.currentTimeMillis() - start) );
	
	}
}
