package com.sample.load;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlLoadder {

	private String libFileSrc = "";
	
	public String getLibFileSrc(){
		return this.libFileSrc;
	}
	
	public void load() throws ParserConfigurationException, SAXException, IOException {
		File xmlFile = new File("config/web.xml");

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(xmlFile);

		doc.getDocumentElement().normalize();

		//초기 페이지 정보 읽기
		NodeList wlecomelist = doc.getElementsByTagName("lib-file-list");
		
		for (int i = 0; i < wlecomelist.getLength(); i++) {
			
			Node welcomeNode = wlecomelist.item(i);
			 
			if (welcomeNode.getNodeType() == Node.ELEMENT_NODE) {
				Element welcomeElmnt = (Element) welcomeNode;

				NodeList libList= welcomeElmnt.getElementsByTagName("lib-file");
				Element libElmnt = (Element) libList.item(0);
				Node libNode = libElmnt.getFirstChild();
				
				libFileSrc = libNode.getNodeValue();
				System.out.println("libFileSrc    : " + libFileSrc);
			}
			
		}
		 
		System.out.println("Xml config Loadding Success");
	}
}
