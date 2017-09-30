package cn.cncic.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class TestController {
	@RequestMapping("/")
	@ResponseBody
	String hello(){
		 return "hello world!";
	}
	public static void main(String[] args) {
		SpringApplication.run(TestController.class, args);
		
	}
	
}
