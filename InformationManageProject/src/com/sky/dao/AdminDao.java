package com.sky.dao;

import com.sky.pojo.Admins;

public interface AdminDao {
	
	//按账号密码查询管理员
	Admins selectOneByAccountAndPwd(String account,String password);
	
}
