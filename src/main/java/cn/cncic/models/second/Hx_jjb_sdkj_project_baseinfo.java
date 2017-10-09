package cn.cncic.models.second;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Hx_jjb_sdkj_project_baseinfo {
	@Id @GeneratedValue
	private Long id;
	private String proj_type;//项目类型
	private String proj_name;//项目名称
	private String ytsys;//依托实验室
	private String start_year;//起止年月
	private String end_year;//起止年月
	private double amount;//申请金额
	private String subject;//报审学科组
	private String if_zizhu;//是否资助
	private double zz_amount;//	资助金额
	private String year;//项目年度
	private String applyer_name;//申请人姓名
	private String title;//职称
	private String top_xw;//最高学位
	private String xw_org;//学位授予单位
	private String org_name;//单位名称
	private String org_type;//单位类型
	private String be_part_of;//隶属关系
	private String postcode;//邮政编码
	private String proj_zhaiyao;//摘要
	private String proj_pre_result;//预期研究结果
	private String subject_2;//报审亚学科组
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProj_type() {
		return proj_type;
	}
	public void setProj_type(String proj_type) {
		this.proj_type = proj_type;
	}
	public String getProj_name() {
		return proj_name;
	}
	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}
	public String getYtsys() {
		return ytsys;
	}
	public void setYtsys(String ytsys) {
		this.ytsys = ytsys;
	}
	
	public String getStart_year() {
		return start_year;
	}
	public void setStart_year(String start_year) {
		this.start_year = start_year;
	}
	public String getEnd_year() {
		return end_year;
	}
	public void setEnd_year(String end_year) {
		this.end_year = end_year;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getIf_zizhu() {
		return if_zizhu;
	}
	public void setIf_zizhu(String if_zizhu) {
		this.if_zizhu = if_zizhu;
	}
	public double getZz_amount() {
		return zz_amount;
	}
	public void setZz_amount(double zz_amount) {
		this.zz_amount = zz_amount;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getApplyer_name() {
		return applyer_name;
	}
	public void setApplyer_name(String applyer_name) {
		this.applyer_name = applyer_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTop_xw() {
		return top_xw;
	}
	public void setTop_xw(String top_xw) {
		this.top_xw = top_xw;
	}
	public String getXw_org() {
		return xw_org;
	}
	public void setXw_org(String xw_org) {
		this.xw_org = xw_org;
	}
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public String getOrg_type() {
		return org_type;
	}
	public void setOrg_type(String org_type) {
		this.org_type = org_type;
	}
	public String getBe_part_of() {
		return be_part_of;
	}
	public void setBe_part_of(String be_part_of) {
		this.be_part_of = be_part_of;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getProj_zhaiyao() {
		return proj_zhaiyao;
	}
	public void setProj_zhaiyao(String proj_zhaiyao) {
		this.proj_zhaiyao = proj_zhaiyao;
	}
	public String getProj_pre_result() {
		return proj_pre_result;
	}
	public void setProj_pre_result(String proj_pre_result) {
		this.proj_pre_result = proj_pre_result;
	}
	public String getSubject_2() {
		return subject_2;
	}
	public void setSubject_2(String subject_2) {
		this.subject_2 = subject_2;
	}
	

}
 