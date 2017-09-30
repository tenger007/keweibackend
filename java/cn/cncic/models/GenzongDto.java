package cn.cncic.models;

import java.util.ArrayList;
import java.util.List;

public class GenzongDto {
	
	private long id;
	private String name;
	private String img;
	private String keyword;
	
	public GenzongDto(long id, String name,String img,String keyword) {
		super();
		this.id = id;
		this.name = name;
		this.img=img;
		this.keyword=keyword;
	}

	
	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
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

	

}
