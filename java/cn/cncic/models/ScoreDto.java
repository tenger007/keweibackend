package cn.cncic.models;

import java.util.ArrayList;
import java.util.List;


public class ScoreDto {
	
	//技术点实现年限
	private String realizetime;
	
	//杂志等级
	private int factor;
	
	//文章类型
	private int type;
	
	
	public ScoreDto(String realizetime,int factor,int type) {
		super();
		this.realizetime = realizetime;
		this.factor=factor;
		this.type=type;
		
	}


	public String getRealizetime() {
		return realizetime;
	}


	public void setRealizetime(String realizetime) {
		this.realizetime = realizetime;
	}


	public int getFactor() {
		return factor;
	}


	public void setFactor(int factor) {
		this.factor = factor;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}
	
	

	
}