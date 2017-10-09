package cn.cncic.service;

import java.util.List;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.cncic.models.Company;


interface CompanyRepository extends PagingAndSortingRepository<Company, Long>{
	

	//根据技术点名称查找所有的相关机构坐标
	List<Company> findCompanyByJsdname(String jsdname);

}



