package cn.cncic.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.cncic.models.Apply;
import cn.cncic.models.Article_Downloader;
import cn.cncic.models.Company;
import cn.cncic.models.Field;

@Service
public class DownloaderService {
	@Resource
	private DownloaderRepository downloaderRepository;
	
	@Transactional
	public Page<Article_Downloader> getAllArticle_DownloaderByJsdName(int curpage, int pageSize, String jsdName) {
		Pageable pageable =(Pageable) new PageRequest(curpage, pageSize);
		return downloaderRepository.getAllArticle_DownloaderByJsdName(jsdName,pageable);
	}

	public Article_Downloader findArticle_DownloaderByid(long id) {
		return downloaderRepository.findArticle_DownloaderByid(id);
	}
	
}