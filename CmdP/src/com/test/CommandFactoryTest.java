package com.test;

import org.junit.Before;
import org.junit.Test;
import org.thinker.web.CommandFactory;



public class CommandFactoryTest {
	
	CommandFactory factory;
	
	@Before
	public void doA() throws Exception{
		System.out.println("doA");
		factory = new CommandFactory();
		factory.init();
	}
	@Test
	public void doB() throws Exception{
		
		//   /bbb 인 애좀 찾아줘
		System.out.println(factory.lookup("/aaa"));
		
	}
	
	public void doC(){
		System.out.println("doC");
	}
}
