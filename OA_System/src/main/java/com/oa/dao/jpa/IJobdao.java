package com.oa.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oa.pojos.OaJob;

public interface IJobdao extends JpaRepository<OaJob,String>{

	@Query("select j from OaJob j")
	public List<OaJob> queryJob();
}
