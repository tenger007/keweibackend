package cn.cncic.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cncic.models.Source;


@Service
public class SourceService {
	@Autowired
	private SourceRepository sourceRepository;
	
	public Source byId(long id){
		return this.sourceRepository.findOne(id);
	}
	
	public Iterable<Source> findAll(){
		return this.sourceRepository.findAll();
	}
	
	//根据多个来源 ID获取多个来源信息
	public Iterable<Source> findByIds(String sourceIds){
		 String[] sourceIdsArray = sourceIds.split(",");
	    Iterable<Long> sourceIdsArray1 = new ArrayList<>();
	    for (int i = 0; i < sourceIdsArray.length; i++) {
	    	long sourceId=Long.parseLong(sourceIdsArray[i]);
	    	((ArrayList<Long>) sourceIdsArray1).add(sourceId);
	    }
	    
	    return   this.sourceRepository.findAll(sourceIdsArray1);
	    
	}
}