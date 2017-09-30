package cn.cncic.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import cn.cncic.models.Jigou;
import cn.cncic.models.Jishudian;
import cn.cncic.models.JishudianArticle;
import cn.cncic.models.JishudianDto;
import cn.cncic.models.JishudianListDto;
import cn.cncic.models.ScoreDto;
import cn.cncic.models.Source;
import cn.cncic.models.User;
//import cn.cncic.models.Zazhi;
import cn.cncic.models.ZazhiListDto;
import cn.cncic.models.Article;
import cn.cncic.models.ArticleListDto;
//import cn.cncic.models.Db;
import cn.cncic.models.DbListDto;
import cn.cncic.models.Expert;
import cn.cncic.models.FieldSource;
import cn.cncic.models.GenzongDto;
import cn.cncic.models.Institution;
import cn.cncic.models.JaDto;
import cn.cncic.models.JigouListDto;
import cn.cncic.service.ArticleService;
//import cn.cncic.service.DbService;
import cn.cncic.service.ExpertService;
import cn.cncic.service.InstitutionService;
//import cn.cncic.service.JigouService;
import cn.cncic.service.JishudianArticleService;
import cn.cncic.service.JishudianService;

import cn.cncic.service.SourceService;
//import cn.cncic.service.ZazhiService;


@RestController
@EnableAutoConfiguration
public class JishudianController{
	@Autowired
	private  JishudianService jishudianService;
	
	@Autowired
	private  InstitutionService institutionService;
	
	@Autowired
	private  ExpertService expertService;
	
	/*@Autowired
	private JigouService jigouService;
	
	@Autowired
	private ZazhiService zazhiService;
	
	@Autowired
	private DbService dbService;*/
	
	@Autowired
	private  ArticleService articleService;
	
	@Autowired
	private  JishudianArticleService jishduainArticleService;
	
	@Autowired
	private  SourceService sourceService;
	
	/*//测试
	@RequestMapping("/test")
	public List<JaDto> test(){
		return this.jishudianService.test(2, 1);
	}*/
	
	//----获取全部技术点信息
	@RequestMapping("/jishudians")
	public List<JishudianDto> getJishudians(){
		List<JishudianDto> jishudianDtos = new ArrayList<>();
		Iterable<Jishudian> iterableJishudians = this.jishudianService.findAll();
		for (Jishudian jishudian : iterableJishudians) {
			List<Long> articleIds = new ArrayList<>();
			List<Long> jigouIds = new ArrayList<>();
			List<Long> zazhiIds = new ArrayList<>();
			List<Long> dbIds = new ArrayList<>();
			List<Long> institutionIds = new ArrayList<>();
			List<Long> expertIds = new ArrayList<>();
			articleIds=this.articleService.findArticleIdsByJishudianId(jishudian.getId());
			jigouIds=this.articleService.findSourceIdsByJishudianIdAndType(jishudian.getId(), 0);
			zazhiIds=this.articleService.findSourceIdsByJishudianIdAndType(jishudian.getId(), 1);
			dbIds=this.articleService.findSourceIdsByJishudianIdAndType(jishudian.getId(), 2);
			institutionIds=this.institutionService.findInstitutionIdsByJishudianId(jishudian.getId());
			expertIds=this.expertService.findExpertIdsByJishudianId(jishudian.getId());
			 
			//时间戳日期格式化
			 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			 String date = format.format(jishudian.getUpdatetime());
			    
			//创建JishudianDto对象，用于转换需要的数据格式供前台显示
			JishudianDto jishudianDto=new JishudianDto(jishudian.getId(),jishudian.getName(),jishudian.getScore(),jishudian.getScorejigou(),jishudian.getScorezazhi(),jishudian.getScoredb(),jishudian.getScoreexpert(),date,jishudian.getFieldid(),articleIds,dbIds,institutionIds,expertIds,jigouIds,zazhiIds,jishudian.getInternational(),jishudian.getCivil(),jishudian.getDefinition());
			jishudianDtos.add(jishudianDto);
		}
		return jishudianDtos;
	}
	
	//----根据技术点ID获取一个技术点相关信息
	@RequestMapping("/jishudian/{id}")
	public JishudianDto getJishudian(@PathVariable("id") Long jishudianId){
		Jishudian jishudian = new Jishudian();
		jishudian = this.jishudianService.byId(jishudianId);

		List<Long> articleIds = new ArrayList<>();
		List<Long> jigouIds = new ArrayList<>();
		List<Long> zazhiIds = new ArrayList<>();
		List<Long> dbIds = new ArrayList<>();
		List<Long> institutionIds = new ArrayList<>();
		List<Long> expertIds = new ArrayList<>();
		articleIds=this.articleService.findArticleIdsByJishudianId(jishudianId);
		jigouIds=this.articleService.findSourceIdsByJishudianIdAndType(jishudianId, 0);
		zazhiIds=this.articleService.findSourceIdsByJishudianIdAndType(jishudianId, 1);
		dbIds=this.articleService.findSourceIdsByJishudianIdAndType(jishudianId, 2);
		institutionIds=this.institutionService.findInstitutionIdsByJishudianId(jishudianId);
		expertIds=this.expertService.findExpertIdsByJishudianId(jishudianId);

		//时间戳日期格式化
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    String date = format.format(jishudian.getUpdatetime());

		return new JishudianDto(jishudian.getId(),jishudian.getName(),jishudian.getScore(),jishudian.getScorejigou(),jishudian.getScorezazhi(),jishudian.getScoredb(),jishudian.getScoreexpert(), date,jishudian.getFieldid(),articleIds,dbIds,institutionIds,expertIds,jigouIds,zazhiIds,jishudian.getInternational(),jishudian.getCivil(),jishudian.getDefinition());
		
	}
	

	//----根据领域ID取机构+（文章--技术点）（机构与文章--技术点是一对多的二维数组的形式）
	@RequestMapping("/jishudianlist/jigou/{fieldId}")
	public List<JigouListDto> getJigousAndJshudians(@PathVariable("fieldId") long fieldId){

		List<JigouListDto> jigouListDtos = new ArrayList<>();
		
		List<JishudianListDto> jishudianListDtos = new ArrayList<>();
		
		List<ArticleListDto> articleListDtos = new ArrayList<>();
		
		
		List<Long> jigouIds = new ArrayList<>();
		
		jigouIds=this.jishudianService.getSourceIds(fieldId, 0);

		for(long jigouId : jigouIds){
			articleListDtos.clear ();
			List<Article> articleList=this.articleService.findBySourceidAndType(jigouId, 0);
			for(Article article : articleList){
				List<Jishudian> jishudianList=this.jishudianService.getJishudiansByArtcileId(article.getId(),fieldId);
				jishudianListDtos.clear ();
				for(Jishudian jishudian : jishudianList){
					JishudianListDto jishudianListDto=new JishudianListDto(jishudian.getId(),jishudian.getName(),jishudian.getFieldid(),jishudian.getYear(),jishudian.getNum());
					jishudianListDtos.add(jishudianListDto);
				}
				
				 ArrayList<JishudianListDto> jishudianListDtos1 = new ArrayList<JishudianListDto>(new HashSet<JishudianListDto>(jishudianListDtos));
				 ArticleListDto articleListDto=new ArticleListDto(article.getId(),article.getTitle(),article.getImg(),jishudianListDtos1);
				 articleListDtos.add(articleListDto);
			}
			
			 ArrayList<ArticleListDto> articleListDtos1 = new ArrayList<ArticleListDto>(new HashSet<ArticleListDto>(articleListDtos));
			 Source jigou=this.sourceService.byId(jigouId);
			 JigouListDto jigouListDto=new JigouListDto(jigou.getId(),jigou.getName(),jigou.getImg(),jigou.getSummary(),articleListDtos1);
			 jigouListDtos.add(jigouListDto);
		}

        return jigouListDtos;
	}
	
	
	//----根据领域ID取杂志+技术点（杂志与技术点是一对多的二维数组的形式）
	@RequestMapping("/jishudianlist/zazhi/{fieldId}")
	public List<ZazhiListDto> getZazhisAndJshudians(@PathVariable("fieldId") long fieldId){

		List<ZazhiListDto> zazhiListDtos = new ArrayList<>();
		
		List<JishudianListDto> jishudianListDtos = new ArrayList<>();
		
		List<Long> zazhiIds = new ArrayList<>();
		
		zazhiIds=this.jishudianService.getSourceIds(fieldId, 1);
		
		for(long zazhiId : zazhiIds){
			List<Jishudian> jishudianList=this.jishudianService.getJishudiansByFieldIdAndSourceId(fieldId, zazhiId);
			jishudianListDtos.clear ();
			for(Jishudian jishudian : jishudianList){
				System.out.println(jishudian.getId());
				JishudianListDto jishudianListDto=new JishudianListDto(jishudian.getId(),jishudian.getName(),jishudian.getFieldid(),jishudian.getYear(),jishudian.getNum());
				jishudianListDtos.add(jishudianListDto);
			}
			
			 ArrayList<JishudianListDto> jishudianListDtos1 = new ArrayList<JishudianListDto>(new HashSet<JishudianListDto>(jishudianListDtos));
			Source zazhi=this.sourceService.byId(zazhiId);
			ZazhiListDto zazhiListDto=new ZazhiListDto(zazhi.getId(),zazhi.getName(),zazhi.getImg(),zazhi.getSummary(),zazhi.getIfactor(),jishudianListDtos1);
			zazhiListDtos.add(zazhiListDto);
			
		}
	
        return zazhiListDtos;
	}
	
	
	//----根据领域ID取数据库+技术点（数据库与技术点是一对多的二维数组的形式）
	@RequestMapping("/jishudianlist/db/{fieldId}")
	public List<DbListDto> getDbsAndJshudians(@PathVariable("fieldId") long fieldId){

		List<DbListDto> dbListDtos = new ArrayList<>();
		
		List<JishudianListDto> jishudianListDtos = new ArrayList<>();
		
		List<Long> dbIds = new ArrayList<>();
		
		dbIds=this.jishudianService.getSourceIds(fieldId, 2);
		
		for(long dbId : dbIds){
			List<Jishudian> jishudianList=this.jishudianService.getJishudiansByFieldIdAndSourceId(fieldId, dbId);
			jishudianListDtos.clear ();
			for(Jishudian jishudian : jishudianList){
				System.out.println(jishudian.getId());
				JishudianListDto jishudianListDto=new JishudianListDto(jishudian.getId(),jishudian.getName(),jishudian.getFieldid(),jishudian.getYear(),jishudian.getNum());
				jishudianListDtos.add(jishudianListDto);
			}
			
			 ArrayList<JishudianListDto> jishudianListDtos1 = new ArrayList<JishudianListDto>(new HashSet<JishudianListDto>(jishudianListDtos));
			 Source db=this.sourceService.byId(dbId);
			 Set<FieldSource> fieldSources=db.getFieldSource();
			 List<String> dbFieldimgs = new ArrayList<>();
			 if (fieldSources != null && fieldSources.size() > 0) {
		    	for(FieldSource fieldSource : fieldSources){
		    		String dbFieldimg=fieldSource.getImg();
		    		dbFieldimgs.add(dbFieldimg);
		    	}
			}
			ArrayList<String> dbFieldimgs1 = new ArrayList<String>(new HashSet<String>(dbFieldimgs));
			DbListDto dbListDto=new DbListDto(db.getId(),db.getName(),dbFieldimgs1,db.getSummary(),jishudianListDtos1);
			dbListDtos.add(dbListDto);
			
		}
		
        return dbListDtos;
	}
	
	
	
	//----根据领域ID获取技术点相关信息前8个
	@RequestMapping("/jishudianfield/{fieldId}")
	public List<JishudianDto> getJishudianByField(@PathVariable("fieldId") Long fieldId){
		//return this.jishudianService.byFieldId(fieldId);
		List<JishudianDto> jishudianDtos = new ArrayList<>();
		Iterable<Jishudian> iterableJishudians = this.jishudianService.byFieldId(fieldId,1);
		for (Jishudian jishudian : iterableJishudians) {
			List<Long> articleIds = new ArrayList<>();
			List<Long> jigouIds = new ArrayList<>();
			List<Long> zazhiIds = new ArrayList<>();
			List<Long> dbIds = new ArrayList<>();
			List<Long> institutionIds = new ArrayList<>();
			List<Long> expertIds = new ArrayList<>();
			articleIds=this.articleService.findArticleIdsByJishudianId(jishudian.getId());
			jigouIds=this.articleService.findSourceIdsByJishudianIdAndType(jishudian.getId(), 0);
			zazhiIds=this.articleService.findSourceIdsByJishudianIdAndType(jishudian.getId(), 1);
			dbIds=this.articleService.findSourceIdsByJishudianIdAndType(jishudian.getId(), 2);
			institutionIds=this.institutionService.findInstitutionIdsByJishudianId(jishudian.getId());
			expertIds=this.expertService.findExpertIdsByJishudianId(jishudian.getId());
			 
			 //时间戳日期格式化
			 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			 String date = format.format(jishudian.getUpdatetime());
			 
			//创建JishudianDto对象，用于转换需要的数据格式供前台显示
			JishudianDto jishudianDto=new JishudianDto(jishudian.getId(),jishudian.getName(),jishudian.getScore(),jishudian.getScorejigou(),jishudian.getScorezazhi(),jishudian.getScoredb(),jishudian.getScoreexpert(),date,jishudian.getFieldid(),articleIds,dbIds,institutionIds,expertIds,jigouIds,zazhiIds,jishudian.getInternational(),jishudian.getCivil(),jishudian.getDefinition());
			jishudianDtos.add(jishudianDto);
		}
		return jishudianDtos;
	}

	
	//----根据领域ID获取技术点相关信息全部
	@RequestMapping("/jishudianfieldall/{fieldId}/{curpage}")
	public Page<Jishudian> getAllJishudianByField(@PathVariable("fieldId") Long fieldId,@PathVariable("curpage") int curpage){
		int pageSize=12;
		curpage=curpage-1;
		return this.jishudianService.byFieldIdAll(curpage,pageSize,fieldId, 1);
	}
	
	//更新某个技术点对应的分数
	@RequestMapping("/jishudianupdate/{jishudianId}")
	public void testUpdate(@PathVariable("jishudianId") Long jishudianId){
//		System.out.println(11);
		int score=0,scoreJigou=0,scoreZazhi=0,scoreDb=0,scoreExpert=0,articleJigouNum=0,articleZazhiNum=0;
		double weight=0.0,weight1=0.0,weightJigou=0.0,weightZazhi=0.0;
		Jishudian jishudian=this.jishudianService.byId(jishudianId);
		/*List<ScoreDto> scoreDtos=this.articleService.getArticleAndSourceByJishudianId(jishudianId);
		for(ScoreDto scoreDto : scoreDtos){
			if(scoreDto.getType()==0){
				articleJigouNum++;
				String realizetime=scoreDto.getRealizetime();
				if(realizetime.equals("两年以内")){
					weight=0.3;
				}else if(realizetime.equals("两到五年")){
					weight=0.5;
				}else if(realizetime.equals("五到十年")){
					weight=0.8;
				}else if(realizetime.equals("十年以上")){
					weight=1;
				}
//				System.out.println(weight);
				weightJigou+=weight;
			}else if(scoreDto.getType()==1){
				articleZazhiNum++;
//				long zazhiId=article.getSourceid();
//				Source zazhi=this.sourceService.byId(zazhiId);
				int factor=scoreDto.getFactor();
				if(factor==1){
					weight1=1;
				}else if(factor==2){
					weight1=0.9;
				}else if(factor==3){
					weight1=0.8;
				}else if(factor==4){
					weight1=0.7;
				}else if(factor==5){
					weight1=0.6;
				}
				weightZazhi+=weight1;
			}else if(scoreDto.getType()==2){//数据库有文章预测到则说明命中即得分
				scoreDb=10;
			}
		}*/
		
		//获取技术点相关文章并计算机构和杂志得分
//		Set<Article> articlesSet = jishudian.getArticles();
		Set<JishudianArticle> jishudianArticles = jishudian.getJishudianArticle();
		if (jishudianArticles != null && jishudianArticles.size() > 0) {
			for(JishudianArticle jishudianArticle : jishudianArticles){
				System.out.println(jishudianArticle.getArticle_id());
				Article article=new Article();
				if(jishudianArticle.getIsforecast()==1){//如果是预测文章则参与打分否则不参与打分
					
					article=this.articleService.byId(jishudianArticle.getArticle_id());
					if(article.getType()==0){
						articleJigouNum++;
						String realizetime=jishudianArticle.getRealizetime();
						if(realizetime.equals("两年以内")){
							weight=0.3;
						}else if(realizetime.equals("两到五年")){
							weight=0.5;
						}else if(realizetime.equals("五到十年")){
							weight=0.8;
						}else if(realizetime.equals("十年以上")){
							weight=1;
						}
						System.out.println(weight);
						weightJigou+=weight;
					}else if(article.getType()==1){
						articleZazhiNum++;
						long zazhiId=article.getSourceid();
						Source zazhi=this.sourceService.byId(zazhiId);
						int factor=zazhi.getFactor();
						if(factor==1){
							weight1=1;
						}else if(factor==2){
							weight1=0.9;
						}else if(factor==3){
							weight1=0.8;
						}else if(factor==4){
							weight1=0.7;
						}else if(factor==5){
							weight1=0.6;
						}
						weightZazhi+=weight1;
					}else if(article.getType()==2){//数据库有文章预测到则说明命中即得分
						scoreDb=10;
					}
				}
			}
		
//			System.out.println(articleJigouNum);
//			System.out.println(weightJigou);
			//机构和杂志得分计算
			scoreJigou=(int) (40*weightJigou/articleJigouNum);
			scoreZazhi=(int) (30*weightZazhi/articleZazhiNum);
//		}
		
		
		
		//专家得分
		int isqianyan=jishudian.getIsqianyan();
		if(isqianyan==1){
			scoreExpert=20;
		}else if(isqianyan==0){
			scoreExpert=0;
		}
		
		//计算总得分
		score=scoreJigou+scoreZazhi+scoreDb+scoreExpert;
		
		
	   //更新数据库中技术点各个得分
	   this.jishudianService.updateScorejigou(jishudianId, scoreJigou);
	   this.jishudianService.updateScorezazhi(jishudianId, scoreZazhi);
	   this.jishudianService.updateScoredb(jishudianId, scoreDb);
	   this.jishudianService.updateScoreexpert(jishudianId, scoreExpert);
	   this.jishudianService.updateScore(jishudianId, score);
	   
		}
	}
	
	//更新所有技术点对应的分数
	@RequestMapping("/jishudianupdate")
	public void testUpdateAll(){
//		System.out.println(11);
		
		
		List<Jishudian> iterableJishudians = this.jishudianService.byIsqianyanjishudian(1);
		for (Jishudian jishudian : iterableJishudians) {
			int score=0,scoreJigou=0,scoreZazhi=0,scoreDb=0,scoreExpert=0,articleJigouNum=0,articleZazhiNum=0;
			double weight=0.0,weight1=0.0,weightJigou=0.0,weightZazhi=0.0;
//			int articleJigouNum=0,articleZazhiNum=0;
			long jishudianId=jishudian.getId();
			//Jishudian jishudian=this.jishudianService.byId(jishudianId);
			
			//获取技术点相关文章并计算机构和杂志得分
//			Set<Article> articlesSet = jishudian.getArticles();
			Set<JishudianArticle> jishudianArticles = jishudian.getJishudianArticle();
			if (jishudianArticles != null && jishudianArticles.size() > 0) {
				for(JishudianArticle jishudianArticle : jishudianArticles){
					if(jishudianArticle.getIsforecast()==1){//如果是预测文章则参与打分否则不参与打分
						Article article=new Article();
						article=this.articleService.byId(jishudianArticle.getArticle_id());
						//机构得分计算，通过文章数量加权获得权重
						if(article.getType()==0){
							articleJigouNum++;
							String realizetime=jishudianArticle.getRealizetime();
							if(realizetime.equals("两年以内")){
								weight=0.3;
							}else if(realizetime.equals("两到五年")){
								weight=0.5;
							}else if(realizetime.equals("五到十年")){
								weight=0.8;
							}else if(realizetime.equals("十年以上")){
								weight=1;
							}
							weightJigou+=weight;
						}else if(article.getType()==1){//杂志得分计算，通过获得相关杂志和其影响因子获得权重
							articleZazhiNum++;
							long zazhiId=article.getSourceid();
							Source zazhi=this.sourceService.byId(zazhiId);
							int factor=zazhi.getFactor();
							if(factor==1){
								weight1=1;
							}else if(factor==2){
								weight1=0.9;
							}else if(factor==3){
								weight1=0.8;
							}else if(factor==4){
								weight1=0.7;
							}else if(factor==5){
								weight1=0.6;
							}
							
							weightZazhi+=weight1;
						}else if(article.getType()==2){//数据库有文章预测到则说明命中即得分
							scoreDb=10;
						}
					}
				}
				//机构和杂志得分计算
				scoreJigou=(int) (40*weightJigou/articleJigouNum);
				scoreZazhi=(int) (30*weightZazhi/articleZazhiNum);
//				System.out.println(scoreZazhi);
//				System.out.println(articleZazhiNum);
				
			}
			
			
			
			//专家得分
			int isqianyan=jishudian.getIsqianyan();
			if(isqianyan==1){
				scoreExpert=20;
			}else if(isqianyan==0){
				scoreExpert=0;
			}
			
			//计算总得分
			score=scoreJigou+scoreZazhi+scoreDb+scoreExpert;
			
			
		   //更新数据库中技术点各个得分
		   this.jishudianService.updateScorejigou(jishudianId, scoreJigou);
		   this.jishudianService.updateScorezazhi(jishudianId, scoreZazhi);
		   this.jishudianService.updateScoredb(jishudianId, scoreDb);
		   this.jishudianService.updateScoreexpert(jishudianId, scoreExpert);
		   this.jishudianService.updateScore(jishudianId, score);
	   
		}
	}
	
	
	//----取某个领域下的前沿对应的所有机构ID
	@RequestMapping("/jigouIdsfield/{fieldId}")
	public List<Long> jigousField(@PathVariable("fieldId") Long fieldId){
		List<Long> jigouIds = new ArrayList<>();
		jigouIds=this.jishudianService.getSourceIds(fieldId, 0);
		return jigouIds;
	}
	
	//----取某个领域下的前沿对应的所有杂志ID
	@RequestMapping("/zazhiIdsfield/{fieldId}")
	public List<Long> zazhisField(@PathVariable("fieldId") Long fieldId){
		List<Long> zazhiIds = new ArrayList<>();
		zazhiIds=this.jishudianService.getSourceIds(fieldId, 1);
		return zazhiIds;
	}
	
	//----取某个领域下的前沿对应的所有数据库ID
	@RequestMapping("/dbIdsfield/{fieldId}")
	public List<Long> dbsField(@PathVariable("fieldId") Long fieldId){
		List<Long> dbIds = new ArrayList<>();
		dbIds=this.jishudianService.getSourceIds(fieldId, 2);
		return dbIds;
	}
	
	//----根据领域ID取前4个显示的跟踪技术点
	@RequestMapping("/genzongfield/{fieldId}")
	public List<GenzongDto> genzongsField(@PathVariable("fieldId") Long fieldId){
		List<GenzongDto> genzongs=new ArrayList<>();
		
		List<Jishudian> genzongjishudians= this.jishudianService.byFieldIdGenzong(fieldId,1);
		if (genzongjishudians != null && genzongjishudians.size() > 0) {
			for (Jishudian genzongjishudian : genzongjishudians) {
				GenzongDto genzongDto=new GenzongDto(genzongjishudian.getId(),genzongjishudian.getName(),genzongjishudian.getImg());
				genzongs.add(genzongDto);
			}
		}
		
		return genzongs;
		
	}
	
	@RequestMapping("/jishudianisqianyan")
	public List<Jishudian> jishudianisqianyan(){
		List<Jishudian> iterableJishudians = this.jishudianService.byIsqianyanjishudian(1);
		return  iterableJishudians;
	}
	
	@RequestMapping(value="/post3")
	/*public String post3(@RequestParam(value="name",required=true) String name,@RequestParam(value="pass",required=true) String pass){
//		reques.setCharacterEncoding("gbk");
		System.out.println(name);
		System.out.println(pass);
//		name="ccc";
		return name;
	}*/
	/*public String post3(HttpServletRequest request){
//		reques.setCharacterEncoding("gbk");
		String name = (String) request.getParameter("name");  
		String pass = (String) request.getParameter("pass") ;	
//		String json=request.getParameter("json");
//		System.out.println(name);
//		System.out.println(pass);
//		json="ccc";
//		name="ccc";
		return name;
	}*/
	
/*	public String post3(String name,String pass){
		System.out.println("userName is:"+name);  
        System.out.println("password is:"+pass);  
//        name="ccc";
        return name;
	}*/
	
	public String post3(User user){
		System.out.println("userName is:"+user.getName());  
        System.out.println("password is:"+user.getPass());  
//        name="ccc";
       String name= user.getName();
//       name="ccc";
        return name;
	}
	
	@RequestMapping(value="/postsearch/{jsdname}")
	public String postSearch(@PathVariable("jsdname") String jsdname){
		
        return jsdname;
	}
	
	//----查询所有跟踪技术点
	@RequestMapping("/genzongsall")
	public List<GenzongDto> genzongsAll(){
		List<GenzongDto> genzongs=new ArrayList<>();
		
		List<Jishudian> genzongjishudians= this.jishudianService.findAllGenzong(1);
		if (genzongjishudians != null && genzongjishudians.size() > 0) {
			for (Jishudian genzongjishudian : genzongjishudians) {
				GenzongDto genzongDto=new GenzongDto(genzongjishudian.getId(),genzongjishudian.getName(),genzongjishudian.getImg());
				genzongs.add(genzongDto);
			}
		}
		
		return genzongs;
		
	}
	
}
