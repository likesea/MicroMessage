package com.imooc.dao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;

public class MessageDao {
	/**
	 * 单条删除
	 * @param id
	 */
	public void deleteOne(int id) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession=dbAccess.getSqlSession();
			//通过sqlSession执行sql语句
			sqlSession.delete("Message.deleteOne", id);
			//mybatis有事务控制能力，不会自动提交，所以对于增删改 需要手动提交，查询不需要的
			//jdbc事务默认自动提交
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(sqlSession!=null)
				sqlSession.close();
		}
	}
	public void deleteBatch(List<Integer> list) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession=dbAccess.getSqlSession();
			//通过sqlSession执行sql语句
			sqlSession.delete("Message.deleteBatch", list);
			//mybatis有事务控制能力，不会自动提交，所以对于增删改 需要手动提交，查询不需要的
			//jdbc事务默认自动提交
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(sqlSession!=null)
				sqlSession.close();
		}
	}
	public List<Message> queryMessages(String command,String description) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Message> messageList = new ArrayList<Message>();
		try {
			sqlSession=dbAccess.getSqlSession();
			//通过sqlSession执行sql语句
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			messageList = sqlSession.selectList("Message.queryMessages",message);
			//通过sqlSession执行sql语句
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(sqlSession!=null)
				sqlSession.close();
		}
		return messageList;
	}
	@Test
	public  void test() {
			MessageDao messageDao =new MessageDao();
			messageDao.queryMessages("","");
	}
	
/*public List<Message> queryMessages(String command,String description)  {
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
	}*/
}
