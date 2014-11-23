package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.MaintainService;

/**
 * Servlet implementation class DeleteBatchServlet
 */
@WebServlet("/DeleteBatchServlet")
public class DeleteBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				//���ñ���
				req.setCharacterEncoding("utf-8");
				//����ҳ���ȡֵ
				String[] ids = req.getParameterValues("id");
				//��ҳ�洫ֵ
				MaintainService maintainService = new MaintainService();
				maintainService.deleteBatch(ids);
				req.getRequestDispatcher("/list.action").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);}
}
