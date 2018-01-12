package com.oa.dao.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import com.oa.pojos.OaEmp;

public interface OaEmpDao extends JpaRepository<OaEmp, String>{
	
}
