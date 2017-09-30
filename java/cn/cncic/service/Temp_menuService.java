package cn.cncic.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cncic.models.Apply;
import cn.cncic.models.Company;
import cn.cncic.models.Field;
import cn.cncic.models.Temp_menu;

@Service
public class Temp_menuService {
	@Resource
	private Temp_menuRepository temp_menuRepository;
	
	//获取模板菜单
	public List<Temp_menu> getTemp_menu(Integer applyid){
		return temp_menuRepository.findByApplyid(applyid);
	}

	public long getMaxId() {
		return temp_menuRepository.getMaxId();
		
	}

	public Temp_menu insert_tmenu(Temp_menu temp_menu) {
		
		return temp_menuRepository.save(temp_menu);
	}
	
}