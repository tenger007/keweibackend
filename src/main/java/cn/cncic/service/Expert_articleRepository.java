package cn.cncic.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.cncic.models.Apply;
import cn.cncic.models.Expert_article;
import cn.cncic.models.Jsd_expert;

@Repository
@Transactional
public interface Expert_articleRepository extends  PagingAndSortingRepository<Expert_article, Long>{

    @Query("select a from Expert_article a where jsd_expert_id = ?1 order by pub_year desc")
	Page<Expert_article> findByJsd_expert_id(Long jsd_expert_id, Pageable pageable);

	Expert_article findById(long id);
  
}
