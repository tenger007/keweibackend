package cn.cncic.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.cncic.models.Institution;

interface InstitutionRepository extends PagingAndSortingRepository<Institution, Long>{
	
	/*
	 * 通过技术点Id获取相关机构信息
	 */
	List<Institution> findByJishudianid(long jishudianid);
	
	/*
	 * 通过技术点ID获取相关机构IDs
	 */
	@Query("select id from Institution where jishudianid=?1 order by id asc")
	List<Long> findInstitutionIdsByjsdid(long jsdid);
}

