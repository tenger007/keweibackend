package cn.cncic.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.cncic.models.Article;
import cn.cncic.models.ScoreDto;


interface ArticleRepository extends CrudRepository<Article, Long>{
	List<Article> findBySourceidAndType(long sourceid,int type);
	
	/*
	 * 通过技术点ID获取相关文章信息
	 */
	@Query("select  distinct b from Jishudian a ,Article b,JishudianArticle c where a.id=c.jishudian_id and b.id=c.article_id and a.id=?1 order by b.id")
	List<Article> getArticleByJishudianId(long jsdid);
	
	/*
	 * 通过技术点ID获取文章IDs
	 */
	@Query("select  distinct b.id from Jishudian a ,Article b,JishudianArticle c where a.id=c.jishudian_id and b.id=c.article_id and a.id=?1 order by b.id")
	List<Long> getArticleIdsByJishudianId(long jsdid);
	
	/*
	 * 通过技术点ID和文章来源类型获取文章来源IDs
	 */
	@Query("select  distinct b.sourceid from Jishudian a ,Article b,JishudianArticle c where a.id=c.jishudian_id and b.id=c.article_id and a.id=?1 and b.type=?2 order by b.sourceid")
	List<Long> getSourceIdsByJishudianIdAndType(long jsdid,int type);
	
	/*
	 * 更新技术点分数用，通过技术点ID获取相应的文章中来源信息和预测年限
	 */
	@Query("select  distinct c.realizetime,d.factor ,b.type from Jishudian a ,Article b,JishudianArticle c,Source d where a.id=c.jishudian_id and b.id=c.article_id and a.id=?1 and c.isforecast=1")
	List<ScoreDto> getArticleAndSourceByJishudianId(long jsdid);
	
}
