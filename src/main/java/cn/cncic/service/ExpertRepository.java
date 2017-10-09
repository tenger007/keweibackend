package cn.cncic.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.cncic.models.Expert;

interface ExpertRepository extends PagingAndSortingRepository<Expert, Long>{
	
	/*
	 * 通过技术点Id获取相关专家信息
	 */
	//List<Expert> findByJishudianid(long jishudianid);
	
	/*
	 * 通过技术点ID获取相关专家IDs
	 */
	/*@Query("select id from Expert where jishudianid=?1 order by id asc")
	List<Long> findExpertIdsByjsdid(long jsdid);*/
	
	//通过领域id查询专家文章信息
	List<Expert> findByFieldidOrderByPbdateDesc(long id);
}

