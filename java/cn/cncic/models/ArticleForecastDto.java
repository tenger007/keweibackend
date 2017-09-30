package cn.cncic.models;

import java.sql.Timestamp;

public class ArticleForecastDto {
	
	private long id;
	private String title;
	private Timestamp pbdate;
	private int type;
	private long sourceid;
	private String sourcename;
	private int isforecast;
	private String ifactor;
	
	public ArticleForecastDto(long id, String title,Timestamp pbdate,int type,long sourceid,String sourcename,int isforecast,String ifactor) {
		super();
		this.id = id;
		this.title = title;
		this.pbdate=pbdate;
		this.type=type;
		this.sourceid=sourceid;
		this.sourcename=sourcename;
		this.isforecast=isforecast;
		this.ifactor=ifactor;
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

	
	public Timestamp getPbdate() {
		return pbdate;
	}

	public void setPbdate(Timestamp pbdate) {
		this.pbdate = pbdate;
	}

	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
	public long getSourceid() {
		return sourceid;
	}

	public void setSourceid(long sourceid) {
		this.sourceid = sourceid;
	}

	public String getSourcename() {
		return sourcename;
	}

	public void setSourcename(String sourcename) {
		this.sourcename = sourcename;
	}

	public int getIsforecast() {
		return isforecast;
	}

	public void setIsforecast(int isforecast) {
		this.isforecast = isforecast;
	}

	public String getIfactor() {
		return ifactor;
	}

	public void setIfactor(String ifactor) {
		this.ifactor = ifactor;
	}

	
	
	
}
