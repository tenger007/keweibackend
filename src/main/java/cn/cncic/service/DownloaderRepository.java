package cn.cncic.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.cncic.models.Apply;
import cn.cncic.models.Article_Downloader;
import cn.cncic.models.Company;


interface DownloaderRepository extends PagingAndSortingRepository<Article_Downloader, Long>{
	
	//根据技术点名称查找对应的下载器文章并分页
    @Query("select a from Article_Downloader a where jsdname =?1 order by PublishedDateStr desc")
	Page<Article_Downloader> getAllArticle_DownloaderByJsdName(String jsdName, Pageable pageable);

	Article_Downloader findArticle_DownloaderByid(long id);
	
	
	

}



