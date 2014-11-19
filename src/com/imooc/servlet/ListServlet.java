package com.imooc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  list control page
 * @author liuyb
 *
 */
@SuppressWarnings("serial")
public class ListServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			try {
				Class.forName("com.mysql.jdbc.Driver");		
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","password");
				String sql ="select id,command,DESCRIPTION,CONTENT from MICROMESSAGE";
				PreparedStatement statement =conn.prepareStatement(sql); 
				ResultSet rs= statement.executeQuery();
				List<Message> messageList = new ArrayList<Message>();
				while(rs.next()){
					Message message = new Message();
					messageList.add(message);
					message.setId(rs.getString("id"));
					message.setCommand(rs.getString("command"));
					message.setDescription(rs.getString("description"));
					message.setContent(rs.getString("content"));
				}			
				req.setAttribute("messageList", messageList);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	} 
}
