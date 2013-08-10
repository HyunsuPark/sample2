package org.thinker.dao;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EmpService {

	@Transactional( propagation = Propagation.REQUIRED,   isolation = Isolation.DEFAULT,   readOnly = true)
	public List<EmpVO> getAllEmpList()throws Exception;
	
	public void regist(EmpVO vo)throws Exception;
}
