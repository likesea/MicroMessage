package com.imooc.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.imooc.service.ListService;

/**
 *  list control page
 *  起到控制器的作用，只负责接收页面的值和向页面传值
 * @author liuyb
 *
 */
@SuppressWarnings("serial")
public class ListServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				//设置编码
				req.setCharacterEncoding("utf-8");
				//接受页面获取值
				String command = req.getParameter("command");
				String description = req.getParameter("description");
				//向页面传值
				req.setAttribute("command", command);
				req.setAttribute("description", description);
				ListService listService = new ListService();
				req.setAttribute("messageList", listService.queryMessage(command, description));			
				req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	} 
}
