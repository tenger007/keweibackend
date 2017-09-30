package cn.cncic.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Institution {
	@Id
	private long id;	
	
	@NotNull
	@Size(max=255)
	private String name;

	@NotNull
	private long jishudianid;

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

	public long getJishudianid() {
		return jishudianid;
	}

	public void setJishudianid(long jishudianid) {
		this.jishudianid = jishudianid;
	}
	
	
	
	
	
}
