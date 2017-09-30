package cn.cncic.service;


import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.cncic.models.JaDto;
import cn.cncic.models.Jishudian;


interface JishudianRepository extends PagingAndSortingRepository<Jishudian, Long>{

	//List<Jishudian> findByFieldidOrderByScoreAsc(long fieldid,Pageable pageable);
	
	/*
	 * 查询某领域下的前沿技术点分数排名前8的
	 */
	List<Jishudian> findFirst8ByFieldidAndIsqianyanjishudianOrderByScoreDesc(long fieldid,int yorn);
	
	/*
	 * 通过分页的形式查询某领域下的所有前沿技术点
	 */
	Page<Jishudian> findByFieldidAndIsqianyanjishudian(long fieldid,int yorn,Pageable pageable);
	
	/*
	 * 查询某领域下的分数排名前4的技术点
	 */
	List<Jishudian> findFirst4ByFieldidAndIsgenzongjishudianOrderByScoreDesc(long fieldid,int yorn);
	
	/*
	 * 查询某领域下的跟踪技术点
	 */
	List<Jishudian> findByFieldidAndIsgenzongjishudian(long fieldid,int yorn);
	
	/*
	 * 查询所有跟踪技术点
	 */
	List<Jishudian> findByIsgenzongjishudian(int yorn);
	
	/*
	 * 查询是否是前沿的技术点
	 */
	List<Jishudian> findByIsqianyanjishudian(int yorn);
	
	/*//测试
	@Query("select   a.id as jsdid,b.title as artname from Jishudian a ,Article b,JishudianArticle c where a.id=c.jishudian_id and b.id=c.article_id and a.fieldid=?1 and b.type=?2 and a.isqianyanjishudian=1")
	List<JaDto> test(long fieldid,int type);*/
	
	/*
	 * 通过领域ID和类型（source type）获取该领域下的所有来源ID
	 */
	@Query("select  distinct b.sourceid from Jishudian a ,Article b,JishudianArticle c where a.id=c.jishudian_id and b.id=c.article_id and a.fieldid=?1 and b.type=?2 and a.isqianyanjishudian=1")
	List<Long> getSourceIdsByFieldIdAndType(long fieldid,int type);
	
	/*
	 * 通过领域ID和来源（source）ID获取技术点信息
	 */
	@Query("select  distinct a from Jishudian a ,Article b,JishudianArticle c where a.id=c.jishudian_id and b.id=c.article_id and a.fieldid=?1 and b.sourceid=?2 and a.isqianyanjishudian=1 order by a.id asc")
	List<Jishudian> getJishudiansByFieldIdAndSourceId(long fieldid,long sourceid);
	
	/*
	 * 通过文章ID获取预测技术点信息
	 */
	@Query("select  distinct a from Jishudian a ,Article b,JishudianArticle c where a.id=c.jishudian_id and b.id=c.article_id and b.id=?1 and a.isqianyanjishudian=1 and a.fieldid=?2 order by a.id asc")
	List<Jishudian> getJishudianByArticleId(long atrid,long fieldId);
	
	/*
	 * 更新技术点总得分
	 */
	@Query("UPDATE Jishudian jsd SET jsd.score=?2 WHERE jsd.id=?1")
	@Modifying
	@Transactional
	void updateScore(long jsdid, int score);
	
	/*
	 * 更新技术点-机构得分
	 */
	@Query("UPDATE Jishudian jsd SET jsd.scorejigou=?2 WHERE jsd.id=?1")
	@Modifying
	@Transactional
	void updateScorejigou(long jsdid, int score);
	
	/*
	 * 更新技术点-机构得分
	 */
	@Query("UPDATE Jishudian jsd SET jsd.scorezazhi=?2 WHERE jsd.id=?1")
	@Modifying
	@Transactional
	void updateScorezazhi(long jsdid, int score);
	
	/*
	 * 更新技术点-数据库得分
	 */
	@Query("UPDATE Jishudian jsd SET jsd.scoredb=?2 WHERE jsd.id=?1")
	@Modifying
	@Transactional
	void updateScoredb(long jsdid, int score);
	
	/*
	 * 更新技术点-专家库得分
	 */
	@Query("UPDATE Jishudian jsd SET jsd.scoreexpert=?2 WHERE jsd.id=?1")
	@Modifying
	@Transactional
	void updateScoreexpert(long jsdid, int score);
}