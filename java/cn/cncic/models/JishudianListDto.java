package cn.cncic.models;


public class JishudianListDto {
	
	private long id;
	private String name;
	private long fieldid;
	private int year;
	private String num;
	
	
	public JishudianListDto(long id, String name,long fieldid,int year,String num) {
		super();
		this.id = id;
		this.name = name;
		this.fieldid=fieldid;
		this.year=year;
		this.num=num;
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

	public long getFieldid() {
		return fieldid;
	}

	public void setFieldid(long fieldid) {
		this.fieldid = fieldid;
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
	
}
