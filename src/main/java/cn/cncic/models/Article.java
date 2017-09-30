package cn.cncic.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import javax.persistence.*;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Article {
	@Id
	private long id;	
	
	private long sourceid;
	
	private String sourcename;
	
	/*@ManyToMany(mappedBy="articles")
	private Set<Jishudian> jishudians = new HashSet<Jishudian>();*/
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)//级联保存、更新、删除、刷新;延迟加载
	 @JoinColumn(name="article_id")//在jishudianArticle表增加一个外键列来实现一对多的单向关联
//	 private Set<Book> books = new HashSet<Book>();
	private Set<JishudianArticle> jishudianArticle = new HashSet<JishudianArticle>(); 
	
	@NotNull
	@Size(max=255)
	private String title;
	
	private String author;
	
	private String pdf;
	
	private String img;

	private String summary;
	
	private Timestamp pbdate;
	
	private int type;
	
	//作者所在机构
	private String authoraffiliation;
	//issn号
	private String issn;
	//期
	private int issue;
	//卷
	private int volume;
	//语言
	private String language;
	//主题词
	private String subjects;
	
	//作者通讯地址
	private String authorrp;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public long getSourceid() {
		return sourceid;
	}

	public void setSourceid(long sourceid) {
		this.sourceid = sourceid;
	}

	public String getSourcename() {
		return sourcename;
	}

	public void setSourcename(String sourcename) {
		this.sourcename = sourcename;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Timestamp getPbdate() {
		return pbdate;
	}

	public void setPbdate(Timestamp pbdate) {
		this.pbdate = pbdate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	

	public Set<JishudianArticle> getJishudianArticle() {
		return jishudianArticle;
	}

	public void setJishudianArticle(Set<JishudianArticle> jishudianArticle) {
		this.jishudianArticle = jishudianArticle;
	}

	public String getAuthoraffiliation() {
		return authoraffiliation;
	}

	public void setAuthoraffiliation(String authoraffiliation) {
		this.authoraffiliation = authoraffiliation;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	

	public int getIssue() {
		return issue;
	}

	public void setIssue(int issue) {
		this.issue = issue;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

	public String getAuthorrp() {
		return authorrp;
	}

	public void setAuthorrp(String authorrp) {
		this.authorrp = authorrp;
	}

	
	
}
