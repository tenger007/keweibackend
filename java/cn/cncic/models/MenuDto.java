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
	
	private List<MenuDto> children = new ArrayList<MenuDto>();
	
	
	public MenuDto(long id, String name, long jsdid, long fid, List<MenuDto> children) {
		super();
		this.id = id;
		this.name = name;
		this.jsdid = jsdid;
		this.fid = fid;
		this.children = children;
	}
  
	
	

	public MenuDto() {
		super();
	}




	public List<MenuDto> getChildren() {
		return children;
	}



	public void setChildren(List<MenuDto> children) {
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

	
}
