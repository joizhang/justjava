package com.joizhang.imooc.xml.sax;

import com.joizhang.imooc.xml.sax.entity.Book;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author joizhang
 */
public class SAXTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // 获取SAXParserFactory的实例
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // 通过factory获取SAXParser实例
        try {
            SAXParser parser = factory.newSAXParser();
            // 创建SAXParserHandler对象
            SAXParserHandler handler = new SAXParserHandler();
            parser.parse("books.xml", handler);
            System.out.println("~! ~! ~! 共有" + handler.getBookList().size() + "本书");
            for (Book book : handler.getBookList()) {
                System.out.println(book.getId());
                System.out.println(book.getName());
                System.out.println(book.getAuthor());
                System.out.println(book.getYear());
                System.out.println(book.getPrice());
                System.out.println(book.getLanguage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
