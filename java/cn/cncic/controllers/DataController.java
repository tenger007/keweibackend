package cn.cncic.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cncic.models.second.Hx_kwmis_dzxx;
import cn.cncic.models.second.Hx_kwmis_dzxx_chart;
import cn.cncic.models.second.Main_techlevel1;
import cn.cncic.service.second.DzxxService;


@RestController
public class DataController {
	@Autowired
	private DzxxService dzxxService;
	
	@RequestMapping("/dzxx/{jsd_keyword}/{curpage}")
	public Page<Hx_kwmis_dzxx> findByJsd_keyword(@PathVariable("jsd_keyword") String jsd_keyword,@PathVariable("curpage") int curpage){
		int pageSize=12;
		curpage=curpage-1;
		return dzxxService.getAllByJsd_keyword(curpage,pageSize,jsd_keyword);	
	}
	
	//根据技术点的关键词查找对应的科委课题总数，总预算，总实际预算
	@RequestMapping("/dzxx/{jsd_keyword}/{startyear}/{endyear}")
	public List<Hx_kwmis_dzxx_chart> getChartByJsd_keyword(@PathVariable("jsd_keyword") String jsd_keyword,
			@PathVariable("startyear") int startyear,@PathVariable("endyear") int endyear){
		return dzxxService.getChartByJsd_keyword(jsd_keyword,startyear,endyear);
	}
	//根据技术点的1级标签名查找对应的科委课题总数，总预算，总实际预算
	@RequestMapping("/dzxx_Main_techlevel1/{jsd_keyword}/{startyear}/{endyear}")
	public List<Hx_kwmis_dzxx_chart> getChartByMain_techlevel1(@PathVariable("jsd_keyword") String jsd_keyword,
			@PathVariable("startyear") int startyear,@PathVariable("endyear") int endyear){
		return dzxxService.getChartByMain_techlevel1(jsd_keyword,startyear,endyear);
	}
	//根据技术点的2级标签名查找对应的科委课题总数，总预算，总实际预算
	@RequestMapping("/dzxx_Main_techlevel2/{jsd_keyword}/{startyear}/{endyear}")
	public List<Hx_kwmis_dzxx_chart> getChartByMain_techlevel2(@PathVariable("jsd_keyword") String jsd_keyword,
			@PathVariable("startyear") int startyear,@PathVariable("endyear") int endyear){
		return dzxxService.getChartByMain_techlevel2(jsd_keyword,startyear,endyear);
	}
	//根据技术点的3级标签名查找对应的科委课题总数，总预算，总实际预算
	@RequestMapping("/dzxx_Main_techlevel3/{jsd_keyword}/{startyear}/{endyear}")
	public List<Hx_kwmis_dzxx_chart> getChartByMain_techlevel3(@PathVariable("jsd_keyword") String jsd_keyword,
			@PathVariable("startyear") int startyear,@PathVariable("endyear") int endyear){
		return dzxxService.getChartByMain_techlevel3(jsd_keyword,startyear,endyear);
	}
	//根据技术点的4级标签名查找对应的科委课题总数，总预算，总实际预算
	@RequestMapping("/dzxx_Main_techlevel4/{jsd_keyword}/{startyear}/{endyear}")
	public List<Hx_kwmis_dzxx_chart> getChartByMain_techlevel4(@PathVariable("jsd_keyword") String jsd_keyword,
			@PathVariable("startyear") int startyear,@PathVariable("endyear") int endyear){
		return dzxxService.getChartByMain_techlevel4(jsd_keyword,startyear,endyear);
	}
	
	@RequestMapping("/dzxxById/{id}")
	public Hx_kwmis_dzxx findById(@PathVariable("id")long id){
		return dzxxService.findByid(id);
	}
	
	@RequestMapping("/mainfield/{fieldname}/{year}")
	public Main_techlevel1 findDzxx(@PathVariable("fieldname")String fieldname,@PathVariable("year")String year){
	return dzxxService.findTechlevel(fieldname,year);
	}
	
	@RequestMapping("/dzxxByLevel1/{level1}/{year}/{curpage}")
	public Page<Hx_kwmis_dzxx> findByLevel1(@PathVariable("level1")String level1,@PathVariable("year")String year,@PathVariable("curpage") int curpage){
		int pageSize=12;
		curpage=curpage-1;
		return dzxxService.find_subjname_level1(curpage, pageSize, level1,year);
	}
	
	@RequestMapping("/dzxxByLevel4/{level4}/{year}/{curpage}")
	public Page<Hx_kwmis_dzxx> findByLevel4(@PathVariable("level4")String level4,@PathVariable("year")String year,@PathVariable("curpage") int curpage){
		int pageSize=12;
		curpage=curpage-1;
		return dzxxService.find_subjname_level4(curpage, pageSize, level4,year);
	}
	
	@RequestMapping("/dzxxByLevel2/{level2}/{year}/{curpage}")
	public Page<Hx_kwmis_dzxx> findByLevel2(@PathVariable("level2")String level2,@PathVariable("year")String year,@PathVariable("curpage") int curpage){
		int pageSize=12;
		curpage=curpage-1;
		return dzxxService.find_subjname_level2(curpage, pageSize, level2,year);
	}
	
	@RequestMapping("/dzxxByLevel3/{level3}/{year}/{curpage}")
	public Page<Hx_kwmis_dzxx> findByLevel3(@PathVariable("level3")String level3,@PathVariable("year")String year,@PathVariable("curpage") int curpage){
		int pageSize=12;
		curpage=curpage-1;
		return dzxxService.find_subjname_level3(curpage, pageSize, level3,year);
	}
	
	
}
