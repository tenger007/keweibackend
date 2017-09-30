package cn.cncic.controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cncic.models.Institution;
import cn.cncic.service.InstitutionService;
import scala.collection.immutable.Page;


@RestController
public class InstitutionController {
	@Autowired
	private  InstitutionService institutionService;
	
	//根据ID获取技术点相关机构信息
	 @RequestMapping("/institution/{id}")
	 public Institution getInstitution(@PathVariable("id") Long institutionId){
		 return this.institutionService.byId(institutionId);
	 }
	 
	 //获取全部相关机构信息
	 @RequestMapping("/institutions")
	 public Iterable<Institution> getInstitutions(){
		 return this.institutionService.findAll();
	 }
	 
	 //根据多个机构ID获取多个机构信息
	 @RequestMapping("/institutions/{ids}")
	 public Iterable<Institution> getJigousByIds(@PathVariable("ids") String institutionIds){
		return this.institutionService.findByIds(institutionIds);
	 }

	 //根据技术点ID获取相关机构的信息
	 @RequestMapping("/institutionsbyjishudianid/{jishudianId}")
	 public Iterable<Institution> getInstitutionsByJishudianIds(@PathVariable("jishudianId") long jishduianId){
		return this.institutionService.findByJishudianId(jishduianId);
	 }
	 
}