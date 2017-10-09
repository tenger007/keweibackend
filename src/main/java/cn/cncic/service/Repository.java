package cn.cncic.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.cncic.models.Apply;
import cn.cncic.models.Company;


interface Repository extends PagingAndSortingRepository<Apply, Long>{
	
  //插入申请信息
	Apply save(Apply apply);

	//查找最新添加的申请id
	@Query("select max(id) from Apply")
	int findMaxId();
	
	
	

}



