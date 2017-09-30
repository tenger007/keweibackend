package cn.cncic.models;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class JishudianArticle {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) 
	//主键自增长是否需设置？
	private long id;
	
	//技术点实现时间
	private String realizetime;
	
	//是否是预测文章
	private int isforecast;
	
	private long jishudian_id;
	private long article_id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRealizetime() {
		return realizetime;
	}

	public void setRealizetime(String realizetime) {
		this.realizetime = realizetime;
	}

	
	public int getIsforecast() {
		return isforecast;
	}

	public void setIsforecast(int isforecast) {
		this.isforecast = isforecast;
	}

	public long getJishudian_id() {
		return jishudian_id;
	}

	public void setJishudian_id(long jishudian_id) {
		this.jishudian_id = jishudian_id;
	}

	public long getArticle_id() {
		return article_id;
	}

	public void setArticle_id(long article_id) {
		this.article_id = article_id;
	}
	
}
