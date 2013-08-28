package com.web.codekin.member;

import java.util.List;

public interface MemberDAO {
	//나중에 제네릭dao로 변경?
	public void insert(MemberVO vo) throws Exception;
	public List<MemberVO> getAll() throws Exception;
	//임플리먼츠할필요가없네~
}
