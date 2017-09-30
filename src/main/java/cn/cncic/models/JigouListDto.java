package cn.cncic.models;

import java.util.ArrayList;
import java.util.List;

public class JigouListDto {
	
	private long id;	
	
	private String name;
	
	private String img;
	
	private String summary;
	
	private List<ArticleListDto> articleListDtos = new ArrayList<>(); 
	
	
	public JigouListDto(long id, String name, String img,String summary,List<ArticleListDto> articleListDtos) {
		super();
		this.id = id;
		this.name=name;
		this.img=img;
		this.summary=summary;
		this.articleListDtos=articleListDtos;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	


	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<ArticleListDto> getArticleListDtos() {
		return articleListDtos;
	}
	public void setArticleListDtos(List<ArticleListDto> articleListDtos) {
		this.articleListDtos = articleListDtos;
	}

	
}
