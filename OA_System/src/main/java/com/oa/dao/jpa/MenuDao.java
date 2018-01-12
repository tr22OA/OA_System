package com.oa.dao.jpa;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oa.pojos.OaMenu;

public interface MenuDao extends JpaRepository<OaMenu, Integer>{

	/**
	 * 获取所有主菜单
	 * @return
	 */
	@Query("select m from OaMenu m where m.menuFather=0")
	public List<OaMenu> getMainMenu();

	
}
