package com.sky.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sky.dao.AdminDao;
import com.sky.pojo.Admins;
import com.sky.utils.DBUtils;

public class AdminDaoImpl implements AdminDao {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Boolean result = false;
	Admins admin = null;
	
	@Override
	public Admins selectOneByAccountAndPwd(String account, String password) {
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("SELECT * FROM admins where account = ? and password = ? and status = 1;");
			ps.setString(1, account);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				int _id = rs.getInt(1);
				String _account = rs.getString(2);
				String _password = rs.getString(3);
				int _status = rs.getInt(4);
				
				admin = new Admins(_id, _account, _password, _status);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		return admin;
	}

}
