package com.oa.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.oa.pojos.OaDept;


public interface IDeptdao extends CrudRepository<OaDept, String>{
	
	@Query("select d from OaDept d")
	public List<OaDept> queryDept();
}
