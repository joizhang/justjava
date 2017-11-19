package com.joizhang.imooc.xml.sax;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.imooc.xml.sax.entity.Book;

public class SAXParserHandler extends DefaultHandler {
	String value = null;
	Book book = null;
	private ArrayList<Book> bookList = new ArrayList<Book>();
	
	public ArrayList<Book> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}

	int bookIndex = 0;
	/**
	 * 用来标志解析开始
	 * */
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("SAX解析开始\n");
	}
	
	/**
	 * 用来标志解析结束
	 * */
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("SAX解析结束");
	}
	
	/**
	 * 用来遍历xml的开始标签
	 * */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		// 调用DefaultHandler类的startElement方法
		super.startElement(uri, localName, qName, attributes);
		// 开始解析
		if(qName.equals("book")) {
			book = new Book();
			bookIndex++;
			System.out.println("==========开始遍历第"+ bookIndex +"本书的内容==========");
			//已知book元素下的属性名称
			/*String value = attributes.getValue("id");
			System.out.println("book的属性值是：" + value);*/
			
			//不知道book元素下的属性的名称及个数
			int num = attributes.getLength();
			for(int i = 0; i < num; i++) {
				System.out.print("book元素的第" + (i + 1) + "个属性名是：" +attributes.getQName(i));
				System.out.println("---属性值是：" + attributes.getValue(i));
				if(attributes.getQName(i).equals("id")) {
					book.setId(attributes.getValue(i));
				}
			}
		} else if(!qName.equals("book") && !qName.equals("bookstore")) {
			System.out.print("节点名是：" + qName);
		}
	}
	
	/**
	 * 用来遍历xml的结束标签
	 * */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		// 调用DefaultHandler类的endElement方法
		super.endElement(uri, localName, qName);
		//判断是否针对一本书已经遍历结束
		if(qName.equals("book")) {
			//在清空书之前先保存进bookList
			bookList.add(book);
			book = null;
			System.out.println("==========第"+ bookIndex +"本书的内容遍历结束==========\n");
		} else if(qName.equals("name")) {
			book.setName(value);
		} else if(qName.equals("author")) {
			book.setAuthor(value);
		} else if(qName.equals("year")) {
			book.setYear(value);
		} else if(qName.equals("price")) {
			book.setPrice(value);
		} else if(qName.equals("language")) {
			book.setLanguage(value);
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		value = new String(ch, start, length);
		if(!value.trim().equals("")) {
			System.out.println("---属性值是：" + value);
		}
	}
}
