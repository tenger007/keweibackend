package cn.cncic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import cn.cncic.models.Article;
import cn.cncic.models.ScoreDto;




@Service
public class ArticleService {
	@Autowired
	private ArticleRepository articleRepository;
	
	
	//根据文章ID获取文章信息
	public Article byId(long id){
		Article article = new Article();
		article = this.articleRepository.findOne(id);
		return article;

		//return this.jigouRepository.findOne(id);
	}
	
	//根据多个文章ID获取多个文章信息
	public Iterable<Article> findByIds(String articleIds){
		 String[] articleIdsArray = articleIds.split(",");
	    Iterable<Long> articleIdsArray1 = new ArrayList<>();
	    for (int i = 0; i < articleIdsArray.length; i++) {
	    	long articleId=Long.parseLong(articleIdsArray[i]);
	    	((ArrayList<Long>) articleIdsArray1).add(articleId);
	    }
	    
	    return  this.articleRepository.findAll(articleIdsArray1);
	    
	}
	
	//查询所有文章信息
	public Iterable<Article> findAll(){
		return this.articleRepository.findAll();
	}
	
	//根据sourceid和type查询文章信息
	public List<Article> findBySourceidAndType(long sourceid,int type){
		return (List<Article>) this.articleRepository.findBySourceidAndType(sourceid, type);
	}
	
	//通过技术点ID获取相关文章信息
	public List<Article> findByJishudianId(long jsdid){
		return  this.articleRepository.getArticleByJishudianId(jsdid);
	}
	
	//通过技术点ID获取相关文章IDs
	public List<Long> findArticleIdsByJishudianId(long jsdid){
		return  this.articleRepository.getArticleIdsByJishudianId(jsdid);
	}
	
	//通过技术点ID和文章来源类型获取文章来源IDs
	public List<Long> findSourceIdsByJishudianIdAndType(long jsdid,int type){
		return  this.articleRepository.getSourceIdsByJishudianIdAndType(jsdid, type);
	}
	
	//更新技术点分数用，通过技术点ID获取相应的文章中来源信息和预测年限
	public List<ScoreDto> getArticleAndSourceByJishudianId(long jsdid){
		return  this.articleRepository.getArticleAndSourceByJishudianId(jsdid);
	}
	
	
}