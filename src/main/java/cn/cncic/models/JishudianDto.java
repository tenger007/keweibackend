package cn.cncic.models;



//import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class JishudianDto {
	
	private long id;
	private long fid;
	private String img;
	private String name;
	private String keyword;
	private String enname;
	private double score;
	private double scorejigou;
	private double scorezazhi;
	private double scoredb;
	private double scoreexpert;
	private String updatetime;
	private long fieldid;
	private int isshow;
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
		
	private List<Jishudian> jishudians;

	public JishudianDto(long id,String img,Long fid, String name, String keyword,String enname, double score, double scorejigou, double scorezazhi, double scoredb,
			double scoreexpert, String updatetime, long fieldid, List<Long> articleIds, List<Long> dbIds,
			List<Long> institutionIds, List<Long> expertIds, List<Long> jigouIds, List<Long> zazhiIds,
			String international, String civil, String definition,List<Jishudian> jishudians) {
		super();
		this.id = id;
		this.fid=fid;
		this.img=img;
		this.name = name;
		this.keyword=keyword;
		this.enname = enname;
		this.score = score;
		this.scorejigou = scorejigou;
		this.scorezazhi = scorezazhi;
		this.scoredb = scoredb;
		this.scoreexpert = scoreexpert;
		this.updatetime = updatetime;
		this.fieldid = fieldid;
		this.articleIds = articleIds;
		this.dbIds = dbIds;
		this.institutionIds = institutionIds;
		this.expertIds = expertIds;
		this.jigouIds = jigouIds;
		this.zazhiIds = zazhiIds;
		this.international = international;
		this.civil = civil;
		this.definition = definition;
		this.jishudians=jishudians;
	}

	
	
	public JishudianDto(long id, long fid, String name, String enname, double score, double scorejigou, double scorezazhi,
			double scoredb, double scoreexpert, String updatetime, long fieldid, List<Long> articleIds, List<Long> dbIds,
			List<Long> institutionIds, List<Long> expertIds, List<Long> jigouIds, List<Long> zazhiIds,
			String international, String civil, String definition) {
		super();
		this.id = id;
		this.fid = fid;
		this.name = name;
		this.enname = enname;
		this.score = score;
		this.scorejigou = scorejigou;
		this.scorezazhi = scorezazhi;
		this.scoredb = scoredb;
		this.scoreexpert = scoreexpert;
		this.updatetime = updatetime;
		this.fieldid = fieldid;
		this.articleIds = articleIds;
		this.dbIds = dbIds;
		this.institutionIds = institutionIds;
		this.expertIds = expertIds;
		this.jigouIds = jigouIds;
		this.zazhiIds = zazhiIds;
		this.international = international;
		this.civil = civil;
		this.definition = definition;
	}


    
	public int getIsshow() {
		return isshow;
	}



	public void setIsshow(int isshow) {
		this.isshow = isshow;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public List<Jishudian> getJishudians() {
		return jishudians;
	}



	public String getKeyword() {
		return keyword;
	}



	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}



	public void setJishudians(List<Jishudian> jishudians) {
		this.jishudians = jishudians;
	}



	public long getFid() {
		return fid;
	}



	public void setFid(long fid) {
		this.fid = fid;
	}



	public String getEnname() {
		return enname;
	}



	public void setEnname(String enname) {
		this.enname = enname;
	}



	public JishudianDto() {
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

	

	

	public double getScore() {
		return score;
	}



	public void setScore(double score) {
		this.score = score;
	}



	public double getScorejigou() {
		return scorejigou;
	}



	public void setScorejigou(double scorejigou) {
		this.scorejigou = scorejigou;
	}



	public double getScorezazhi() {
		return scorezazhi;
	}



	public void setScorezazhi(double scorezazhi) {
		this.scorezazhi = scorezazhi;
	}



	public double getScoredb() {
		return scoredb;
	}



	public void setScoredb(double scoredb) {
		this.scoredb = scoredb;
	}



	public double getScoreexpert() {
		return scoreexpert;
	}



	public void setScoreexpert(double scoreexpert) {
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
