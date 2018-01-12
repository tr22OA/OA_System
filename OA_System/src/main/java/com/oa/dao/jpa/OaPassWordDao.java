package com.oa.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oa.pojos.OaPassword;

public interface OaPassWordDao extends JpaRepository<OaPassword, String>{

}
