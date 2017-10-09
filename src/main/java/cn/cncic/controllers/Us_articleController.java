package cn.cncic.controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import cn.cncic.models.Expert;
import cn.cncic.models.Jishudian;
import cn.cncic.models.Us_article;
import cn.cncic.service.ExpertService;
import cn.cncic.service.Us_articleService;


@RestController
public class Us_articleController {
	@Autowired
	private  Us_articleService us_articleService;
	
	//根据jsdID获取美国科技文章相关信息
	 @RequestMapping("/us_article/{jsdname}/{curpage}")
	 public Page<Us_article> getUs_articlesByJsdid(@PathVariable("jsdname")String jsdname,@PathVariable("curpage") int curpage){
		 int pageSize=12;
			curpage=curpage-1;
		 return us_articleService.byJsdname(curpage,pageSize,jsdname);
	 }
	 
	 //根据，美国科技文章id查找文章的信息
	 @RequestMapping("/us_article/{id}")
	 public Us_article getUs_article(@PathVariable("id") long id){
		 return us_articleService.byId(id);
	 }
}