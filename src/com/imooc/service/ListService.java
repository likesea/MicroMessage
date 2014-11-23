package com.imooc.service;
import java.util.List;

import com.imooc.bean.*;
import com.imooc.dao.MessageDao;
/**
 * 列表相关的业务功能
 * @author liuyb
 *
 */
public class ListService {
	public List<Message>  queryMessage(String command,String description) {
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessages(command, description);
	}
}
