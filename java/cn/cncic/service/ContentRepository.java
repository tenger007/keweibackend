package cn.cncic.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.cncic.models.Content;
import cn.cncic.models.Menu;



interface ContentRepository extends PagingAndSortingRepository<Content, Long>{
	
	/*
	 * 通过技术点ID和菜单ID来查找内容
	 */
	Content findByJsdidAndMenuid(long jsdid,long menuid);

    /*
     * 通过技术点ID和菜单名称来查找内容
     */
	Content findByJsdidAndMenuname(long jsdid, String menuname);

	Iterable<Content> findByJsdid(long jsdid);
	
	
}