package cn.cncic.models;

import java.util.ArrayList;
import java.util.List;

public class JaDto {
	
	private long jsdid;	
	
	private String artname;
	
	public JaDto(long jsdid, String artname) {
		super();
		this.jsdid = jsdid;
		this.artname=artname;
		
	}

	public long getJsdid() {
		return jsdid;
	}

	public void setJsdid(long jsdid) {
		this.jsdid = jsdid;
	}

	public String getArtname() {
		return artname;
	}

	public void setArtname(String artname) {
		this.artname = artname;
	}
	
	
}
