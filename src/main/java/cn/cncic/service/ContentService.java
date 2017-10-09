package cn.cncic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cncic.models.Content;
import cn.cncic.models.Menu;



@Service
public class ContentService {
	@Autowired
	private ContentRepository contentRepository;
	
	public Content byId(long id){
		return this.contentRepository.findOne(id);
	}
	
	//保存表单内容
	public void saveContent(Content content){
		this.contentRepository.save(content);
		
	}
	
	//通过技术点id和菜单id确定内容显示
	public Content byJsdidAndMenuid(long jsdid,long menuid){
		return this.contentRepository.findByJsdidAndMenuid(jsdid, menuid);
	}
	
	//通过技术点id和菜单name确定内容显示
		public Content byJsdidAndMenuname(long jsdid,String menuname){
			return this.contentRepository.findByJsdidAndMenuname(jsdid, menuname);
		}
		//通过技术点id确定相关内容显示
		public Iterable<Content> byJsdid(long jsdid){
			return contentRepository.findByJsdid(jsdid);
		}

}