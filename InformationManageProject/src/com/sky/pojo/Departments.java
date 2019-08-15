package com.sky.pojo;

public class Departments {
	private Integer id;
	private String name;
	private String manager;
	private String description;
	private int status;
	
	public Departments() {
		super();
	}
	
	public Departments(String name, String manager, String description) {
		super();
		this.name = name;
		this.manager = manager;
		this.description = description;
	}

	public Departments(Integer id, String name, String manager, String description, int status) {
		super();
		this.id = id;
		this.name = name;
		this.manager = manager;
		this.description = description;
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
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Departments [id=" + id + ", name=" + name + ", manager=" + manager + ", description=" + description
				+ ", status=" + status + "]";
	}
	
	
}
