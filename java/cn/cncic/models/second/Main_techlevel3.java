package cn.cncic.models.second;

import java.util.List;

public class Main_techlevel3 {
	private Integer id;
  private String name;
  private int level3prj_name;
  private List<Main_techlevel4> main_techlevel4s;
  
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

public List<Main_techlevel4> getMain_techlevel4s() {
	return main_techlevel4s;
}
public void setMain_techlevel4s(List<Main_techlevel4> main_techlevel4s) {
	this.main_techlevel4s = main_techlevel4s;
}
public int getLevel3prj_name() {
	return level3prj_name;
}
public void setLevel3prj_name(int level3prj_name) {
	this.level3prj_name = level3prj_name;
}
  
}
