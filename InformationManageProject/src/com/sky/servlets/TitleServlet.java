package com.sky.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sky.dao.TitleDao;
import com.sky.dao.impl.TitleDaoImpl;
import com.sky.pojo.Titles;

public class TitleServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
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
		if (operation.equals("showOne")) {		//查询单个职称
			int id = Integer.parseInt(req.getParameter("id"));
			Titles title = titleDao.selectOneById(id);
			
			req.setAttribute("title", title);
			req.getRequestDispatcher("/update-title.jsp").forward(req, resp);
		}else if (operation.equals("add")) {		//添加职称
			String name = req.getParameter("name");
			String baseWage = req.getParameter("base_wage");
			String roomSupply = req.getParameter("room_supply");
			String jobSupply = req.getParameter("job_supply");
			
			res = titleDao.addOneTitle(new Titles(name, baseWage, roomSupply, jobSupply));
			if (res) {
				//添加成功
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			} else {
				//添加失败
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		}else if (operation.equals("queryAll")) {		//查询全部职称
			List<Titles> titles = titleDao.selectAllTitles();
			
			req.setAttribute("titles", titles);
			//请求转发跳转
			req.getRequestDispatcher("/show-title.jsp").forward(req, resp);
		}else if (operation.equals("update")) { 	//修改
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String baseWage = req.getParameter("base_wage");
			String roomSupply = req.getParameter("room_supply");
			String jobSupply = req.getParameter("job_supply");
			int status = Integer.parseInt(req.getParameter("status"));
			
			Titles title = new Titles(id, name, baseWage, roomSupply, jobSupply, status);
			
			res = titleDao.updateTitle(title);
			if (res) {
				//修改成功
				resp.sendRedirect(req.getContextPath()+"/queryAll.title?operation=queryAll");
			} else {
				//修改失败
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		}else if (operation.equals("upload")) {		//启用
			int id = Integer.parseInt(req.getParameter("id"));
			res = titleDao.updateTitleStatus(id, 1);
			if (res) {
				resp.sendRedirect(req.getContextPath()+"/queryAll.title?operation=queryAll");
			} else {
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		}else if (operation.equals("download")) {		//停用
			int id = Integer.parseInt(req.getParameter("id"));
			res = titleDao.updateTitleStatus(id, 2);
			if (res) {
				resp.sendRedirect(req.getContextPath()+"/queryAll.title?operation=queryAll");
			} else {
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		}else if (operation.equals("delete")) {		//删除
			int id = Integer.parseInt(req.getParameter("id"));
			res = titleDao.updateTitleStatus(id, 0);
			if (res) {
				resp.sendRedirect(req.getContextPath()+"/queryAll.title?operation=queryAll");
			} else {
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		}else if (operation.equals("queryAllByAjax")) {
			
			resp.setContentType("application/json; charset=utf-8"); 
            req.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            
            List<Titles> titles = titleDao.selectAllTitles();
            
            //list转换为json
            Gson gson = new Gson(); 
            String str = gson.toJson(titles);
            
			
			out.print(str);
			out.flush();
			out.close();
		}
	}

}
