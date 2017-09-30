package cn.cncic.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.cncic.models.Apply;
import cn.cncic.models.Expert_article;
import cn.cncic.models.Jsd_expert;

@Repository
@Transactional
public interface Jsd_expertRepository extends  PagingAndSortingRepository<Jsd_expert, Long>{

	Page<Jsd_expert> findByJsdnameOrderByHIndexDesc(String jsdname,Pageable pageable);

	Jsd_expert findById(long id);

	Iterable<Jsd_expert> findByJsdnameOrderByHIndexDesc(String jsdname);
}
