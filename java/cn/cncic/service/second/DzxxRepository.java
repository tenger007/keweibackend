package cn.cncic.service.second;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.cncic.models.second.Hx_kwmis_dzxx;
import cn.cncic.models.second.Hx_kwmis_dzxx_chart;


interface DzxxRepository extends PagingAndSortingRepository<Hx_kwmis_dzxx, Long>{
	
	//根据技术点的关键词查找对应的科委课题并分页
    @Query("select a from Hx_kwmis_dzxx a where subj_name like  CONCAT('%',?1, '%') and subj_zhgchsh ='电子信息与装备制造处'")
    Page<Hx_kwmis_dzxx> getAllByJsd_keyword(String subj_name,Pageable pageable);
    
    //根据技术点的关键词查找对应的科委课题总数，总预算，总实际预算
    @Query("select new cn.cncic.models.second.Hx_kwmis_dzxx_chart(count(prj_name)as count_prj,sum(kj_budget)as kj_budget,sum(budget)as budget)  from Hx_kwmis_dzxx a where subj_name like  CONCAT('%',?1, '%') and subj_zhgchsh ='电子信息与装备制造处' and begin_date like  CONCAT('%',?2, '%')")
    List getChartByJsd_keyword(String subj_name,int year);
    
    //根据一级标签名查找对应的科委课题总数，总预算，总实际预算
    @Query("select new cn.cncic.models.second.Hx_kwmis_dzxx_chart(count(prj_name)as count_prj,sum(kj_budget)as kj_budget,sum(budget)as budget)  from Hx_kwmis_dzxx a where main_techlevel1 =?1 and subj_zhgchsh ='电子信息与装备制造处' and begin_date like  CONCAT('%',?2, '%')")
    List getChartByMain_techlevel1(String Main_techlevel1,int year);
    //根据2级标签名查找对应的科委课题总数，总预算，总实际预算
    @Query("select new cn.cncic.models.second.Hx_kwmis_dzxx_chart(count(prj_name)as count_prj,sum(kj_budget)as kj_budget,sum(budget)as budget)  from Hx_kwmis_dzxx a where main_techlevel2 =?1 and subj_zhgchsh ='电子信息与装备制造处' and begin_date like  CONCAT('%',?2, '%')")
    List getChartByMain_techlevel2(String Main_techlevel2,int year);
    //根据3级标签名查找对应的科委课题总数，总预算，总实际预算
    @Query("select new cn.cncic.models.second.Hx_kwmis_dzxx_chart(count(prj_name)as count_prj,sum(kj_budget)as kj_budget,sum(budget)as budget)  from Hx_kwmis_dzxx a where main_techlevel3 =?1 and subj_zhgchsh ='电子信息与装备制造处' and begin_date like  CONCAT('%',?2, '%')")
    List getChartByMain_techlevel3(String Main_techlevel3,int year);
    //根据4级标签名查找对应的科委课题总数，总预算，总实际预算
    @Query("select new cn.cncic.models.second.Hx_kwmis_dzxx_chart(count(prj_name)as count_prj,sum(kj_budget)as kj_budget,sum(budget)as budget)  from Hx_kwmis_dzxx a where main_techlevel4 =?1 and subj_zhgchsh ='电子信息与装备制造处' and begin_date like  CONCAT('%',?2, '%')")
    List getChartByMain_techlevel4(String Main_techlevel4,int year);
    
    //根据科委课题id查找具体的课题信息
    Hx_kwmis_dzxx findById(long id);
    
    //查找标签一对应的项目
	@Query("select count(subj_name)  from Hx_kwmis_dzxx where  main_techlevel1 =?1 and begin_date like  CONCAT('%',?2, '%')")
    int find_Main_techlevel1_subjName(String level1name,String year);
	//查找标签二对应的项目
	@Query("select count(subj_name)  from Hx_kwmis_dzxx where  main_techlevel2 = ?1 and begin_date like  CONCAT('%',?2, '%')")
	int find_Main_techlevel2_subjName(String level2name,String year);
	//查找标签三对应的项目
	@Query("select count(subj_name)  from Hx_kwmis_dzxx where  main_techlevel3 = ?1 and begin_date like  CONCAT('%',?2, '%')")
	int find_Main_techlevel3_subjName(String level3name,String year);
	//查找标签四对应的项目
	@Query("select count(subj_name)  from Hx_kwmis_dzxx where  main_techlevel4 = ?1 and begin_date like  CONCAT('%',?2, '%')")
	int find_Main_techlevel4_subjName(String level4name,String year);
	
	//通过一级标签名查找对应的项课题
	@Query("select a from Hx_kwmis_dzxx a where main_techlevel1 = ?1 and begin_date like  CONCAT('%',?2, '%')")
	 Page<Hx_kwmis_dzxx> getAllByLevel1(String level1,String year,Pageable pageable);
	 //通过二级标签名查找对应的项课题
	 @Query("select a from Hx_kwmis_dzxx a where main_techlevel2 = ?1 and begin_date like  CONCAT('%',?2, '%')")
	 Page<Hx_kwmis_dzxx> getAllByLevel2(String level2,String year,Pageable pageable);
	 //通过三级标签名查找对应的项课题
	 @Query("select a from Hx_kwmis_dzxx a where main_techlevel3 = ?1 and begin_date like  CONCAT('%',?2, '%')")
	 Page<Hx_kwmis_dzxx> getAllByLevel3(String level3,String year,Pageable pageable);
	 //通过四级标签名查找对应的项课题
	 @Query("select a from Hx_kwmis_dzxx a where main_techlevel4 = ?1 and begin_date like  CONCAT('%',?2, '%')")
	 Page<Hx_kwmis_dzxx> getAllByLevel4(String level4,String year,Pageable pageable);
	
    
	//查询标签一对应的标签二的所有名称
	@Query("select main_techlevel2 from Hx_kwmis_dzxx where main_techlevel1 = ?1 and main_techlevel2 is not null group by main_techlevel2")
	List<String> find_main_techlevel2(String fieldname);
	//查询标签二对应的标签三的所有名称
	@Query("select main_techlevel3 from Hx_kwmis_dzxx where main_techlevel2 = ?1 and main_techlevel3 is not null group by main_techlevel3")
	List<String> find_main_techlevel3(String level2name);
	//查询标签三对应的标签四的所有名称
	@Query("select main_techlevel4 from Hx_kwmis_dzxx where main_techlevel3 = ?1 and main_techlevel4 is not null group by main_techlevel4")
	List<String> find_main_techlevel4(String level3name);
}



