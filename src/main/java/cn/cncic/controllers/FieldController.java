package cn.cncic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cncic.models.Field;
import cn.cncic.service.FieldService;

@RestController
public class FieldController {
	@Autowired
	private  FieldService fieldService;
	
	//查询所有的领域项
	@RequestMapping("/fields")
	public Iterable<Field> getFields(){
		return this.fieldService.findAll();
	}
	
	//查询单个属性
	@RequestMapping("/field/{id}")
	public Field getField(@PathVariable("id") Long fieldId){
		return this.fieldService.byId(fieldId);
	}
	
	
}
