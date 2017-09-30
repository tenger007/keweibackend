package cn.cncic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cncic.models.Field;

@Service
public class FieldService {
	@Autowired
	private FieldRepository fieldRepository;
	//private List<String> servers = new ArrayList<String>();
	
	public Field byId(long id){
		return this.fieldRepository.findById(id);
	}
	
	public Iterable<Field> findAll(){
		return this.fieldRepository.findAll();
	}
	
}