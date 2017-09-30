package cn.cncic.controllers;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cn.cncic.models.Article;
import cn.cncic.models.ArticleForecastDto;
//import cn.cncic.models.ArticleDto;
import cn.cncic.models.Jishudian;
import cn.cncic.models.JishudianArticle;
import cn.cncic.models.Source;
import cn.cncic.service.ArticleService;
import cn.cncic.service.JishudianArticleService;
import cn.cncic.service.SourceService;

@RestController
public class ArticleController {
	@Autowired
	private  ArticleService articleService;
	
	@Autowired
	private  JishudianArticleService jishudianArticleService;
	
	@Autowired
	private  SourceService  sourceService;
	
	
	 // 根据文章ID获取文章信息
	 
	@RequestMapping("/article/{id}")
	public Article getArticle(@PathVariable("id") Long articleId){
		return this.articleService.byId(articleId);	
	}
	/*public ArticleDto getArticle(@PathVariable("id") Long articleId){
		Article article = new Article();
		article = this.articleService.byId(articleId);
		
		List<Long> jishudianIds = new ArrayList<>();
		Set<Jishudian> jishudians = article.getJishudians();
		if (jishudians != null && jishudians.size() > 0) {
			for(Jishudian jishudian : jishudians){
				jishudianIds.add(jishudian.getId());
			}
		}
		//jishudianIds数组去重
		 ArrayList<Long> jishudianIds1 = new ArrayList<Long>(new HashSet<Long>(jishudianIds));
		 
		 
		//时间戳日期格式化
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 String date = format.format(article.getPbdate());
		 
		return new ArticleDto(article.getId(), article.getSourceid(),article.getSourcename(), jishudianIds1,article.getTitle(),article.getAuthor(),article.getPdf(),article.getImg(),article.getSummary(),date,article.getType());
		
	}*/
	
	
	// 根据多个文章ID获取多篇文章信息
	 
	@RequestMapping("/articles/{ids}")
	public Iterable<Article> getArticlesByIds(@PathVariable("ids") String articleIds){
		return this.articleService.findByIds(articleIds);
	}
	/*public List<ArticleDto> getArticlesByIds(@PathVariable("ids") String articleIds){
		//String sourceStr = "1,2,3,4,5";
		List<ArticleDto> articleDtos = new ArrayList<>();
        String[] articleIdsArray = articleIds.split(",");
        
        for (int i = 0; i < articleIdsArray.length; i++) {
            //System.out.println(articleIdsArray[i]);
            long articleId=Long.parseLong(articleIdsArray[i]);
            Article article = new Article();
    		article = this.articleService.byId(articleId);
    		
    		List<Long> jishudianIds = new ArrayList<>();
    		Set<Jishudian> jishudians = article.getJishudians();
    		if (jishudians != null && jishudians.size() > 0) {
    			for(Jishudian jishudian : jishudians){
    				jishudianIds.add(jishudian.getId());
    			}
    		}
    		//jishudianIds数组去重
    		ArrayList<Long> jishudianIds1 = new ArrayList<Long>(new HashSet<Long>(jishudianIds));
   		 
    		//时间戳日期格式化
	   		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	   		 String date = format.format(article.getPbdate());
   		 
    		ArticleDto articleDto= new ArticleDto(article.getId(), article.getSourceid(),article.getSourcename(), jishudianIds1,article.getTitle(),article.getAuthor(),article.getPdf(),article.getImg(),article.getSummary(),date,article.getType());
    		articleDtos.add(articleDto);
        }
        
        return articleDtos;
	}*/
	
	//根据多个文章ID获取多篇文章信息并添加是否是相关文章字段值
	@RequestMapping("/articlesforecast/{ids}/{jishudianid}")
	public List<ArticleForecastDto> getArticlesByIds(@PathVariable("ids") String articleIds,@PathVariable("jishudianid") int jishudianId){
		 Iterable<Article> articles=this.articleService.findByIds(articleIds);
		 List<ArticleForecastDto> articleForecastDtos=new ArrayList<>();
			for(Article article : articles){
				int isforecast=1;
				JishudianArticle jishudianArticle=this.jishudianArticleService.findByJsdidAndArtid(jishudianId, article.getId());
				isforecast=jishudianArticle.getIsforecast();
				Source zazhi=this.sourceService.byId(article.getSourceid());
				String ifactor=zazhi.getIfactor();
				ArticleForecastDto articleForecastDto= new ArticleForecastDto(article.getId(), article.getTitle(),article.getPbdate(),article.getType(),article.getSourceid(),article.getSourcename(),isforecast,ifactor);
				articleForecastDtos.add(articleForecastDto);
			}
 		
		return articleForecastDtos;
	}
	
}