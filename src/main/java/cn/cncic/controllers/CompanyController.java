package cn.cncic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cncic.models.Company;
import cn.cncic.models.Field;
import cn.cncic.service.CompanyService;
import cn.cncic.service.FieldService;

@RestController
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
    //根据技术点名名称查找相关机构坐标
		@RequestMapping("/company/{jsdname}")
		public List<Company> getCompanyByJsdid(@PathVariable("jsdname") String jsdname){
			return this.companyService.getCompanyByJsdname(jsdname);
		}
	
}
