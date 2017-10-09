package cn.cncic.models.second;

import java.util.List;

public class Hx_Natural_Fund_Project_chart {
	 private Long count_prj;
	 private Double budget;
	private List<Natural_Fund_Project> natural_Fund_Projects;

	public Hx_Natural_Fund_Project_chart(Double budget) {
		super();
		this.budget = budget;
	}
	public Hx_Natural_Fund_Project_chart() {
		super();
	}
	
	public List<Natural_Fund_Project> getNatural_Fund_Projects() {
		return natural_Fund_Projects;
	}
	public void setNatural_Fund_Projects(List<Natural_Fund_Project> natural_Fund_Projects) {
		this.natural_Fund_Projects = natural_Fund_Projects;
	}
	public Long getCount_prj() {
		return count_prj;
	}
	public void setCount_prj(Long count_prj) {
		this.count_prj = count_prj;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	
	
}
