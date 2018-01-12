package com.oa.dao.jpa;

import org.springframework.data.repository.CrudRepository;

import com.oa.pojos.OaLeave;
/**
 * 请假申请Dao接口
 * @author Administrator
 *
 */
public interface LeaveDao extends CrudRepository<OaLeave, Long>{
	
}
