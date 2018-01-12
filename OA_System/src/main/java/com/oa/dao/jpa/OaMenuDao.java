package com.oa.dao.jpa;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.oa.pojos.OaMenu;
public interface OaMenuDao extends JpaRepository<OaMenu, Integer>{

	/**
	 * 获所有菜单
	 * @return
	 */
	@Query("select new com.oa.pojos.OaMenu(m.menuId,m.menuFather,m.menuImg,m.menuIsvisible,"
			+ "m.menuLink,m.meuName) from OaMenu m")
	public List<OaMenu> findMenus();
	/**
	 * 查找父id为0的菜单
	 * @return
	 */
	@Query("select new com.oa.pojos.OaMenu(m.menuId,m.menuFather,m.menuImg,m.menuIsvisible,"
			+ "m.menuLink,m.meuName) from OaMenu m where m.menuFather=0")
	public List<OaMenu> findMianMenu();
}
