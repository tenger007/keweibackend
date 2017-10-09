package cn.cncic.models.second;

import java.util.List;

public class Main_techlevel1 {
 private Integer id;
  private String name;
  private int level1_prj_name;
  private List<Main_techlevel2> main_techlevel2s;
  
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Main_techlevel2> getMain_techlevel2s() {
	return main_techlevel2s;
}
public void setMain_techlevel2s(List<Main_techlevel2> main_techlevel2s) {
	this.main_techlevel2s = main_techlevel2s;
}
public int getLevel1_prj_name() {
	return level1_prj_name;
}
public void setLevel1_prj_name(int level1_prj_name) {
	this.level1_prj_name = level1_prj_name;
}
}
