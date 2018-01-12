package com.oa.service.zmy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.dao.jpa.OaEmpDao;
import com.oa.dao.jpa.OaPassWordDao;
import com.oa.pojos.OaEmp;
import com.oa.pojos.OaPassword;

@Service
public class LoginService {

	@Autowired
	OaEmpDao eDao;
	@Autowired
	OaPassWordDao pDao;
	
	public OaEmp vaildatorLogin(String userName,String password){
		OaEmp emp = eDao.findOne(userName);
		if (emp==null) {
			return null;
		}
		OaPassword dbpassword = pDao.findOne(userName);
		if(password.equals(dbpassword.getPaPass())){
			return emp;
		}
		return null;
	}
}
