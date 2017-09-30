package cn.cncic.models.second;


public class Hx_kwmis_dzxx_chart {
	 private Long count_prj;
	 private Double kj_budget;
	 private Double budget;
	
	public Hx_kwmis_dzxx_chart(Long count_prj, Double kj_budget, Double budget) {
		super();
		this.count_prj = count_prj;
		this.kj_budget = kj_budget;
		this.budget = budget;
	}


	public Hx_kwmis_dzxx_chart(Long count_prj, Double kj_budget) {
		super();
		this.count_prj = count_prj;
		this.kj_budget = kj_budget;
	}


	public Hx_kwmis_dzxx_chart() {
		super();
	}

	public Long getCount_prj() {
		return count_prj;
	}
	public void setCount_prj(Long count_prj) {
		this.count_prj = count_prj;
	}
	public Double getKj_budget() {
		return kj_budget;
	}
	public void setKj_budget(Double kj_budget) {
		this.kj_budget = kj_budget;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	
	
}
