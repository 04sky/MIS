package com.sky.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sky.dao.DepartmentDao;
import com.sky.dao.impl.DepartmentDaoImpl;
import com.sky.pojo.Departments;

public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DepartmentDao departmentDao = new DepartmentDaoImpl();
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
		if (operation.equals("showOne")) {		//查询单个部门
			int id = Integer.parseInt(req.getParameter("id"));
			Departments dept = departmentDao.selectOneById(id);
			
			req.setAttribute("department", dept);
			req.getRequestDispatcher("/update-department.jsp").forward(req, resp);
		}else if (operation.equals("add")) {		//添加部门
			String name = req.getParameter("name");
			String manager = req.getParameter("manager");
			String description = req.getParameter("description");
			
			res = departmentDao.addOneDepartment(new Departments(name, manager, description));
			if (res) {
				//添加成功
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			} else {
				//添加失败
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		}else if (operation.equals("queryAll")) {		//查询全部部门
			List<Departments> depts = departmentDao.selectAllDepartments();
			
			req.setAttribute("departments", depts);
			//请求转发跳转
			req.getRequestDispatcher("/show-department.jsp").forward(req, resp);
		}else if (operation.equals("update")) { 	//修改
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String manager = req.getParameter("manager");
			String description = req.getParameter("description");
			int status = Integer.parseInt(req.getParameter("status"));
			
			Departments dept = new Departments(id, name, manager, description, status);
			
			res = departmentDao.updateDepartment(dept);
			if (res) {
				//修改成功
				resp.sendRedirect(req.getContextPath()+"/queryAll.department?operation=queryAll");
			} else {
				//修改失败
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		}else if (operation.equals("upload")) {		//启用
			int id = Integer.parseInt(req.getParameter("id"));
			res = departmentDao.updatedepartmentStatus(id, 1);
			if (res) {
				resp.sendRedirect(req.getContextPath()+"/queryAll.department?operation=queryAll");
			} else {
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		}else if (operation.equals("download")) {		//停用
			int id = Integer.parseInt(req.getParameter("id"));
			res = departmentDao.updatedepartmentStatus(id, 2);
			if (res) {
				resp.sendRedirect(req.getContextPath()+"/queryAll.department?operation=queryAll");
			} else {
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		}else if (operation.equals("delete")) {		//删除
			int id = Integer.parseInt(req.getParameter("id"));
			res = departmentDao.updatedepartmentStatus(id, 0);
			if (res) {
				resp.sendRedirect(req.getContextPath()+"/queryAll.department?operation=queryAll");
			} else {
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		}else if (operation.equals("queryAllByAjax")) {
			
			resp.setContentType("application/json; charset=utf-8"); 
            req.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            
            List<Departments> depts = departmentDao.selectAllDepartments();
            
            //list转换为json
            Gson gson = new Gson(); 
            String str = gson.toJson(depts);
            
			
			out.print(str);
			out.flush();
			out.close();
		}
	}
}
