package cn.cncic.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Apply {
	@Id @GeneratedValue
	private int id;
	private long jsdid;
	private String jsdname;
	private String fieldname;
	private String jsd_describe;
	private String applicant;
	private String applicant_unit;
	private String tel;
	private int status;
	private Date apply_time;
	@Transient
	private List<Menu> menus;
	
	
	public Date getApply_time() {
		return apply_time;
	}
	public void setApply_time(Date apply_time) {
		this.apply_time = apply_time;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
	public String getFieldname() {
		return fieldname;
	}
	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getJsdid() {
		return jsdid;
	}
	public void setJsdid(long jsdid) {
		this.jsdid = jsdid;
	}
	public String getJsdname() {
		return jsdname;
	}
	public void setJsdname(String jsdname) {
		this.jsdname = jsdname;
	}
	public String getJsd_describe() {
		return jsd_describe;
	}
	public void setJsd_describe(String jsd_describe) {
		this.jsd_describe = jsd_describe;
	}
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getApplicant_unit() {
		return applicant_unit;
	}
	public void setApplicant_unit(String applicant_unit) {
		this.applicant_unit = applicant_unit;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	

}
 