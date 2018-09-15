package com.imooc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.GirlProperties;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
//	@Value("${cupSize}")
//	private String cupSize;
//	
//	@Value("${age}")
//	private Integer age;
//	
//	@Value("${content}")
//	private String content;
	
	@Autowired
	private GirlProperties girlProperties;

//	@RequestMapping(value = {"/hello","/hi"}, method = RequestMethod.GET)
	
	//从url中获取数值
//	@RequestMapping(value = "/say/{id}", method = RequestMethod.GET)
//	@RequestMapping(value = "/{id}/say", method = RequestMethod.GET)
//	public String say(@PathVariable("id") Integer myid) {
	@GetMapping(value="/say")
//	@RequestMapping(value = "/say", method = RequestMethod.GET)
	//RequestParam在这里是指定获取数值
	public String say(@RequestParam(value= "id", required = false , defaultValue = "0") Integer myid) {
//		return "Hello Spring Boot!";
//		return cupSize;
//		return cupSize + age;
//		return content;
//		return girlProperties.getCupSize();
		return "id: " + myid;
	}
}
