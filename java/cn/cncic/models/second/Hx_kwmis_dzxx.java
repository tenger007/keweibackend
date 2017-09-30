package cn.cncic.models.second;

import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;
@Entity
@Table(name = "hx_kwmis_dzxx")
public class Hx_kwmis_dzxx {
	 @Id
private long id;
 private String prj_name;
 private String prj_type;
 private String lx_year;
 private String main_unit;
 private String subj_code;
 private  int prj_id;
 private String subj_name;
 private Double budget;
 private Double kj_budget;
 private String subj_zhgchsh;
 private String jsly;
 private Date begin_date;
 private Date end_date;
 private String subj_renwu;
 private String subj_target;
 private String subj_ktyj;
 private String main_techlevel1;
 private String main_techlevel2;
 private String main_techlevel3;
 private String main_techlevel4;
 
 
public String getMain_techlevel1() {
	return main_techlevel1;
}
public void setMain_techlevel1(String main_techlevel1) {
	this.main_techlevel1 = main_techlevel1;
}
public String getMain_techlevel2() {
	return main_techlevel2;
}
public void setMain_techlevel2(String main_techlevel2) {
	this.main_techlevel2 = main_techlevel2;
}
public String getMain_techlevel3() {
	return main_techlevel3;
}
public void setMain_techlevel3(String main_techlevel3) {
	this.main_techlevel3 = main_techlevel3;
}
public String getMain_techlevel4() {
	return main_techlevel4;
}
public void setMain_techlevel4(String main_techlevel4) {
	this.main_techlevel4 = main_techlevel4;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getPrj_name() {
	return prj_name;
}
public void setPrj_name(String prj_name) {
	this.prj_name = prj_name;
}
public String getPrj_type() {
	return prj_type;
}
public void setPrj_type(String prj_type) {
	this.prj_type = prj_type;
}
public String getLx_year() {
	return lx_year;
}
public void setLx_year(String lx_year) {
	this.lx_year = lx_year;
}
public String getMain_unit() {
	return main_unit;
}
public void setMain_unit(String main_unit) {
	this.main_unit = main_unit;
}
public String getSubj_code() {
	return subj_code;
}
public void setSubj_code(String subj_code) {
	this.subj_code = subj_code;
}
public double getPrj_id() {
	return prj_id;
}
public void setPrj_id(int prj_id) {
	this.prj_id = prj_id;
}
public String getSubj_name() {
	return subj_name;
}
public void setSubj_name(String subj_name) {
	this.subj_name = subj_name;
}
public double getBudget() {
	return budget;
}
public void setBudget(double budget) {
	this.budget = budget;
}
public double getKj_budget() {
	return kj_budget;
}
public void setKj_budget(double kj_budget) {
	this.kj_budget = kj_budget;
}
public String getSubj_zhgchsh() {
	return subj_zhgchsh;
}
public void setSubj_zhgchsh(String subj_zhgchsh) {
	this.subj_zhgchsh = subj_zhgchsh;
}
public String getJsly() {
	return jsly;
}
public void setJsly(String jsly) {
	this.jsly = jsly;
}


public Date getBegin_date() {
	return begin_date;
}
public void setBegin_date(Date begin_date) {
	this.begin_date = begin_date;
}
public Date getEnd_date() {
	return end_date;
}
public void setEnd_date(Date end_date) {
	this.end_date = end_date;
}
public String getSubj_renwu() {
	return subj_renwu;
}
public void setSubj_renwu(String subj_renwu) {
	this.subj_renwu = subj_renwu;
}
public String getSubj_target() {
	return subj_target;
}
public void setSubj_target(String subj_target) {
	this.subj_target = subj_target;
}
public String getSubj_ktyj() {
	return subj_ktyj;
}
public void setSubj_ktyj(String subj_ktyj) {
	this.subj_ktyj = subj_ktyj;
}
 
 
	
	
}
