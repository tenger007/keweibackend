package cn.cncic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cncic.models.Institution;



@Service
public class InstitutionService {
	@Autowired
	private InstitutionRepository institutionRepository;
	
	public Institution byId(long id){
		return this.institutionRepository.findOne(id);
	}
	
	public Iterable<Institution> findAll(){
		return this.institutionRepository.findAll();
	}
	
	//通过技术点ID获取相关机构信息
	public List<Institution> findByJishudianId(long jishudianid){
		return this.institutionRepository.findByJishudianid(jishudianid);
	}
	
	//通过技术点ID获取相关机构IDs
	public List<Long> findInstitutionIdsByJishudianId(long jishudianid){
		return this.institutionRepository.findInstitutionIdsByjsdid(jishudianid);
	}
	
	//根据多个ID获取多个相关机构信息
	public Iterable<Institution> findByIds(String institutionIds){
		 String[] institutionIdsArray = institutionIds.split(",");
	    Iterable<Long> institutionIdsArray1 = new ArrayList<>();
	    for (int i = 0; i < institutionIdsArray.length; i++) {
	    	long jigouId=Long.parseLong(institutionIdsArray[i]);
	    	((ArrayList<Long>) institutionIdsArray1).add(jigouId);
	    }
	    
	    return   this.institutionRepository.findAll(institutionIdsArray1);
	    
	}
}