package com.imooc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imooc.bean.Message;

public class MessageDao {
	public List<Message> queryMessages(String command,String description)  {
		// TODO Auto-generated method stub
		List<Message> messageList = new ArrayList<Message>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","password");
			StringBuilder sql = new StringBuilder("select id,command,DESCRIPTION,CONTENT from MICROMESSAGE where 1=1");
			List<String> paramList = new ArrayList<String>();
			if(command!=null&&!"".equals(command.trim())){
				sql.append(" and COMMAND=?");
				paramList.add(command);
			}
			if(description!=null&&!"".equals(description.trim())){
				sql.append(" and description like '%' ? '%' ");
				paramList.add(description);
			}
			PreparedStatement statement =conn.prepareStatement(sql.toString()); 
			for (int i=0;i<paramList.size();i++) {
				statement.setString(i+1, paramList.get(i));
			}
			ResultSet rs= statement.executeQuery();
			
			while(rs.next()){
				Message message = new Message();
				messageList.add(message);
				message.setId(rs.getString("id"));
				message.setCommand(rs.getString("command"));
				message.setDescription(rs.getString("description"));
				message.setContent(rs.getString("content"));
			}	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return messageList;
	}
}
