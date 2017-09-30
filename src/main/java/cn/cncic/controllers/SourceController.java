package cn.cncic.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cncic.models.Source;
import cn.cncic.service.SourceService;


@RestController
public class SourceController {
	@Autowired
	private  SourceService sourceService;
	
	//根据来源ID获取来源信息
	 @RequestMapping("/source/{id}")
	 public Source getZazhi(@PathVariable("id") Long sourceId){
		 return this.sourceService.byId(sourceId);
	 }
	 
	 //根据多个来源ID获取多个来源信息
	 @RequestMapping("/sources/{ids}")
	 public Iterable<Source> getZazhisByIds(@PathVariable("ids") String sourceIds){
		return this.sourceService.findByIds(sourceIds);
	 }
	 
	 //获取全部来源信息
	 @RequestMapping("/sources")
	 public Iterable<Source> getZazhis(){
		 return this.sourceService.findAll();
	 }
}