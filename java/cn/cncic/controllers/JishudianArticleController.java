package cn.cncic.controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cncic.models.JishudianArticle;
import cn.cncic.service.JishudianArticleService;
import scala.collection.immutable.Page;


@RestController
public class JishudianArticleController {
	@Autowired
	private  JishudianArticleService jishudianArticleService;
	
	//根据技术点-文章中间表ID获取技术点-文章相关信息
	 @RequestMapping("/jishuidanArticle/{id}")
	 public JishudianArticle getJigou(@PathVariable("id") Long jishudianArticleId){
		 return this.jishudianArticleService.byId(jishudianArticleId);
	 }
	 
	/* //获取全部机构信息
	 @RequestMapping("/jigous")
	 public Iterable<Jigou> getJigous(){
		 return this.jigouService.findAll();
	 }
	 
	 //根据多个机构ID获取多个机构信息
	 @RequestMapping("/jigous/{ids}")
	 public Iterable<Jigou> getJigousByIds(@PathVariable("ids") String jigouIds){
		return this.jigouService.findByIds(jigouIds);
	 }
*/
	 
}