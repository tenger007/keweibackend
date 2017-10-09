package cn.cncic.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cncic.models.second.Hx_Natural_Fund_Project_chart;
import cn.cncic.models.second.Hx_jjb_sdkj_project_baseinfo;
import cn.cncic.models.second.Hx_kwmis_dzxx;
import cn.cncic.models.second.Hx_kwmis_dzxx_chart;
import cn.cncic.models.second.Main_techlevel1;
import cn.cncic.service.second.DzxxService;
import cn.cncic.service.second.Natural_Fund_ProjectService;


@RestController
public class Natural_Fund_ProjectController {
	@Autowired
	private Natural_Fund_ProjectService naturalService;
	
	@RequestMapping("/dzxx_natural/{jsd_keyword}/{curpage}")
	public Page<Hx_jjb_sdkj_project_baseinfo> findByJsd_keyword(@PathVariable("jsd_keyword") String jsd_keyword,@PathVariable("curpage") int curpage){
		int pageSize=12;
		curpage=curpage-1;
		return naturalService.getAllByJsd_keyword(curpage,pageSize,jsd_keyword);	
	}
	
	//根据技术点的关键词查找对应的自然基金课题总资助金额，项目类型，数量
	@RequestMapping("/dzxx_natural/{jsd_keyword}/{startyear}/{endyear}")
	public Object getChartByJsd_keyword(@PathVariable("jsd_keyword") String jsd_keyword,
			@PathVariable("startyear") int startyear,@PathVariable("endyear") int endyear){
		return naturalService.getChartByJsd_keyword(jsd_keyword,startyear,endyear);
	}
	
	@RequestMapping("/dzxx_naturalById/{id}")
	public Hx_jjb_sdkj_project_baseinfo findById(@PathVariable("id")long id){
		return naturalService.findByid(id);
	}
	
	
}
