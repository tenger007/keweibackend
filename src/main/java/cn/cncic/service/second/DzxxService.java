package cn.cncic.service.second;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.cncic.models.second.Hx_kwmis_dzxx;
import cn.cncic.models.second.Hx_kwmis_dzxx_chart;
import cn.cncic.models.second.Main_techlevel1;
import cn.cncic.models.second.Main_techlevel2;
import cn.cncic.models.second.Main_techlevel3;
import cn.cncic.models.second.Main_techlevel4;

@Service
public class DzxxService {
	@Resource
	private DzxxRepository dzxxRepository;
	
	@Transactional
	//根据技术点的关键词查找对应的科委课题并分页
	public Page<Hx_kwmis_dzxx> getAllByJsd_keyword(int page,int size,String jsd_keyword){
		Pageable pageable =(Pageable) new PageRequest(page, size);
	 return	dzxxRepository.getAllByJsd_keyword(jsd_keyword,pageable);
	}
	
	//根据技术点的关键词查找对应的科委课题总数，总预算，总实际预算
	public List<Hx_kwmis_dzxx_chart> getChartByJsd_keyword(String jsd_keyword,int startyear,int endyear){
		List<Hx_kwmis_dzxx_chart> hx_kwmis_dzxx_charts = new ArrayList<Hx_kwmis_dzxx_chart>();
		for (int i = startyear; i <= endyear; i++) {
			Hx_kwmis_dzxx_chart hx_kwmis_dzxx_chart = new Hx_kwmis_dzxx_chart();
			List chartByJsd_keyword = dzxxRepository.getChartByJsd_keyword(jsd_keyword, i);
			hx_kwmis_dzxx_chart = (Hx_kwmis_dzxx_chart) chartByJsd_keyword.get(0);
			hx_kwmis_dzxx_charts.add(hx_kwmis_dzxx_chart);
		}
		return	hx_kwmis_dzxx_charts;
	}
	//根据技术点的1级标签名查找对应的科委课题总数，总预算，总实际预算
	public List<Hx_kwmis_dzxx_chart> getChartByMain_techlevel1(String main_techlevel1,int startyear,int endyear){
		List<Hx_kwmis_dzxx_chart> hx_kwmis_dzxx_charts = new ArrayList<Hx_kwmis_dzxx_chart>();
		for (int i = startyear; i <= endyear; i++) {
			Hx_kwmis_dzxx_chart hx_kwmis_dzxx_chart = new Hx_kwmis_dzxx_chart();
			List chartByJsd_keyword = dzxxRepository.getChartByMain_techlevel1(main_techlevel1, i);
			hx_kwmis_dzxx_chart = (Hx_kwmis_dzxx_chart) chartByJsd_keyword.get(0);
			hx_kwmis_dzxx_charts.add(hx_kwmis_dzxx_chart);
		}
		return	hx_kwmis_dzxx_charts;
	}
	//根据技术点的2级标签名查找对应的科委课题总数，总预算，总实际预算
	public List<Hx_kwmis_dzxx_chart> getChartByMain_techlevel2(String main_techlevel2,int startyear,int endyear){
		List<Hx_kwmis_dzxx_chart> hx_kwmis_dzxx_charts = new ArrayList<Hx_kwmis_dzxx_chart>();
		for (int i = startyear; i <= endyear; i++) {
			Hx_kwmis_dzxx_chart hx_kwmis_dzxx_chart = new Hx_kwmis_dzxx_chart();
			List chartByJsd_keyword = dzxxRepository.getChartByMain_techlevel2(main_techlevel2, i);
			hx_kwmis_dzxx_chart = (Hx_kwmis_dzxx_chart) chartByJsd_keyword.get(0);
			hx_kwmis_dzxx_charts.add(hx_kwmis_dzxx_chart);
		}
		return	hx_kwmis_dzxx_charts;
	}
	//根据技术点的3级标签名查找对应的科委课题总数，总预算，总实际预算
	public List<Hx_kwmis_dzxx_chart> getChartByMain_techlevel3(String Main_techlevel3,int startyear,int endyear){
		List<Hx_kwmis_dzxx_chart> hx_kwmis_dzxx_charts = new ArrayList<Hx_kwmis_dzxx_chart>();
		for (int i = startyear; i <= endyear; i++) {
			Hx_kwmis_dzxx_chart hx_kwmis_dzxx_chart = new Hx_kwmis_dzxx_chart();
			List chartByJsd_keyword = dzxxRepository.getChartByMain_techlevel3(Main_techlevel3, i);
			hx_kwmis_dzxx_chart = (Hx_kwmis_dzxx_chart) chartByJsd_keyword.get(0);
			hx_kwmis_dzxx_charts.add(hx_kwmis_dzxx_chart);
		}
		return	hx_kwmis_dzxx_charts;
	}
	//根据技术点的4级标签名查找对应的科委课题总数，总预算，总实际预算
	public List<Hx_kwmis_dzxx_chart> getChartByMain_techlevel4(String Main_techlevel4,int startyear,int endyear){
		List<Hx_kwmis_dzxx_chart> hx_kwmis_dzxx_charts = new ArrayList<Hx_kwmis_dzxx_chart>();
		for (int i = startyear; i <= endyear; i++) {
			Hx_kwmis_dzxx_chart hx_kwmis_dzxx_chart = new Hx_kwmis_dzxx_chart();
			List chartByJsd_keyword = dzxxRepository.getChartByMain_techlevel4(Main_techlevel4, i);
			hx_kwmis_dzxx_chart = (Hx_kwmis_dzxx_chart) chartByJsd_keyword.get(0);
			hx_kwmis_dzxx_charts.add(hx_kwmis_dzxx_chart);
		}
		return	hx_kwmis_dzxx_charts;
	}
	
	 //根据科委课题id查找具体的课题信息
	public Hx_kwmis_dzxx findByid(long id){
		return dzxxRepository.findById(id);
	}
	
	
	//查询各级标签对应的标签及项目名称
	public Main_techlevel1 findTechlevel(String fieldname,String year){
		Main_techlevel1 techlevel1 = new Main_techlevel1();
		int i = 0;
		techlevel1.setId(++i);
		techlevel1.setName(fieldname);
		techlevel1.setLevel1_prj_name(dzxxRepository.find_Main_techlevel1_subjName(fieldname, year));
		List<String> techlevel2 = dzxxRepository.find_main_techlevel2(fieldname);
		List<Main_techlevel2> techlevel22 = new ArrayList<Main_techlevel2>();
		for(String s2 :techlevel2){
			 List<String> techlevel3 = dzxxRepository.find_main_techlevel3(s2);
			 List<Main_techlevel3> techlevel33 = new ArrayList<Main_techlevel3>();
			for(String s : techlevel3){
				Main_techlevel3 techlevel32 = new Main_techlevel3();
				List<Main_techlevel4> techlevel41 = new ArrayList<Main_techlevel4>();
				List<String> techlevel4 = dzxxRepository.find_main_techlevel4(s);
				for(String s3:techlevel4){
					Main_techlevel4 techlevel42 = new Main_techlevel4();
					techlevel42.setId(++i);
					techlevel42.setLevel4prj_name(dzxxRepository.find_Main_techlevel4_subjName(s3, year));
					techlevel42.setName(s3);
					techlevel41.add(techlevel42);
				}
				techlevel32.setId(++i);
				techlevel32.setName(s);
				techlevel32.setLevel3prj_name(dzxxRepository.find_Main_techlevel3_subjName(s, year));
				techlevel32.setMain_techlevel4s(techlevel41);
				techlevel33.add(techlevel32);
			}
			Main_techlevel2 techlevel23 = new Main_techlevel2();
			techlevel23.setId(++i);
			techlevel23.setName(s2);
			techlevel23.setLevel2prj_name(dzxxRepository.find_Main_techlevel2_subjName(s2, year));
			techlevel23.setMain_techlevel3s(techlevel33);
			techlevel22.add(techlevel23);
		}
		
		techlevel1.setMain_techlevel2s(techlevel22);
		return techlevel1;
	}
	
	//根据各级标签名取对应的项目名称
	/*public List<String> find_Main_techlevel1_subjName(String level1name,String year){
		return dzxxRepository.find_Main_techlevel1_subjName(level1name,year);
	}
	public List<String> find_Main_techlevel2_subjName(String level2name,String year){
		return dzxxRepository.find_Main_techlevel2_subjName(level2name,year);
	}
	public List<String> find_Main_techlevel3_subjName(String level3name,String year){
		return dzxxRepository.find_Main_techlevel3_subjName(level3name,year);
	}
	public List<String> find_Main_techlevel4_subjName(String level4name,String year){
		return dzxxRepository.find_Main_techlevel4_subjName(level4name,year);
	}*/
	 
	//通过一级标签名查找对应的项课题
	public Page<Hx_kwmis_dzxx> find_subjname_level1(int page,int size,String level1,String year){
		Pageable pageable =(Pageable) new PageRequest(page, size);
		return dzxxRepository.getAllByLevel1(level1,year,pageable);
	}
	//通过二级标签名查找对应的项课题
	public Page<Hx_kwmis_dzxx> find_subjname_level2(int page,int size,String level2,String year){
		Pageable pageable =(Pageable) new PageRequest(page, size);
		return dzxxRepository.getAllByLevel2(level2,year,pageable);
	}
	//通过三级标签名查找对应的项课题
	public Page<Hx_kwmis_dzxx> find_subjname_level3(int page,int size,String level3,String year){
		Pageable pageable =(Pageable) new PageRequest(page, size);
		return dzxxRepository.getAllByLevel3(level3,year,pageable);
	}
	//通过四级标签名查找对应的项课题
	public Page<Hx_kwmis_dzxx> find_subjname_level4(int page,int size,String level4,String year){
		Pageable pageable =(Pageable) new PageRequest(page, size);
		return dzxxRepository.getAllByLevel4(level4,year,pageable);
	}
}