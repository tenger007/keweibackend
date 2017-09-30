package cn.cncic.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class Temp_menu {
  @Id @GeneratedValue
  private Long id;
  private String name;
  private Long fid;
  private Integer applyid;
  @Transient
	private List<Temp_menu> childMenu=new ArrayList<Temp_menu>();
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Long getFid() {
	return fid;
}
public void setFid(Long fid) {
	this.fid = fid;
}
public Integer getApplyid() {
	return applyid;
}
public void setApplyid(Integer applyid) {
	this.applyid = applyid;
}
public List<Temp_menu> getChildMenu() {
	return childMenu;
}
public void setChildMenu(List<Temp_menu> childMenu) {
	this.childMenu = childMenu;
}

  
}
