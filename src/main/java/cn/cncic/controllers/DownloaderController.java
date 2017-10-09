package cn.cncic.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cn.cncic.models.Article_Downloader;
import cn.cncic.service.DownloaderService;


@RestController
public class DownloaderController {
	@Autowired
	private DownloaderService downloaderService;
	
	@RequestMapping("/dzxx_dowmlader/{jsdName}/{curpage}")
	public Page<Article_Downloader> findArticle_DownloaderByJsdName(@PathVariable("jsdName") String jsdName,@PathVariable("curpage") int curpage){
		int pageSize=12;
		curpage=curpage-1;
		return downloaderService.getAllArticle_DownloaderByJsdName(curpage,pageSize,jsdName);	
	}	
	
	@RequestMapping("/dzxx_dowmladerById/{id}")
	public Article_Downloader findArticle_DownloaderById(@PathVariable("id")long id){
		return downloaderService.findArticle_DownloaderByid(id);
	}
	
}
