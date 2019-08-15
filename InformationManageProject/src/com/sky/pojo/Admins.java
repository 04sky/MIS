package com.sky.pojo;

public class Admins {
	private Integer id;
	private String account;
	private String password;
	private Integer status;
	
	public Admins() {
		super();
	}

	public Admins(Integer id, String account, String password, Integer status) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
