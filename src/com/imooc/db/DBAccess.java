package com.imooc.db;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

/**
 * �������ݿ⣬��ȡ�ػ�
 * @author yanbi_000
 *
 */
public class DBAccess {
	public SqlSession getSqlSession() throws IOException{
		//ͬ�������ļ���ȡ���ݿ�������Ϣ		
		Reader reader = Resources.getResourceAsReader("com/imooc/config/Configuration.xml");
		//ͨ��������Ϣ����һ��sqlsessionfactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//ͨ��sqlSessionFactory��һ�����ݿ�ػ�
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//����sqlSession
		return sqlSession;
		
	}
}
