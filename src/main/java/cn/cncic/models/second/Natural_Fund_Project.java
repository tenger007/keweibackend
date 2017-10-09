package cn.cncic.models.second;

public class Natural_Fund_Project {
  private String  proj_type;
  private Long count_proj;
  

  public Natural_Fund_Project(String proj_type, Long count_proj) {
	super();
	this.proj_type = proj_type;
	this.count_proj = count_proj;
}
  
public Natural_Fund_Project() {
	super();
	// TODO Auto-generated constructor stub
}

public String getProj_type() {
	return proj_type;
}
public void setProj_type(String proj_type) {
	this.proj_type = proj_type;
}
public Long getCount_proj() {
	return count_proj;
}
public void setCount_proj(Long count_proj) {
	this.count_proj = count_proj;
}
  

}
