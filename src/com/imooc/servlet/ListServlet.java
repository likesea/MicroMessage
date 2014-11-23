package com.imooc.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.imooc.service.ListService;

/**
 *  list control page
 *  �𵽿����������ã�ֻ�������ҳ���ֵ����ҳ�洫ֵ
 * @author liuyb
 *
 */
@SuppressWarnings("serial")
public class ListServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				//���ñ���
				req.setCharacterEncoding("utf-8");
				//����ҳ���ȡֵ
				String command = req.getParameter("command");
				String description = req.getParameter("description");
				//��ҳ�洫ֵ
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
