package cn.cncic.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import cn.cncic.models.Source;


interface SourceRepository extends PagingAndSortingRepository<Source, Long>{
	
}