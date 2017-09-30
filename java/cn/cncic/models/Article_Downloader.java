package cn.cncic.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Article_Downloader {
	@Id @GeneratedValue
 public long id;
	public String title;
	public String author;
	private String keywords;
	 private String Abstract;
	 private String content;
	 private String url;
	 private String siteName;
	 private String source;
	 private int channelId;
	 private String extras;
	 private String attachments;
	 private String publishedDate;
	 private String publishedDateStr;
	 private String jsdname;
	 
	public String getJsdname() {
		return jsdname;
	}
	public void setJsdname(String jsdname) {
		this.jsdname = jsdname;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getAbstract() {
		return Abstract;
	}
	public void setAbstract(String abstract1) {
		Abstract = abstract1;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	
	
	
	public String getExtras() {
		return extras;
	}
	public void setExtras(String extras) {
		this.extras = extras;
	}
	public String getAttachments() {
		return attachments;
	}
	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getPublishedDateStr() {
		return publishedDateStr;
	}
	public void setPublishedDateStr(String publishedDateStr) {
		this.publishedDateStr = publishedDateStr;
	}
	@Override
	public String toString() {
		return "Article_Downloader [id=" + id + ", title=" + title + ", author=" + author + ", keywords=" + keywords
				+ ", Abstract=" + Abstract + ", content=" + content + ", url=" + url + ", siteName=" + siteName
				+ ", source=" + source + ", channelId=" + channelId + ", extras=" + extras + ", attachments="
				+ attachments + ", publishedDate=" + publishedDate + ", publishedDateStr=" + publishedDateStr
				+ ", jsdname=" + jsdname + "]";
	}
	
	
}
