package org.thinker.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {
	
	
	@Inject
	private EmpDAO dao;
	

	public List<EmpVO> getAllEmpList() throws Exception{
		// TODO Auto-generated method stub
		return dao.getAll();
	}


	public void regist(EmpVO vo) throws Exception {

		dao.create(vo);
		
		dao.updateEmpViewCount(vo.getEmpno());

	}

}
