package cn.cncic.models;

import java.util.ArrayList;
import java.util.List;

public class DbListDto {
	
	private long id;	
	
	private String name;
	
	//领域预测图片
	private List<String> img;
	
	private String summary;
	
	private List<JishudianListDto> jishudianListDtos = new ArrayList<>(); 
	
	
	public DbListDto(long id, String name, List<String> img,String summary,List<JishudianListDto> jishudianListDtos) {
		super();
		this.id = id;
		this.name=name;
		this.img=img;
		this.summary=summary;
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

	public List<String> getImg() {
		return img;
	}
	public void setImg(List<String> img) {
		this.img = img;
	}
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<JishudianListDto> getJishudianListDtos() {
		return jishudianListDtos;
	}

	public void setJishudianListDtos(List<JishudianListDto> jishudianListDtos) {
		this.jishudianListDtos = jishudianListDtos;
	}

	
}
