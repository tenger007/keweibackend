package cn.cncic.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Source {
	@Id
	private long id;	
	
	@NotNull
	@Size(max=64)
	private String name;
	
	@Size(max=255)
	private String img;
	
	private String summary;
	
	//杂志影响因子排名
	private int factor;
	
	//杂志影响因子
	private String ifactor;
	
	//来源类型（0：机构；1：杂志；2：数据库）
	private int sourcetype;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)//级联保存、更新、删除、刷新;延迟加载
	 @JoinColumn(name="source_id")//在book表增加一个外键列来实现一对多的单向关联
	private Set<FieldSource> FieldSource = new HashSet<FieldSource>(); 
	
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

	
	public Set<FieldSource> getFieldSource() {
		return FieldSource;
	}

	public void setFieldSource(Set<FieldSource> fieldSource) {
		FieldSource = fieldSource;
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

	public int getFactor() {
		return factor;
	}

	public void setFactor(int factor) {
		this.factor = factor;
	}

	public String getIfactor() {
		return ifactor;
	}

	public void setIfactor(String ifactor) {
		this.ifactor = ifactor;
	}

	public int getSourcetype() {
		return sourcetype;
	}

	public void setSourcetype(int sourcetype) {
		this.sourcetype = sourcetype;
	}

	/*public Set<FieldSource> getFieldSource() {
		return FieldSource;
	}

	public void setFieldSource(Set<FieldSource> fieldSource) {
		FieldSource = fieldSource;
	}
*/
	
	
}
