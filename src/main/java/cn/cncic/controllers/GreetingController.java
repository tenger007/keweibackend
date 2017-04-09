package cn.cncic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cncic.models.Book;
import cn.cncic.models.User;
import cn.cncic.service.BookService;
import cn.cncic.service.UserService;

@RestController
public class GreetingController {
	@Autowired
	private  BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/greeting")
	public String greeting(String name){
		return "hi!" + name;
	}
	
	@RequestMapping("/book")
	public Book getBook(){
		Book book = bookService.byId(1);
		
		return book;
	}
	
	@RequestMapping("/user")
	public User getUser(){
		User user = userService.byId(1);
		
		return user;
	}
}
