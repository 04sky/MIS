package com.sky.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sky.dao.DepartmentDao;
import com.sky.dao.StaffDao;
import com.sky.dao.TitleDao;
import com.sky.dao.impl.DepartmentDaoImpl;
import com.sky.dao.impl.StaffDaoImpl;
import com.sky.dao.impl.TitleDaoImpl;
import com.sky.pojo.FullStaffs;
import com.sky.pojo.Staffs;

public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StaffDao staffDao = new StaffDaoImpl();
	DepartmentDao departmentDao = new DepartmentDaoImpl();
	TitleDao titleDao = new TitleDaoImpl();
	Boolean res = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("utf-8");
		
		String operation = req.getParameter("operation");
		if (operation.equals("showOne")) {		//查询单个员工
			int id = Integer.parseInt(req.getParameter("id"));
			Staffs staff = staffDao.selectOneById(id);
			
			String departmentString = departmentDao.selectOneById(staff.getDepartment()).getName();
			String titleString = titleDao.selectOneById(staff.getTitle()).getName();
			FullStaffs fullStaff = new FullStaffs(staff.getId(), staff.getName(), staff.getSex(), staff.getBirth(), staff.getHome(), staff.getDepartment(), staff.getTitle(), departmentString, titleString, staff.getStatus());
			
			req.setAttribute("staff", fullStaff);
			req.getRequestDispatcher("/update-staff.jsp").forward(req, resp);
		}else if (operation.equals("add")) {		//添加员工
			String name = req.getParameter("name");
			String sex = req.getParameter("sex");
			String birth = req.getParameter("birth");
			String home = req.getParameter("home");
			Integer department = Integer.parseInt(req.getParameter("department"));
			Integer title = Integer.parseInt(req.getParameter("title"));
			
			res = staffDao.addOneStaff(new Staffs(name, sex, birth, home, department, title));
			if (res) {
				//添加成功
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			} else {
				//添加失败
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		}else if (operation.equals("queryAll")) {		//查询全部员工号
			List<Staffs> staffs = staffDao.selectAllStaffs(); 
			List<FullStaffs> fullStaffs = new ArrayList<FullStaffs>();
			for (Staffs staff : staffs) {
				String departmentString = departmentDao.selectOneById(staff.getDepartment()).getName();
				String titleString = titleDao.selectOneById(staff.getTitle()).getName();
				fullStaffs.add(new FullStaffs(staff.getId(), staff.getName(), staff.getSex(), staff.getBirth(), staff.getHome(), staff.getDepartment(), staff.getTitle(), departmentString, titleString, staff.getStatus()));
			}
			
			req.setAttribute("staffs", fullStaffs);
			//请求转发跳转
			req.getRequestDispatcher("/show-staff.jsp").forward(req, resp);
		}else if (operation.equals("update")) { 	//修改
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String sex = req.getParameter("sex");
			String birth = req.getParameter("birth");
			String home = req.getParameter("home");
			Integer department = Integer.parseInt(req.getParameter("department"));
			Integer title = Integer.parseInt(req.getParameter("title"));
			int status = Integer.parseInt(req.getParameter("status"));
			
			Staffs staff = new Staffs(id, name, sex, birth, home, department, title, status);
			
			res = staffDao.updateStaff(staff);
			if (res) {
				//修改成功
				resp.sendRedirect(req.getContextPath()+"/queryAll.staff?operation=queryAll");
			} else {
				//修改失败
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		}else if (operation.equals("upload")) {		//启用
			int id = Integer.parseInt(req.getParameter("id"));
			res = staffDao.updateStaffStatus(id, 1);
			if (res) {
				resp.sendRedirect(req.getContextPath()+"/queryAll.staff?operation=queryAll");
			} else {
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		}else if (operation.equals("download")) {		//停用
			int id = Integer.parseInt(req.getParameter("id"));
			res = staffDao.updateStaffStatus(id, 2);
			if (res) {
				resp.sendRedirect(req.getContextPath()+"/queryAll.staff?operation=queryAll");
			} else {
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		}else if (operation.equals("delete")) {		//删除
			int id = Integer.parseInt(req.getParameter("id"));
			res = staffDao.updateStaffStatus(id, 0);
			if (res) {
				resp.sendRedirect(req.getContextPath()+"/queryAll.staff?operation=queryAll");
			} else {
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		}
	}
}
