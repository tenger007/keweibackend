package cn.cncic.controllers;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cncic.models.GenzongDto;
import cn.cncic.models.Menu;
import cn.cncic.models.Content;
import cn.cncic.service.ContentService;



@RestController
public class ContentController {
	@Autowired
	private  ContentService contentService;
	
	//根据内容ID获取内容信息
	 @RequestMapping("/content/{id}")
	 public Content getMenu(@PathVariable("id") Long contentId){
		 return this.contentService.byId(contentId);
	 }
	 
	//添加菜单记录
	 @RequestMapping("/addcontent")
	 public int addContent(Content content){
		  this.contentService.saveContent(content);
		  return 1;
	 }
	
	 //通过技术点id和菜单id确定内容显示
	 @RequestMapping("/getcontent/{jsdid}/{menuid}")
	 public Content getContentByJsdidAndMenuid(@PathVariable("jsdid") Long jsdid,@PathVariable("menuid") Long menuid){
		 Content content=this.contentService.byJsdidAndMenuid(jsdid, menuid);
		  return content;
	 }
	 
	//通过技术点id和菜单name确定内容显示
		 @RequestMapping("/getcontents/{jsdid}/{menuname}")
		 public Content getContentByJsdidAndMenuname(@PathVariable("jsdid") Long jsdid,@PathVariable("menuname") String menuname) throws UnsupportedEncodingException{
			 Content content=this.contentService.byJsdidAndMenuname(jsdid, menuname);
			  return content;
		 }
}