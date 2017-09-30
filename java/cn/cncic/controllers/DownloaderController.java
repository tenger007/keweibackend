package cn.cncic.controllers;


import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.DateAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sun.media.sound.MidiUtils.TempoCache;
import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.cncic.models.Apply;
import cn.cncic.models.Article;
import cn.cncic.models.Article_Downloader;
import cn.cncic.models.Temp_menu;
import cn.cncic.models.second.Hx_kwmis_dzxx;
import cn.cncic.service.ApplyService;
import cn.cncic.service.DownloaderService;
import cn.cncic.service.Temp_menuService;


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
