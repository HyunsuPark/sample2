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
	public void load() throws ParserConfigurationException, SAXException, IOException {
		File xmlFile = new File("config/web.xml");

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(xmlFile);

		doc.getDocumentElement().normalize();

		NodeList itemNodeList = doc.getChildNodes();

		for (int s = 0; s < itemNodeList.getLength(); s++) {

			Node itemNode = itemNodeList.item(s);

			if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println("node.getNodeName() : " + itemNode.getNodeName());
				
				NodeList childNodeList = itemNode.getChildNodes(); 
				
				for (int i = 0; i < childNodeList.getLength(); i++) {
					Node itemChildNode = childNodeList.item(i);
					Element itemElement = (Element) itemChildNode;
					
					NodeList titleNodeList = itemElement
							.getElementsByTagName("welcome-file-list");
					Element titleElement = (Element) titleNodeList.item(0);
					NodeList childTitleNodeList = titleElement.getChildNodes();
					
					System.out.printf("[welcome-file : %s]\n",
							((Node) childTitleNodeList.item(0)).getNodeValue());
				}
			}

		}
	}
}
