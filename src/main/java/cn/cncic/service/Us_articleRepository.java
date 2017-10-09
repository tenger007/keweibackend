package cn.cncic.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.cncic.models.Expert;
import cn.cncic.models.Jishudian;
import cn.cncic.models.Us_article;

interface Us_articleRepository extends PagingAndSortingRepository<Us_article, Long>{
	
	//通过技术点id查询美国文章信息 
	@Query("select a from Us_article a  where jsdname = ?1")
	Page<Us_article> findByjsdname(String jsdname,Pageable pageable);
	
}
