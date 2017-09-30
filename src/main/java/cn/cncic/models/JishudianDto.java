package cn.cncic.models;



import java.sql.Timestamp;
//import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class JishudianDto {
	
	private long id;
	private String name;
	private int score;
	private int scorejigou;
	private int scorezazhi;
	private int scoredb;
	private int scoreexpert;
	private String updatetime;
	private long fieldid;
	
	//文章包含报告和文献
	private List<Long> articleIds = new ArrayList<>(); 
	
	private List<Long> dbIds = new ArrayList<>();

	private List<Long> institutionIds = new ArrayList<>();
	
	private List<Long> expertIds = new ArrayList<>();
	
	//与报告相关的机构id
	private List<Long> jigouIds=new ArrayList<>();
	
	//与文献相关的杂志id
	private List<Long> zazhiIds=new ArrayList<>();
	
	//技术点国际分布
	private String international;
	
	//技术点国内分布
	private String civil;
	
	//临时添加填充技术点打分页面空白内容
	private String definition;
		
	public JishudianDto(long id, String name, int score,int scorejigou,int scorezazhi,int scoredb,int scoreexpert,String updatetime,long fieldid,List<Long> articleIds,List<Long> dbIds,List<Long> institutionIds,List<Long> expertIds,List<Long> jigouIds,List<Long> zazhiIds,String international,String civil,String definition) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.scorejigou = scorejigou;
		this.scorezazhi = scorezazhi;
		this.scoredb = scoredb;
		this.scoreexpert = scoreexpert;
		this.updatetime = updatetime;
		this.fieldid=fieldid;
		this.articleIds = articleIds;
		this.dbIds = dbIds;
		this.institutionIds=institutionIds;
		this.expertIds=expertIds;
		this.jigouIds=jigouIds;
		this.zazhiIds=zazhiIds;
		this.international=international;
		this.civil=civil;
		this.definition=definition;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScorejigou() {
		return scorejigou;
	}

	public void setScorejigou(int scorejigou) {
		this.scorejigou = scorejigou;
	}

	public int getScorezazhi() {
		return scorezazhi;
	}

	public void setScorezazhi(int scorezazhi) {
		this.scorezazhi = scorezazhi;
	}

	public int getScoredb() {
		return scoredb;
	}

	public void setScoredb(int scoredb) {
		this.scoredb = scoredb;
	}

	public int getScoreexpert() {
		return scoreexpert;
	}

	public void setScoreexpert(int scoreexpert) {
		this.scoreexpert = scoreexpert;
	}

	

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public long getFieldid() {
		return fieldid;
	}

	public void setFieldid(long fieldid) {
		this.fieldid = fieldid;
	}

	public List<Long> getArticleIds() {
		return articleIds;
	}

	public void setArticleIds(List<Long> articleIds) {
		this.articleIds = articleIds;
	}

	public List<Long> getDbIds() {
		return dbIds;
	}

	public void setDbIds(List<Long> dbIds) {
		this.dbIds = dbIds;
	}

	public List<Long> getInstitutionIds() {
		return institutionIds;
	}

	public void setInstitutionIds(List<Long> institutionIds) {
		this.institutionIds = institutionIds;
	}

	public List<Long> getExpertIds() {
		return expertIds;
	}

	public void setExpertIds(List<Long> expertIds) {
		this.expertIds = expertIds;
	}

	public List<Long> getJigouIds() {
		return jigouIds;
	}

	public void setJigouIds(List<Long> jigouIds) {
		this.jigouIds = jigouIds;
	}

	public List<Long> getZazhiIds() {
		return zazhiIds;
	}

	public void setZazhiIds(List<Long> zazhiIds) {
		this.zazhiIds = zazhiIds;
	}

	public String getInternational() {
		return international;
	}

	public void setInternational(String international) {
		this.international = international;
	}

	public String getCivil() {
		return civil;
	}

	public void setCivil(String civil) {
		this.civil = civil;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}
	
	
}
