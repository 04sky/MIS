package com.sky.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sky.dao.TitleDao;
import com.sky.pojo.Titles;
import com.sky.utils.DBUtils;

public class TitleDaoImpl implements TitleDao {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Boolean result = false;
	Titles title = null;
	List<Titles> list = null;

	@Override
	public Titles selectOneById(Integer id) {
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("SELECT * FROM titles where id = ?;");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				int _id = rs.getInt(1);
				String name = rs.getString(2);
				String baseWage = rs.getString(3);
				String roomSupply = rs.getString(4);
				String jobSupply = rs.getString(5);
				int status = rs.getInt(6);
				
				title = new Titles(_id, name, baseWage, roomSupply, jobSupply, status);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		return title;
	}

	@Override
	public boolean addOneTitle(Titles title) {
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("insert into titles values (0, ?, ?, ?, ?, 1);");
			ps.setString(1, title.getName());
			ps.setString(2, title.getBaseWage());
			ps.setString(3, title.getRoomSupply());
			ps.setString(4, title.getJobSupply());
			
			result = ps.executeUpdate()>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		return result;
	}

	@Override
	public List<Titles> selectAllTitles() {
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("SELECT * FROM titles where status=1 or status=2;");
			
			rs = ps.executeQuery();
			list = new ArrayList<Titles>();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String baseWage = rs.getString(3);
				String roomSupply = rs.getString(4);
				String jobSupply = rs.getString(5);
				int status = rs.getInt(6);
				
				title = new Titles(id, name, baseWage, roomSupply, jobSupply, status);
				list.add(title);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public boolean updateTitle(Titles title) {
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("update titles set name=?, base_wage=?, room_supply=?, job_supply=?, status=? where id=?;");
			ps.setString(1, title.getName());
			ps.setString(2, title.getBaseWage());
			ps.setString(3, title.getRoomSupply());
			ps.setString(4, title.getJobSupply());
			ps.setInt(5, title.getStatus());
			ps.setInt(6, title.getId());
			
			result = ps.executeUpdate()>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		return result;
	}

	@Override
	public boolean updateTitleStatus(Integer id, Integer status) {
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("update titles set status=? where id=?;");
			ps.setInt(1, status);
			ps.setInt(2, id);
			
			result = ps.executeUpdate()>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		return result;
	}

}
