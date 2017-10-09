package cn.cncic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cncic.models.Menu;
import cn.cncic.models.Source;


@Service
public class MenuService {
	@Autowired
	private MenuRepository menuRepository;
	
	public Menu byId(long id){
		return this.menuRepository.findOne(id);
	}
	
	public void saveMenu(Menu menu){
		this.menuRepository.save(menu);
		
	}
	
	//通过技术点id获取对应的菜单项
	public List<Menu> findMenuByJsdid(long jsdid){
		return this.menuRepository.findByJsdid(jsdid);
	}
	
	/*
	 * 通过技术点名称和菜单名称查询菜单
	 */
  public List<Menu> findByJsdidAndName(long jsdid,String name){
	  return this.menuRepository.findByJsdidAndName(jsdid, name);
  };
	
	//通过父菜单id获取子菜单信息
	public List<Menu> findMenuByFid(long fid){
		return this.menuRepository.findByFid(fid);
	}
	
	//通过jsdid、isend标记获取最末层菜单
	public List<Menu> findMenuByJsdidAndIsend(long jsdid,int yorn){
		return this.menuRepository.findByJsdidAndIsend(jsdid,yorn);
	}


}