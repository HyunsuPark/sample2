package org.thinker.dao;

import java.util.List;

public interface EmpDAO {

	public List<EmpVO> getAll()throws Exception;	
	
	public EmpVO getEmp(Long empno)throws Exception;
	
	public void updateEmpViewCount(Long empno)throws Exception;
	
	public void create(EmpVO newVO)throws Exception;
	
	
}
