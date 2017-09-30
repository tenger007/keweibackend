package cn.cncic.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cncic.models.Expert_article;
import cn.cncic.models.Jsd_expert;
import cn.cncic.service.Expert_articleService;
import cn.cncic.service.Jsd_expertService;


@RestController
public class Jsd_expertController {
	@Autowired
	private Jsd_expertService jsd_expertService;
	@Autowired
	private Expert_articleService expert_articleService;
	
	//----根据技术点名称获取一个技术点相关专家信息
		@RequestMapping("/jsd_expert/{jsdname}/{curpage}")
		public Page<Jsd_expert> getJsd_experts(@PathVariable("jsdname") String jsdname,@PathVariable("curpage") int curpage){
			int pageSize=12;
			curpage=curpage-1;
			return jsd_expertService.getJsd_experts(curpage,pageSize,jsdname);
		}
	
		//----根据技术点名称获取一个技术点所有相关专家信息
		@RequestMapping("/jsd_experts/{jsdname}")
		public  Iterable<Jsd_expert> getAllJsd_experts(@PathVariable("jsdname") String jsdname){
			return jsd_expertService.getAllJsd_experts(jsdname);
		}
		
	//根据技术点专家信息id查询专家文章详细信息
		@RequestMapping("/jsd_expertById/{id}/{curpage}")
		public Page<Expert_article> getJsd_expert(@PathVariable("id") long id,@PathVariable("curpage") int curpage){
			int pageSize=12;
			curpage=curpage-1;
			return expert_articleService.getJsd_expert(curpage,pageSize,id);
		}
	
	//根据专家id查找专家信息
		@RequestMapping("/jsd_expertById/{id}")
		public Jsd_expert getExpert(@PathVariable("id") long id){
			return jsd_expertService.getJsd_expert(id);
		}
		
		//根据文章id查找文章详细信息
		@RequestMapping("/expert_articleById/{id}")
		public Expert_article getExpert_article(@PathVariable("id") long id){
			return expert_articleService.getExpert_article(id);
		}
		
}
