package com.sky.pojo;

public class Staffs {
	private Integer id;
	private String name;
	private String sex;
	private String birth;
	private String home;
	private Integer department;
	private Integer title;
	private Integer status;
	public Staffs() {
		super();
	}
	public Staffs(String name, String sex, String birth, String home, Integer department, Integer title) {
		super();
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.home = home;
		this.department = department;
		this.title = title;
	}
	public Staffs(Integer id, String name, String sex, String birth, String home, Integer department, Integer title,
			Integer status) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.home = home;
		this.department = department;
		this.title = title;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public Integer getDepartment() {
		return department;
	}
	public void setDepartment(Integer department) {
		this.department = department;
	}
	public Integer getTitle() {
		return title;
	}
	public void setTitle(Integer title) {
		this.title = title;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
