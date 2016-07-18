package com.qzz.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzz.common.pojo.PartPoet;
import com.qzz.common.pojo.Work;
import com.qzz.user.dao.IQueryDao;

@Service("queryService")
public class QueryServiceimpl implements QueryService {
	@Autowired
	private IQueryDao queryDao;

	public IQueryDao getQueryDao() {
		return queryDao;
	}

	public void setQueryDao(IQueryDao queryDao) {
		this.queryDao = queryDao;
	}

	/*
	 * 根据作者查找诗名
	 */
	public List<String> findByName(String name, int page) {
		return queryDao.findByName(name, page);
	}

	/*
	 * 查找该作者的作品数量
	 */

	public int findCount(String name) {
		return queryDao.findCount(name);
	}

	/*
	 * 根据诗词标题查内容
	 */
	public Work findWork(String title) {
		return queryDao.findWork(title);
	}

	/*
	 * 通过诗歌的名句搜索该唐诗的作者、题目和全文
	 */
	public List<PartPoet> findPart(String part) {
		List list = queryDao.findPart(part);
		return list;

	}
}
