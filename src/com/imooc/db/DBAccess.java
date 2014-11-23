package com.imooc.db;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

/**
 * 访问数据库，获取回话
 * @author yanbi_000
 *
 */
public class DBAccess {
	public SqlSession getSqlSession() throws IOException{
		//同过配置文件获取数据库连接信息		
		Reader reader = Resources.getResourceAsReader("com/imooc/config/Configuration.xml");
		//通过配置信息构建一个sqlsessionfactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//通过sqlSessionFactory打开一个数据库回话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//返回sqlSession
		return sqlSession;
		
	}
}
