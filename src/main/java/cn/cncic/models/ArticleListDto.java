package cn.cncic.models;

import java.util.ArrayList;
import java.util.List;

public class ArticleListDto {
	
	private long id;
	private String title;
	private String img;
	private List<JishudianListDto> jishudianListDtos = new ArrayList<>(); 
	
	public ArticleListDto(long id, String title,String img,List<JishudianListDto> jishudianListDtos) {
		super();
		this.id = id;
		this.title = title;
		this.img=img;
		this.jishudianListDtos=jishudianListDtos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public List<JishudianListDto> getJishudianListDtos() {
		return jishudianListDtos;
	}

	public void setJishudianListDtos(List<JishudianListDto> jishudianListDtos) {
		this.jishudianListDtos = jishudianListDtos;
	}

	
	
}
