package com.sky.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sky.dao.AdminDao;
import com.sky.dao.impl.AdminDaoImpl;
import com.sky.pojo.Admins;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AdminDao adminDao = new AdminDaoImpl();
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
		if (operation.equals("login")) {		//登录
			String account = req.getParameter("account");
			String password = req.getParameter("password");
			
			Admins admin = adminDao.selectOneByAccountAndPwd(account, password);
			if (admin!=null) {
				req.getSession().setAttribute("admin", admin);
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			}else {
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
		}
	}
}
