package cn.cncic.controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import cn.cncic.models.Expert;
import cn.cncic.service.ExpertService;
import scala.collection.immutable.Page;


@RestController
public class ExpertController {
	@Autowired
	private  ExpertService expertService;
	
	//根据ID获取专家相关信息
	 @RequestMapping("/expert/{id}")
	 public Expert getExpert(@PathVariable("id") Long expertId){
		 return this.expertService.byId(expertId);
	 }
	 
	 //获取全部相关机构信息
	 @RequestMapping("/experts")
	 public Iterable<Expert> getExperts(){
		 return this.expertService.findAll();
	 }
	 
	 //根据多个机构ID获取多个机构信息
	 @RequestMapping("/experts/{ids}")
	 public Iterable<Expert> getExpertsByIds(@PathVariable("ids") String expertIds){
		return this.expertService.findByIds(expertIds);
	 }

	 //根据技术点ID获取相关机构的信息
	/* @RequestMapping("/expertsbyjishudianid/{jishudianId}")
	 public Iterable<Expert> getExpertsByJishudianIds(@PathVariable("jishudianId") long jishduianId){
		return this.expertService.findByJishudianId(jishduianId);
	 }*/
	//通过领域id查询专家文章信息
	 @RequestMapping("/fieldExperts/{id}")
		List<Expert> findByFieldid(@PathVariable("id")long id){
		 return expertService.findByFieldid(id);
	 }
}