package com.qzz.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qzz.common.pojo.PartPoet;
import com.qzz.common.pojo.Work;

public interface IQueryDao {
	/*
	 * 根据作者查找诗名
	 */
	public List<String> findByName(String name, int page);

	/*
	 * 查找该作者的作品数量
	 */
	public int findCount(@Param("name") String name);

	/*
	 * 根据诗词标题查内容
	 */
	public Work findWork(String title);

	/*
	 * 通过诗歌的名句搜索该唐诗的作者、题目和全文
	 */
	public List<PartPoet> findPart(@Param("part") String part);
}
