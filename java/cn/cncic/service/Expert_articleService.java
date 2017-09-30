package cn.cncic.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import cn.cncic.models.Apply;
import cn.cncic.models.Company;
import cn.cncic.models.Expert_article;
import cn.cncic.models.Field;
import cn.cncic.models.Jishudian;
import cn.cncic.models.Jsd_expert;

@Service
public class Expert_articleService {
	@Resource
	private Expert_articleRepository expert_articleRepository;

	public Page<Expert_article> getJsd_expert(int page,int size,long jsd_expert_id) {
		Pageable pageable = (Pageable) new PageRequest(page, size);
		return expert_articleRepository.findByJsd_expert_id(jsd_expert_id,pageable);
	}

	public Expert_article getExpert_article(long id) {
		return expert_articleRepository.findById(id);
	}
	
}