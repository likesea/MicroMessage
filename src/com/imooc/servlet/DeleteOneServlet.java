package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.imooc.service.MaintainService;

/**
 * Servlet implementation class DeleteOneServlet
 */
@WebServlet("/DeleteOneServlet")
public class DeleteOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				//设置编码
				req.setCharacterEncoding("utf-8");
				//接受页面获取值
				String id = req.getParameter("oneId");
				//向页面传值
				MaintainService maintainService = new MaintainService();
				maintainService.deleteOne(id);
				req.getRequestDispatcher("/list.action").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);}

}
