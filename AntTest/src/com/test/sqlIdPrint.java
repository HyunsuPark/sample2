package com.test;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class sqlIdPrint {
	 
	public static void main(String argv[]) {
 
		try {
			File file = new File("src/ExtCec0002.xml");
			DocumentBuilderFactory docBuildFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuild = docBuildFact.newDocumentBuilder();
			Document doc = docBuild.parse(file);
			doc.getDocumentElement().normalize();
 
			// person엘리먼트 리스트
			NodeList personlist = doc.getElementsByTagName("select");
 
			for (int i = 0; i < personlist.getLength(); i++) {
 
				Node personNode = personlist.item(i);
 
				if (personNode.getNodeType() == Node.ELEMENT_NODE) {
					// person엘리먼트 
					Element personElmnt = (Element) personNode;
 
					System.out.println(personElmnt.getAttribute("id"));
				}
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}