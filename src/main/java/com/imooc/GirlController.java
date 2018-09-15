package com.imooc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GirlController {
	
	@Autowired
	private GirlRepository girlRepository;

	@Autowired
	private GirlService girlService;
	
	/**
	 * 查询所有女生列表
	 * @return
	 */
	@GetMapping(value="/girls")
	public List<Girl> girllist() {		
		return girlRepository.findAll();
	}
	
	/**
	 * 添加一个女生
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PostMapping(value="/girls")
	public Girl girlAdd(@RequestParam("cupSize") String cupSize,
			@RequestParam("age") Integer age) {
		
		Girl girl = new Girl();
		girl.setCupSize(cupSize);
		girl.setAge(age);
		
		return girlRepository.save(girl);
		}
	
	//查询一个女生
	@GetMapping(value="/girls/{id}")
	public Girl girlFindOne(@PathVariable("id") Integer id) {
	    Girl girl = girlRepository.getOne(id);
	    Integer girl_id = girl.getId();
	    String girl_cupSize = girl.getCupSize();
	    Integer girl_age = girl.getAge();

	    return new Girl(girl_id, girl_age, girl_cupSize);
	}
	
	//更新
	@PutMapping(value="/girls/{id}")
	public Girl GirlUpate(@PathVariable("id") Integer id,
			@RequestParam("cupSize") String cupSize,
			@RequestParam("age") Integer age) {
		Girl girl = new Girl();
		girl.setId(id);
		girl.setCupSize(cupSize);
		girl.setAge(age);
		
		return girlRepository.save(girl);
	}
	
	//删除
	@DeleteMapping(value="/girls/{id}")
	public void girlDelete(@PathVariable("id") Integer id) {
		girlRepository.deleteById(id);
	}
	
	//通过年龄查询女生列表
	@GetMapping(value="/girls/age/{age}")
	public List<Girl> girlListByAge(@PathVariable("age") Integer age){
		return girlRepository.findByAge(age);
	}
	
	@PostMapping(value="/girls/two")
	public void girlTwo() {
		girlService.insertTwo();
	}
	
}
