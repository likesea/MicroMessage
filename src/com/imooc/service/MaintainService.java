package com.imooc.service;


import java.util.ArrayList;
import java.util.List;

import com.imooc.dao.MessageDao;
/**
 * 维护相关操作
 * @author yanbi_000
 *
 */
public class MaintainService {
	/**
	 * 单条删除
	 * @param id
	 */
	public void deleteOne(String id) {
		if(id!=null &&!"".equals(id)){
			MessageDao messageDao = new MessageDao();
			messageDao.deleteOne(Integer.valueOf(id));
		}
	}
	/**
	 * 多条删除
	 * @param id
	 */
	public void deleteBatch(String[] ids) {
		if(ids!=null&& ids.length>0){
			MessageDao messageDao = new MessageDao();
			List<Integer> listIntegers =new ArrayList<Integer>();
			for (String item : ids) {
				listIntegers.add(Integer.valueOf(item));
			}
			messageDao.deleteBatch(listIntegers);
		}
	}
}
