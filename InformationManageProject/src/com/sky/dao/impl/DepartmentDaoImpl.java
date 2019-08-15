package com.sky.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sky.dao.DepartmentDao;
import com.sky.pojo.Departments;
import com.sky.utils.DBUtils;

public class DepartmentDaoImpl implements DepartmentDao{
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Boolean result = false;
	Departments dept = null;
	List<Departments> list = null;

	@Override
	public Departments selectOneById(Integer id) {
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("SELECT * FROM departments where id = ?;");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				int _id = rs.getInt(1);
				String _name = rs.getString(2);
				String _manager = rs.getString(3);
				String _description = rs.getString(4);
				int _status = rs.getInt(5);
				
				dept = new Departments(_id, _name, _manager, _description, _status);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		return dept;
	}

	@Override
	public boolean addOneDepartment(Departments dept) {
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("insert into departments values (0, ?, ?, ?, 1);");
			ps.setString(1, dept.getName());
			ps.setString(2, dept.getManager());
			ps.setString(3, dept.getDescription());
			
			result = ps.executeUpdate()>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		return result;
	}

	@Override
	public List<Departments> selectAllDepartments() {
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("SELECT * FROM departments where status=1 or status=2;");
			
			rs = ps.executeQuery();
			list = new ArrayList<Departments>();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String manager = rs.getString(3);
				String description = rs.getString(4);
				int status = rs.getInt(5);
				
				dept = new Departments(id, name, manager, description, status);
				list.add(dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public boolean updateDepartment(Departments newDeptDepartments) {
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("update departments set name=?, manager=?, description=?,status=? where id=?;");
			ps.setString(1, newDeptDepartments.getName());
			ps.setString(2, newDeptDepartments.getManager());
			ps.setString(3, newDeptDepartments.getDescription());
			ps.setInt(4, newDeptDepartments.getStatus());
			ps.setInt(5, newDeptDepartments.getId());
			
			result = ps.executeUpdate()>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		return result;
	}

	@Override
	public boolean updatedepartmentStatus(Integer id,Integer status) {
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("update departments set status=? where id=?;");
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
