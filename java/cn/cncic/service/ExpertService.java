package cn.cncic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cncic.models.Expert;


@Service
public class ExpertService {
	@Autowired
	private ExpertRepository expertRepository;
	
	public Expert byId(long id){
		return this.expertRepository.findOne(id);
	}
	
	public Iterable<Expert> findAll(){
		return this.expertRepository.findAll();
	}
	//通过技术点ID获取相关专家信息
	/*public List<Expert> findByJishudianId(long jishudianid){
		return this.expertRepository.findByJishudianid(jishudianid);
	}*/
	
	//通过技术点ID获取相关专家IDs
	/*public List<Long> findExpertIdsByJishudianId(long jishudianid){
		return this.expertRepository.findExpertIdsByjsdid(jishudianid);
	}*/
	
	//通过领域id查询专家文章信息
	public	List<Expert> findByFieldid(long id){
		return expertRepository.findByFieldidOrderByPbdateDesc(id);
	}
	
	//根据多个ID获取多个相关机构信息
	public Iterable<Expert> findByIds(String expertIds){
		 String[] expertIdsArray = expertIds.split(",");
	    Iterable<Long> expertIdsArray1 = new ArrayList<>();
	    for (int i = 0; i < expertIdsArray.length; i++) {
	    	long jigouId=Long.parseLong(expertIdsArray[i]);
	    	((ArrayList<Long>) expertIdsArray1).add(jigouId);
	    }
	    
	    return   this.expertRepository.findAll(expertIdsArray1);
	    
	}
}