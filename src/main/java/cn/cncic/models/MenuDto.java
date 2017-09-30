package cn.cncic.models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class MenuDto {

	private long id;	
	

	private String name;
	
	private long jsdid;
	
	private long fid;
	
	private int level;
	
	private String code;

	private String url;
	
	private int isend;
	
	private int hasson;

	private List<Menu> children = new ArrayList<Menu>();
	
	
	public MenuDto(long id, String name, long jsdid, long fid, int level, String code, String url, int isend,
			int hasson, List<Menu> children) {
		super();
		this.id = id;
		this.name = name;
		this.jsdid = jsdid;
		this.fid = fid;
		this.level = level;
		this.code = code;
		this.url = url;
		this.isend = isend;
		this.hasson = hasson;
		this.children = children;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
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

	public long getJsdid() {
		return jsdid;
	}

	public void setJsdid(long jsdid) {
		this.jsdid = jsdid;
	}

	public long getFid() {
		return fid;
	}

	public void setFid(long fid) {
		this.fid = fid;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getIsend() {
		return isend;
	}

	public void setIsend(int isend) {
		this.isend = isend;
	}

	public int getHasson() {
		return hasson;
	}

	public void setHasson(int hasson) {
		this.hasson = hasson;
	}
	
	
	
}
