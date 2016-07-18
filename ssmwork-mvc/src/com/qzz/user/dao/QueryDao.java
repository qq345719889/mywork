package com.qzz.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qzz.common.pojo.PartPoet;
import com.qzz.common.pojo.Work;

/**
 *@author WHD
 *2015-3-18
 */
/**
 * repository 说明就是一个dao层的注解
 */
@Repository("queryDao")
public class QueryDao implements IQueryDao {
	/**
	 * 自动注入这里spring管理了mybatis的sqlsessionfactory
	 */
	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * 保存用户信息
	 * 
	 * @param map
	 */

	public List<String> findByName(@Param("name") String name,
			@Param("page") int page) {
		Map map = new HashMap();
		map.put("name", name);
		map.put("page", page);
		return sqlSession.selectList("com.qzz.user.dao.QueryDao.findByName",
				map);
	}

	public int findCount(@Param("name") String name) {
		return sqlSession
				.selectOne("com.qzz.user.dao.QueryDao.findCount", name);
	}

	public Work findWork(String title) {
		return sqlSession
				.selectOne("com.qzz.user.dao.QueryDao.findWork", title);
	}

	public List<PartPoet> findPart(@Param("part") String part) {
		return sqlSession.selectList("com.qzz.user.dao.QueryDao.findPart",part);
	}

}
