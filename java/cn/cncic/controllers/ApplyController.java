package cn.cncic.controllers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import cn.cncic.models.Apply;
import cn.cncic.models.Temp_menu;
import cn.cncic.service.ApplyService;
import cn.cncic.service.Temp_menuService;


@RestController
public class ApplyController {
	@Autowired
	private ApplyService applyService;
	@Autowired
	private Temp_menuService temp_menuService;
	
	@ResponseBody
	@RequestMapping(value = "save_apply", method = RequestMethod.POST)
	public Object saveApply(Apply apply,String menuspost,String menuidspost,String menufidspost){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Temp_menu> temp_menus = new ArrayList<Temp_menu>();
		Temp_menu temp_menu = new Temp_menu();
		try {
			 applyService.save(apply);
			 int apply_maxId = applyService.getMaxId();
			 String[] names = menuspost.split(",");
			 String[] ids = menuidspost.split(",");
			 String[] fids = menufidspost.split(",");
			 temp_menu.setId((long)0);
			 temp_menu.setName(names[0]);
			 temp_menu.setFid((long)0);
			 temp_menu.setApplyid(apply_maxId);
			 temp_menuService.insert_tmenu(temp_menu);
			 long tmenu_maxId = temp_menuService.getMaxId();
			 for(int i=1;i<names.length;i++){
				 Temp_menu temp_menu2 = new Temp_menu();
				 temp_menu2.setApplyid(apply_maxId);
				 temp_menu2.setFid(Long.parseLong(fids[i])+tmenu_maxId-1);
				 temp_menu2.setId(Long.parseLong(ids[i])+tmenu_maxId-1);
				 temp_menu2.setName(names[i]);
				 temp_menuService.insert_tmenu(temp_menu2);
			 }
			resultMap.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("success", false);
		}
		return resultMap;
		
	}
	
}
