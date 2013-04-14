package org.thinker.web;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.thinker.command.Command;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * ���������� �о Command Ÿ���� ��ü���� ������ �ʿ�����
 * ��� : Ư�� callpath�� ������ ������ commandŸ���� ��ü�� ��ȯ�� �ش�
 * @author Administrator
 *
 */
public class CommandFactory {
	
	private static Logger logger = Logger.getLogger(CommandFactory.class);
	
	private Map<String,Command> cmdMap;
	
	private String configXml = "config.xml";
	
	/**
	 * ���� ������ �о Map���·� ����
	 * @throws Exception
	 */
	public void init() throws Exception{
		logger.info("init......");
		
		cmdMap = new HashMap<String ,Command>();
		readConfig(configXml);
	}
	
	private void readConfig(String fileName) throws Exception{
		logger.info("readConfig......");
		
		ClassLoader loader = this.getClass().getClassLoader();
		URL pathUrl = loader.getResource(fileName);
		System.out.println(pathUrl);
		//url
		
		//JAXP
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		
		Document document = builder.parse(pathUrl.openStream());
	
		logger.info(document);
		
		NodeList list = document.getElementsByTagName("command");
		
		logger.info(list.getLength());
		
		for (int i = 0; i < list.getLength(); i++) {
			Element element = (Element)list.item(i);
			
			logger.info(element.getAttribute("id"));
			logger.info(element.getAttribute("class"));
			
			cmdMap.put(element.getAttribute("id"), (Command)Class.forName(element.getAttribute("class")).newInstance());
		}
	}
	
	public Command lookup(String callPath)throws Exception{
		logger.info("lookup......");
		
		Command target = null;
		target = cmdMap.get(callPath);
		//callpath �� �ش��ϴ� CommandŸ���� ��ü�� �Ҵ�
		
		return target;
	}
}
