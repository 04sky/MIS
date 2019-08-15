package com.sky.pojo;

public class Titles {
	private Integer id;
	private String name;
	private String baseWage;
	private String roomSupply;
	private String jobSupply;
	private Integer status;
	
	
	public Titles() {
		super();
	}
	
	public Titles(String name, String baseWage, String roomSupply, String jobSupply) {
		super();
		this.name = name;
		this.baseWage = baseWage;
		this.roomSupply = roomSupply;
		this.jobSupply = jobSupply;
	}

	public Titles(Integer id, String name, String baseWage, String roomSupply, String jobSupply, Integer status) {
		super();
		this.id = id;
		this.name = name;
		this.baseWage = baseWage;
		this.roomSupply = roomSupply;
		this.jobSupply = jobSupply;
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
	public String getBaseWage() {
		return baseWage;
	}
	public void setBaseWage(String baseWage) {
		this.baseWage = baseWage;
	}
	public String getRoomSupply() {
		return roomSupply;
	}
	public void setRoomSupply(String roomSupply) {
		this.roomSupply = roomSupply;
	}
	public String getJobSupply() {
		return jobSupply;
	}
	public void setJobSupply(String jobSupply) {
		this.jobSupply = jobSupply;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
