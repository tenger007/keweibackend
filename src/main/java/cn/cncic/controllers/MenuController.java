package cn.cncic.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cncic.models.Menu;
import cn.cncic.models.MenuDto;
import cn.cncic.service.MenuService;



@RestController
public class MenuController {
	@Autowired
	private  MenuService menuService;
		
	 //根据技术点id获取该技术点对应的菜单信息
	 @RequestMapping("/menu/jsd/{jsdid}")
	 public List<MenuDto> getMuneByJsdid(@PathVariable("jsdid") Long jsdid){
		 List<Menu> menus=this.menuService.findMenuByJsdid(jsdid);
		 List<MenuDto> menusDto = new ArrayList<MenuDto>();
		 for(Menu menu : menus){
			 List<Menu> childMenus = new ArrayList<Menu>();
			 if(menu.getFid()==0){
				 childMenus = this.menuService.findMenuByFid(menu.getId());
				 MenuDto menuDto = new MenuDto(menu.getId(),menu.getName(),menu.getJsdid(),menu.getFid(),menu.getLevel(),menu.getCode(),menu.getUrl(),menu.getIsend(),menu.getHasson(),childMenus);
				 menusDto.add(menuDto);
			 }
			 
		 }
		  return menusDto;
	 }
	 
	 //根据父菜单id获取该菜单下的子菜单
	 @RequestMapping("/menu/sonmenu/{fid}")
	 public List<Menu> getSonmuneByMenuid(@PathVariable("fid") Long fid){
		 List<Menu> menus=this.menuService.findMenuByFid(fid);
		  return menus;
	 }
	 
	 
	//添加菜单记录
	 @RequestMapping("/addmenu")
	 public int addMenu(Menu menu){
		  this.menuService.saveMenu(menu);
		  return 1;
	 }
	 
	 //获取最末层菜单项
	 @RequestMapping("/endmenu/{jsdid}")
	 public List<Menu> getEndmune(@PathVariable("jsdid") Long jsdid){
		 List<Menu> menus=this.menuService.findMenuByJsdidAndIsend(jsdid,1);
		  return menus;
	 }

}