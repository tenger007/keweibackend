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
import cn.cncic.models.FieldSource;
import scala.collection.immutable.Page;


@Service
public class FieldSourceService {
	@Autowired
	private FieldSourceRepository fieldSourceRepository;
	
	
	//根据领域-来源中间表ID获取领域-来源相关信息
	public FieldSource byId(long id){
		
		return this.fieldSourceRepository.findOne(id);
		

		//return this.jigouRepository.findOne(id);
	}
	
	//查询所有领域-来源中间表相关信息
	public Iterable<FieldSource> findAll(){
		return this.fieldSourceRepository.findAll();
	}
	
	//根据多个领域-来源ID获取多个领域-来源相关信息
	public Iterable<FieldSource> findByIds(String fieldSourceIds){
		 String[] fieldSourceIdsArray = fieldSourceIds.split(",");
	    Iterable<Long> fieldSourceIdsArray1 = new ArrayList<>();
	    for (int i = 0; i < fieldSourceIdsArray.length; i++) {
	    	long fieldSourceId=Long.parseLong(fieldSourceIdsArray[i]);
	    	((ArrayList<Long>) fieldSourceIdsArray1).add(fieldSourceId);
	    }
	    
	    return   this.fieldSourceRepository.findAll(fieldSourceIdsArray1);
	    
	}
	
}