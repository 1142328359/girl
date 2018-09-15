package com.imooc;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

	@Autowired
	private GirlRepository girlRepository;
	

	@Transactional
	public void insertTwo() {
		
		Girl girlA = new Girl();
		girlA.setCupSize("A");
		girlA.setAge(16);
		girlRepository.save(girlA);
		
		Girl girlB = new Girl();
//		girlB.setCupSize("B");
		girlB.setCupSize("BBB");	//故意失败的测试
		girlB.setAge(17);
		girlRepository.save(girlB);
	}
}
