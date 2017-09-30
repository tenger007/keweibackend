package cn.cncic.service.second;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.cncic.models.second.Hx_jjb_sdkj_project_baseinfo;
import cn.cncic.models.second.Hx_kwmis_dzxx;
import cn.cncic.models.second.Hx_kwmis_dzxx_chart;


interface Natural_Fund_ProjectRepository extends PagingAndSortingRepository<Hx_jjb_sdkj_project_baseinfo, Long>{
	
	//根据技术点的关键词查找对应的科委课题并分页
    @Query("select a from Hx_jjb_sdkj_project_baseinfo a where proj_name like  CONCAT('%',?1, '%')AND if_zizhu='是' AND SUBJECT='信息科学'")
    Page<Hx_jjb_sdkj_project_baseinfo> getAllByJsd_keyword(String subj_name,Pageable pageable);
    
    //根据技术点的关键词查找对应的自然基金项目总预算
    @Query("select sum(zz_amount)  from Hx_jjb_sdkj_project_baseinfo a where proj_name like  CONCAT('%',?1, '%')AND if_zizhu='是' AND SUBJECT='信息科学' and year like  CONCAT('%',?2, '%')")
    Double getChartByJsd_keyword(String subj_name,String year);
    
    //根据技术点的关键词查找对应的自然基金项目类型
    @Query("select proj_type  from Hx_jjb_sdkj_project_baseinfo a where proj_name like  CONCAT('%',?1, '%')AND if_zizhu='是' AND SUBJECT='信息科学' and year like  CONCAT('%',?2, '%') group by proj_type")
    List<String> getProj_TypeByJsd_keyword(String subj_name,String year);
    
    //根据技术点的关键词查找对应的自然基金项目类型对应的数量
    @Query("select count(proj_name)  from Hx_jjb_sdkj_project_baseinfo a where proj_name like  CONCAT('%',?1, '%')AND if_zizhu='是' AND SUBJECT='信息科学' and year like  CONCAT('%',?2, '%')"
    		+ "and proj_type = ?3")
    Long getCount_ProjByJsd_keyword(String subj_name,String year,String proj_type);
    
    //根据科委课题id查找具体的课题信息
    Hx_jjb_sdkj_project_baseinfo findById(long id);

    @Query("select proj_type from Hx_jjb_sdkj_project_baseinfo group by proj_type")
	List<String> getAllProj_type();
    
}



