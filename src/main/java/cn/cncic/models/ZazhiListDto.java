package cn.cncic.models;

import java.util.ArrayList;
import java.util.List;

public class ZazhiListDto {
	
	private long id;	
	
	private String name;
	
	private String img;
	
	private String summary;
	
	private String ifactor;
	
	private List<JishudianListDto> jishudianListDtos = new ArrayList<>(); 
	
	
	public ZazhiListDto(long id, String name, String img,String summary,String ifactor,List<JishudianListDto> jishudianListDtos) {
		super();
		this.id = id;
		this.name=name;
		this.img=img;
		this.summary=summary;
		this.ifactor=ifactor;
		this.jishudianListDtos=jishudianListDtos;
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

	
	public String getIfactor() {
		return ifactor;
	}
	public void setIfactor(String ifactor) {
		this.ifactor = ifactor;
	}
	public List<JishudianListDto> getJishudianListDtos() {
		return jishudianListDtos;
	}

	public void setJishudianListDtos(List<JishudianListDto> jishudianListDtos) {
		this.jishudianListDtos = jishudianListDtos;
	}

	
}
