package cn.cncic.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.sql.Timestamp;
//import java.security.Timestamp;//会生成tinyblob类型数据
//import java.util.Date;//一般定义时间戳类型数据
import java.util.HashSet;
import java.util.Set;

@Entity
public class Jishudian{
	@Id
	private long id;
	
	@NotNull
	@Size(max=255)
	private String name;
	
	//技术点跟踪图片
	private String img;
		
		
	@NotNull
	private int score;
	
	private int scorejigou;
	private int scorezazhi;
	private int scoredb;
	private int scoreexpert;
	
	@NotNull
	private Timestamp updatetime;
	
	
	@NotNull
	private long fieldid;

	//技术点相关文章（文章包含报告和文献，报告和文献分别来源于机构和杂志）
	/*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "JISHUDIAN_ARTICLE", joinColumns = {
            @JoinColumn(name = "JISHUDIAN_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "ARTICLE_ID", referencedColumnName = "ID")})
    
	private Set<Article> articles = new HashSet<Article>();*/
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)//级联保存、更新、删除、刷新;延迟加载
	 @JoinColumn(name="jishudian_id")//在book表增加一个外键列来实现一对多的单向关联
//	 private Set<Book> books = new HashSet<Book>();
	private Set<JishudianArticle> jishudianArticle = new HashSet<JishudianArticle>(); 
	

	//技术点国际分布
	private String international;
	
	//技术点国内分布
	private String civil;
	
	//技术点发布时间
	private int year;
	
	//技术点研究情况（历年数量）
	private String num;
	
	//专家是否判定是前言
	private int isqianyan;
	
	//是否是前沿技术点
	private int isqianyanjishudian;
	
	//是否是跟踪技术点
	private int isgenzongjishudian;
	
	//临时添加填充技术点打分页面空白内容
	private String definition;
	
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
	
	

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public long getFieldid() {
		return fieldid;
	}

	public void setFieldid(long fieldid) {
		this.fieldid = fieldid;
	}

	

	public Set<JishudianArticle> getJishudianArticle() {
		return jishudianArticle;
	}

	public void setJishudianArticle(Set<JishudianArticle> jishudianArticle) {
		this.jishudianArticle = jishudianArticle;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public int getIsqianyan() {
		return isqianyan;
	}

	public void setIsqianyan(int isqianyan) {
		this.isqianyan = isqianyan;
	}

	public int getIsqianyanjishudian() {
		return isqianyanjishudian;
	}

	public void setIsqianyanjishudian(int isqianyanjishudian) {
		this.isqianyanjishudian = isqianyanjishudian;
	}

	public int getIsgenzongjishudian() {
		return isgenzongjishudian;
	}

	public void setIsgenzongjishudian(int isgenzongjishudian) {
		this.isgenzongjishudian = isgenzongjishudian;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	
	
	
}