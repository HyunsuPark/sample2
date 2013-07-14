package com.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class appClient {
	 public static void main(String[] args) {
		  // xml 환경설정 파일을 불러온다.
		  BeanFactory bf = new XmlBeanFactory(new FileSystemResource("src/com/ioc/myxml.xml"));
		  
		  // 팩토리 가져오기
		  appFactory factory = (appFactory)bf.getBean("appFactory");  //beanId
		  System.out.println(factory.getHello()); // 
		  
		 }
}
