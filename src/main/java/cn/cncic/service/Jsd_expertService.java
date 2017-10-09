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
public class Jsd_expertService {
	@Resource
	private Jsd_expertRepository jsd_expertRepository;

	public Page<Jsd_expert> getJsd_experts(int page,int size,String jsdname) {
		 Pageable pageable = (Pageable) new PageRequest(page, size);
		 Page<Jsd_expert> jsd_experts = jsd_expertRepository.findByJsdnameOrderByHIndexDesc(jsdname,pageable);
		 return jsd_experts;
	}

	public Jsd_expert getJsd_expert(long id) {
		return jsd_expertRepository.findById(id);
	}

	public Iterable<Jsd_expert> getAllJsd_experts(String jsdname) {
		return jsd_expertRepository.findByJsdnameOrderByHIndexDesc(jsdname);
	}

}