package com.javabasic._day13_XML和Dom4j装饰模式工厂模式commonsio工具包Base64;

/**
 * @ClassName XmlDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/17 22:55
 * @Version 1.0
 **/

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.annotation.Resources;
import java.io.File;
import java.io.InputStream;
import java.util.List;

/***
 *   Java提供了Class下的一个方法：
 *          public InputStream getResourceAsStream(String path)
 *             -- 用于加载文件成为一个字节输入流返回！！
 *
 *     Document文档：
 *          Element getRootElement()：获取根元素。
 */
public class XmlDemo {
    public static void main(String[] args) throws DocumentException {
        // 需求：解析books.xml文件成为一个Document文档树对象，得到根元素对象。
        // 1.创建一个dom4j的解析器对象：代表整个dom4j框架。
        SAXReader saxReader = new SAXReader();

        // 2.第一种方式（简单）：通过解析器对象去加载xml文件数据，成为一个Document文档树对象。
        //Document document = saxReader.read(new File("Day13Demo/src/books.xml"));

        // 3.第二种方式（代码多点）先把xml文件读成一个字节输入流
        // 这里的“/”是直接去src类路径下寻找文件。
        InputStream is = Resources.class.getResourceAsStream("/demo01.xml");
        //InputStream is = XmlDemo.class.getResourceAsStream("src/main/resources/demo01.xml");
        Document document = saxReader.read(is);

        System.out.println(document);

        // 4.从document文档树对象中提取根元素对象
        Element root = document.getRootElement();
        System.out.println(root.getName());
        List<Element> elementList = root.elements();
        for (Element element : elementList) {
            System.out.println(element.getName());
        }

        Element names = root.element("name");
        List<Attribute> attributes = names.attributes();
        for (Attribute attribute : attributes) {
            System.out.println(attribute.getName() + "===" + attribute.getValue());
        }

        System.out.println(root.elementText("name"));
        System.out.println(root.elementText("age"));
        System.out.println(root.elementTextTrim("sex"));

    }
}
