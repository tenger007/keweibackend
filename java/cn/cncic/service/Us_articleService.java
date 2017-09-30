package cn.cncic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import cn.cncic.models.Expert;
import cn.cncic.models.Jishudian;
import cn.cncic.models.Us_article;


@Service
public class Us_articleService {
	@Autowired
	private Us_articleRepository us_articleRepository;
	
	public Page<Us_article> byJsdname(int page,int size,String jsdname) {
		 Pageable pageable = (Pageable) new PageRequest(page, size);
		return us_articleRepository.findByjsdname(jsdname,pageable);
	}

	public Us_article byId(long id) {
		return us_articleRepository.findOne(id);
	}
	
}