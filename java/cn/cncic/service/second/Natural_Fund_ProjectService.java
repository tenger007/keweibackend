package cn.cncic.service.second;

import static org.assertj.core.api.Assertions.linesOf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import cn.cncic.models.Apply;
import cn.cncic.models.Company;
import cn.cncic.models.Field;
import cn.cncic.models.Jishudian;
import cn.cncic.models.second.Hx_Natural_Fund_Project_chart;
import cn.cncic.models.second.Hx_jjb_sdkj_project_baseinfo;
import cn.cncic.models.second.Hx_kwmis_dzxx;
import cn.cncic.models.second.Hx_kwmis_dzxx_chart;
import cn.cncic.models.second.Main_techlevel1;
import cn.cncic.models.second.Main_techlevel2;
import cn.cncic.models.second.Main_techlevel3;
import cn.cncic.models.second.Main_techlevel4;
import cn.cncic.models.second.Natural_Fund_Project;
import javassist.bytecode.LineNumberAttribute;

@Service
public class Natural_Fund_ProjectService {
	@Resource
	private Natural_Fund_ProjectRepository natural_Fund_ProjectRepository;
	
	@Transactional
	//根据技术点的关键词查找对应的科委课题并分页
	public Page<Hx_jjb_sdkj_project_baseinfo> getAllByJsd_keyword(int page,int size,String jsd_keyword){
		Pageable pageable =(Pageable) new PageRequest(page, size);
	 return	natural_Fund_ProjectRepository.getAllByJsd_keyword(jsd_keyword,pageable);
	}
	
	//根据技术点的关键词查找对应的科委课题总数，总预算，总实际预算
	public Object getChartByJsd_keyword(String jsd_keyword,int startyear,int endyear){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<String> proj_types =  natural_Fund_ProjectRepository.getAllProj_type();
		List<Hx_Natural_Fund_Project_chart> hx_kwmis_dzxx_charts = new ArrayList<Hx_Natural_Fund_Project_chart>();
		for (int i = startyear; i <= endyear; i++) {
			Hx_Natural_Fund_Project_chart hx_kwmis_dzxx_chart = new Hx_Natural_Fund_Project_chart();
			Double zz_amount = natural_Fund_ProjectRepository.getChartByJsd_keyword(jsd_keyword, String.valueOf(i));
			List<String> proj_Types = natural_Fund_ProjectRepository.getProj_TypeByJsd_keyword(jsd_keyword, String.valueOf(i));
			List<Natural_Fund_Project> natural_Fund_Projects = new ArrayList<Natural_Fund_Project>();
			for(String proj_type:proj_Types){
				Natural_Fund_Project natural_Fund_Project = new Natural_Fund_Project();
				Long proj = natural_Fund_ProjectRepository.getCount_ProjByJsd_keyword(jsd_keyword, String.valueOf(i), proj_type);
				natural_Fund_Project.setProj_type(proj_type);
				natural_Fund_Project.setCount_proj(proj);
				natural_Fund_Projects.add(natural_Fund_Project);
			}
			hx_kwmis_dzxx_chart.setNatural_Fund_Projects(natural_Fund_Projects);
			hx_kwmis_dzxx_chart.setBudget(zz_amount);
			hx_kwmis_dzxx_charts.add(hx_kwmis_dzxx_chart);
		}
		resultMap.put("list_natural_chart", hx_kwmis_dzxx_charts);
		resultMap.put("list_proj_type", proj_types);
		return	resultMap;
	}
	
	 //根据科委课题id查找具体的课题信息
	public Hx_jjb_sdkj_project_baseinfo findByid(long id){
		return natural_Fund_ProjectRepository.findById(id);
	}
}