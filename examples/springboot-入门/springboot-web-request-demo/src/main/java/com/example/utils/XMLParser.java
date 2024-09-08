package com.example.utils;


import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class XMLParser{
  public static <T> List<T> parse(String file, Class<T> targetClass){
    ArrayList<T> list = new ArrayList<T>();
    try{
      // 获取一个解析器对象
      SAXReader saxReader = new SAXReader();
      // 利用解析器把xml加载到内存中,并返回一个文档对象
      Document document = saxReader.read(new File(file));
      // 获取根标签
      Element rootElement = document.getRootElement();
      // 定位到user标签
      List<Element> elements = rootElement.elements("emp");
      // 遍历集合
      for (Element element: elements){
        String name = element.element("name").getText();
        String age = element.element("age").getText();
        // String image = element.element("image").getText();
        String gender = element.element("gender").getText();
        String type = element.element("type").getText();
        
        //构建数据
        Constructor<T> constructor = targetClass.getDeclaredConstructor(String.class, Integer.class, String.class, String.class);
        constructor.setAccessible(true);
        T object = constructor.newInstance(name, Integer.parseInt(age), gender, type);
        list.add(object);
      }
    } catch(Exception e){
      e.printStackTrace();
    }
    return list;
  }
}