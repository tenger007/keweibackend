package cn.cncic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cncic.models.Company;
import cn.cncic.models.Field;

@Service
public class CompanyService {
	@Autowired
	private CompanyRepository CompanyRepository;
	
	//根据技术点id查找相关机构坐标
		public List<Company> getCompanyByJsdname(String jsdname){
			return this.CompanyRepository.findCompanyByJsdname(jsdname);
		}
	
}