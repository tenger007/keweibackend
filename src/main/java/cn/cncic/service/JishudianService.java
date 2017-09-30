package cn.cncic.service;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cncic.models.JaDto;
import cn.cncic.models.Jishudian;



@Service
public class JishudianService {
	@Autowired
	private JishudianRepository jishudianRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	public Jishudian byId(long id){
		return this.jishudianRepository.findOne(id);
	}
	
	public Iterable<Jishudian> findAll(){
		return this.jishudianRepository.findAll();
	}
	
	/*//测试
	public List<JaDto> test(long fieldid,int type){
		return  this.jishudianRepository.test(fieldid, type);
	}*/
	
	//获取所有前沿技术点
	public List<Jishudian> byIsqianyanjishudian(int yorn){
		return (List<Jishudian>) this.jishudianRepository.findByIsqianyanjishudian(yorn);
	}
	//某个领域下的前沿技术点前8个按照分数排序
	public List<Jishudian> byFieldId(long fieldId,int yorn){
		
		return (List<Jishudian>) this.jishudianRepository.findFirst8ByFieldidAndIsqianyanjishudianOrderByScoreDesc(fieldId,yorn);
	}
	
	//构建PageRequest
    private PageRequest buildPageRequest(int pageNumber, int pagzSize){
        return  new PageRequest(pageNumber - 1, pagzSize, null);
    }
    
	//某个领域下的所有前沿技术点
	/*public List<Jishudian> byFieldIdAll(int pageNumber,int pageSize,long fieldId,int yorn){
		
		return (List<Jishudian>) this.jishudianRepository.findByFieldidAndIsqianyanjishudian(fieldId,yorn);
	}*/
	
	public Page<Jishudian> byFieldIdAll(int page,int size,long fieldId,int yorn){
		    Sort sort = new Sort(Direction.DESC, "score");
		    Pageable pageable = (Pageable) new PageRequest(page, size, sort);
		    Page<Jishudian> pageJishuaidnList=(Page<Jishudian>) this.jishudianRepository.findByFieldidAndIsqianyanjishudian(fieldId,yorn,pageable);
		    return pageJishuaidnList;
	}
	
	
	
	//某个领域下的跟踪技术点前4个按照分数排序
	public List<Jishudian> byFieldIdGenzong(long fieldId,int yorn){
		
		return (List<Jishudian>) this.jishudianRepository.findFirst4ByFieldidAndIsgenzongjishudianOrderByScoreDesc(fieldId,yorn);
	}
	//某个领域下的所有跟踪技术点
	public List<Jishudian> byFieldIdAllGenzong(long fieldId,int yorn){
		
		return (List<Jishudian>) this.jishudianRepository.findByFieldidAndIsgenzongjishudian(fieldId,yorn);
	}
	
	//查询所有跟踪技术点列表
	public List<Jishudian> findAllGenzong(int yorn){
		return (List<Jishudian>) this.jishudianRepository.findByIsgenzongjishudian(yorn);
	}

	/*public Page<JishudianDto> byFieldIdLimit(long fieldId){
		Sort sort = new Sort(Direction.ASC, "id");
		PageRequest  pageable = new PageRequest(0, 2, sort);
		return  (Page<JishudianDto>) this.jishudianRepository.findByFieldidOrderByScoreDesc(fieldId,(Pageable) pageable);
	}*/
	
	//查询文章
	/*public  List<Article> getArticles(long jsdid){
		jsdid=1;
		return this.jishudianRepository.getArticleByJishudianId(jsdid);
	}*/
	/*public  List<Article> getArticles(long jsdid){
		jsdid=1;
		return this.articleRepository.getArticleByJishudianId(jsdid);
	}*/
	
	//通过领域ID和类型（source type）获取该领域下的所有来源ID
	public  List<Long> getSourceIds(long fieldid,int type){
		return this.jishudianRepository.getSourceIdsByFieldIdAndType(fieldid, type);
	}
	
	//通过领域ID和来源（source）ID获取技术点信息
	public  List<Jishudian> getJishudiansByFieldIdAndSourceId(long fieldid,long sourceid){
		return this.jishudianRepository.getJishudiansByFieldIdAndSourceId(fieldid, sourceid);
	}
	
	
	
	//通过文章ID获取预测技术点信息
	public  List<Jishudian> getJishudiansByArtcileId(long artid,long fieldId){
		return this.jishudianRepository.getJishudianByArticleId(artid,fieldId);
	}
	
	//更新技术点总得分
	public void updateScore(long jsdid, int score){
		this.jishudianRepository.updateScore(jsdid, score);
	}
	
	//更新技术点-机构得分
	public void updateScorejigou(long jsdid, int score){
		this.jishudianRepository.updateScorejigou(jsdid, score);
	}
	
	//更新技术点-杂志得分
	public void updateScorezazhi(long jsdid, int score){
		this.jishudianRepository.updateScorezazhi(jsdid, score);
	}
	
	//更新技术点-数据库得分
	public void updateScoredb(long jsdid, int score){
		this.jishudianRepository.updateScoredb(jsdid, score);
	}
	
	//更新技术点-数据库得分
	public void updateScoreexpert(long jsdid, int score){
		this.jishudianRepository.updateScoreexpert(jsdid, score);
	}
}