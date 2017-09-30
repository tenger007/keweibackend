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
public class Field {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) 
	//主键自增长是否需设置？
	private long id;
	
	@NotNull
	@Size(max=255)
	private String name;
	
	@NotNull
	@Size(max=255)
	private String icon;
	
	@NotNull
	@Size(max=255)
	private String icon1;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)//级联保存、更新、删除、刷新;延迟加载
	 @JoinColumn(name="field_id")//在book表增加一个外键列来实现一对多的单向关联
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
	
	public String getIcon() {
		return icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public String getIcon1() {
		return icon1;
	}

	public void setIcon1(String icon1) {
		this.icon1 = icon1;
	}

	public Set<FieldSource> getFieldSource() {
		return FieldSource;
	}

	public void setFieldSource(Set<FieldSource> fieldSource) {
		FieldSource = fieldSource;
	}
	
}
