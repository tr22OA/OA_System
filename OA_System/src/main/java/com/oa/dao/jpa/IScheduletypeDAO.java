package com.oa.dao.jpa;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.oa.pojos.OaScheduletype;

/**
 * 排班类型接口
 * @author qh
 *
 */
public interface IScheduletypeDAO extends CrudRepository<OaScheduletype, Long>{
	/**
	 * 分页查询排班类型表
	 * @param pageable
	 * @return
	 */
	@Query("select s from OaScheduletype s order by s.shtId desc")
	public List<OaScheduletype>queryAllByPage(Pageable pageable);

}
