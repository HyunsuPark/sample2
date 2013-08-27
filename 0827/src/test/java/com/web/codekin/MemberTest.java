package com.web.codekin;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.web.codekin.member.MemberDAO;
import com.web.codekin.member.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/**/*-context.xml"})
public class MemberTest {
	@Inject
	MemberDAO dao;
	
	@Test
	public void test() throws Exception{
		System.out.println(dao);
//		org.apache.ibatis.binding.MapperProxy@11daa0e
//		MemberDAO 를 구현한 클래스가 없다 하지만 클래스가 찍힘. porxy
//		아이바티스안에는 프록시팩토리빈이란게있다.
		MemberVO vo = new MemberVO();
		vo.setId("test2");
		vo.setPw("1234");
		vo.setUserName("박박");
		vo.setEmail("welk@lwkenf.com");
		
		dao.insert(vo);
	}
}
