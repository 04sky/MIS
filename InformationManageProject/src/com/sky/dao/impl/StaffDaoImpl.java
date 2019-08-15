package com.sky.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sky.dao.StaffDao;
import com.sky.pojo.Staffs;
import com.sky.utils.DBUtils;

public class StaffDaoImpl implements StaffDao {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Boolean result = false;
	Staffs staff = null;
	List<Staffs> list = null;

	@Override
	public Staffs selectOneById(Integer id) {
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("SELECT * FROM staffs where id = ?;");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				int _id = rs.getInt(1);
				String name = rs.getString(2);
				String sex = rs.getString(3);
				String birth = rs.getString(4);
				String home = rs.getString(5);
				int department = rs.getInt(6);
				int title = rs.getInt(7);
				int status = rs.getInt(8);
				
				staff = new Staffs(_id, name, sex, birth, home, department, title, status);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		return staff;
	}

	@Override
	public boolean addOneStaff(Staffs staff) {
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("insert into staffs values (0, ?, ?, ?, ?, ?, ?, 1);");
			ps.setString(1, staff.getName());
			ps.setString(2, staff.getSex());
			ps.setString(3, staff.getBirth());
			ps.setString(4, staff.getHome());
			ps.setInt(5, staff.getDepartment());
			ps.setInt(6, staff.getTitle());
			
			result = ps.executeUpdate()>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		return result;
	}

	@Override
	public List<Staffs> selectAllStaffs() {
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("SELECT * FROM staffs where status=1 or status=2;");
			
			rs = ps.executeQuery();
			list = new ArrayList<Staffs>();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String sex = rs.getString(3);
				String birth = rs.getString(4);
				String home = rs.getString(5);
				int dept = rs.getInt(6);
				int title = rs.getInt(7);
				int status = rs.getInt(8);
				
				staff = new Staffs(id, name, sex, birth, home, dept, title, status);
				list.add(staff);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public boolean updateStaff(Staffs staff) {
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("update staffs set name=?, sex=?, birth=?, home=?, department=?, title=?, status=? where id=?;");
			ps.setString(1, staff.getName());
			ps.setString(2, staff.getSex());
			ps.setString(3, staff.getBirth());
			ps.setString(4, staff.getHome());
			ps.setInt(5, staff.getDepartment());
			ps.setInt(6, staff.getTitle());
			ps.setInt(7, staff.getStatus());
			ps.setInt(8, staff.getId());
			
			result = ps.executeUpdate()>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		return result;
	}

	@Override
	public boolean updateStaffStatus(Integer id, Integer status) {
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("update staffs set status=? where id=?;");
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
