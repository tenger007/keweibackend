package cn.cncic.service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import cn.cncic.models.JishudianArticle;

import scala.collection.immutable.Page;


@Service
public class JishudianArticleService {
	@Autowired
	private JishudianArticleRepository jishudianArticleRepository;
	
	
	//根据技术点-文章中间表ID获取技术点-文章相关信息
	public JishudianArticle byId(long id){
		
		return this.jishudianArticleRepository.findOne(id);
		

		//return this.jigouRepository.findOne(id);
	}
	
	//查询所有技术点-文章中间表相关信息
	public Iterable<JishudianArticle> findAll(){
		return this.jishudianArticleRepository.findAll();
	}
	
	//根据多个技术点-文章ID获取多个技术点-文章相关信息
	public Iterable<JishudianArticle> findByIds(String jishudianArticleIds){
		 String[] jishudianArticleIdsArray = jishudianArticleIds.split(",");
	    Iterable<Long> jishudianArticleIdsArray1 = new ArrayList<>();
	    for (int i = 0; i < jishudianArticleIdsArray.length; i++) {
	    	long jishudianArticleId=Long.parseLong(jishudianArticleIdsArray[i]);
	    	((ArrayList<Long>) jishudianArticleIdsArray1).add(jishudianArticleId);
	    }
	    
	    return   this.jishudianArticleRepository.findAll(jishudianArticleIdsArray1);
	    
	}
	
	//根据多个技术点-文章ID获取多个技术点-文章相关信息
	public JishudianArticle findByJsdidAndArtid(long jsdid,long artid){
		return  this.jishudianArticleRepository.getJishudianArticle(jsdid, artid);
	}
}