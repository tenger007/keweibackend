package cn.cncic.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Content {
	@Id
	private long id;	
	
	
	private long jsdid;
	
	private long menuid;
	
	private String contents;

	private String menuname;
	
	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getJsdid() {
		return jsdid;
	}

	public void setJsdid(long jsdid) {
		this.jsdid = jsdid;
	}

	public long getMenuid() {
		return menuid;
	}

	public void setMenuid(long menuid) {
		this.menuid = menuid;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	

	
	
	
	
}
