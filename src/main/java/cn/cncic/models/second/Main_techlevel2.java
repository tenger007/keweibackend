package cn.cncic.models.second;

import java.util.List;

public class Main_techlevel2 {
	private Integer id;
  private String name;
  private int level2prj_name;
  private List<Main_techlevel3> main_techlevel3s;
  
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
public List<Main_techlevel3> getMain_techlevel3s() {
	return main_techlevel3s;
}
public void setMain_techlevel3s(List<Main_techlevel3> main_techlevel3s) {
	this.main_techlevel3s = main_techlevel3s;
}
public int getLevel2prj_name() {
	return level2prj_name;
}
public void setLevel2prj_name(int level2prj_name) {
	this.level2prj_name = level2prj_name;
}
  
}
