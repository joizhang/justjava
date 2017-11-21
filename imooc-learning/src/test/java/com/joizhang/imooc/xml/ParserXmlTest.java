package com.joizhang.imooc.xml;

import com.joizhang.imooc.xml.test.ParserXml;
import org.junit.Test;

public class ParserXmlTest {

    @Test
    public void testPerformance() throws Exception{
        System.out.println("性能测试:");

        //测试DOM的性能:
        long start = System.currentTimeMillis();
        ParserXml.domXmlParser();
        System.out.println("DOM:"+ (System.currentTimeMillis() - start) );

        //测试SAX的性能:
        start = System.currentTimeMillis();
        ParserXml.saxXmlParser();
        System.out.println("SAX:"+ (System.currentTimeMillis() - start) );

        //测试JDOM的性能:
        start = System.currentTimeMillis();
        ParserXml.jdomXmlParser();
        System.out.println("JDOM:"+ (System.currentTimeMillis() - start) );

        //测试DOM4J的性能:
        start = System.currentTimeMillis();
        ParserXml.dom4jXmlParser();
        System.out.println("DOM4J:"+ (System.currentTimeMillis() - start) );

    }

}
