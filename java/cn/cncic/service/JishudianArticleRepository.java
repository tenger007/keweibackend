package cn.cncic.service;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import cn.cncic.models.JishudianArticle;


interface JishudianArticleRepository extends CrudRepository<JishudianArticle, Long>{
	
	/*
	 * 通过技术点ID和文章ID获取唯一记录信息
	 */
	@Query("select ja from JishudianArticle ja where ja.jishudian_id=?1 and ja.article_id=?2")
	JishudianArticle getJishudianArticle(long jsdid,long artid);
}
