package com.oa.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.oa.pojos.OaFlow;

public interface OaflowDao extends CrudRepository<OaFlow, Long> {
	
	/**
	 * 查询所有待办流程记录
	 */
	@Query("select o from OaFlow o where o.flowState=?1 and o.flowStep=?2")
	public List<OaFlow> queryFlowAll(int state,int step);
	
	/**
	 * 按流程标题模糊查询
	 */
	public List<OaFlow> findByflowNameLike(String name);
}
