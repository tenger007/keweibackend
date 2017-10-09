package cn.cncic.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cncic.models.Apply;
import cn.cncic.models.Company;
import cn.cncic.models.Field;

@Service
public class ApplyService {
	@Resource
	private ApplyRepository applyRepository;
	
	@Transactional
	//插入申请信息
	public void save(Apply apply){
	 	applyRepository.save(apply);
	}

	public int getMaxId() {
		return applyRepository.findMaxId();
	}
	
}