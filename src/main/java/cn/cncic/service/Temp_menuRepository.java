package cn.cncic.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.cncic.models.Apply;
import cn.cncic.models.Company;
import cn.cncic.models.Temp_menu;
import java.lang.Integer;


interface Temp_menuRepository extends PagingAndSortingRepository<Temp_menu, Long>{
	
  //获取模板菜单
	List<Temp_menu> findByApplyid(Integer applyid);

	//获取模板菜单的最新id
	@Query("select Max(id) from Temp_menu")
	long getMaxId();

	
	Temp_menu save(Temp_menu temp_menu);
	
	
}



