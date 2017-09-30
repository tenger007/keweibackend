package cn.cncic.models;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class FieldSource {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) 
	//主键自增长是否需设置？
	private long id;
	
	private String img;
	
	private String summary;
	
	private long field_id;
	private long source_id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public long getField_id() {
		return field_id;
	}
	public void setField_id(long field_id) {
		this.field_id = field_id;
	}
	public long getSource_id() {
		return source_id;
	}
	public void setSource_id(long source_id) {
		this.source_id = source_id;
	}

	
	
}
