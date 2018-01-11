package com.oa.service.zmy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oa.dao.jpa.OaMenuDao;
import com.oa.pojos.OaMenu;


@Service
public class MenuService {

	/**
	 * 自动注入mDao
	 * 在使用之前，注入需要的dao层类
	 * 
	 * 该类只能写跟菜单模块相关的业务代码
	 * 
	 * 
	 */
	@Autowired
	OaMenuDao mDao;
	
	/**
	 * @return 以树的结构返回所有菜单
	 */
	public List<Map<String,Object>> getMenuList(int fatherId){
		List<OaMenu> list = mDao.findMenus();
		return createTree(list, fatherId);
	}

	/**
	 * 生成菜单树形结构
	 * @param list
	 * @param fid
	 * @return
	 */
	public List<Map<String,Object>> createTree(List<OaMenu> list,int fid){
		List<Map<String,Object>> treeData=new ArrayList<>();
		for (OaMenu meun : list) {
			if(meun.getMenuFather()==fid){
				Map<String,Object> map =new HashMap<>();
				map.put("id",meun.getMenuId());
				map.put("text",meun.getMeuName());
				map.put("url",meun.getMenuLink());
				map.put("icon",meun.getMenuImg());
				map.put("children", createTree(list,meun.getMenuId()));
				treeData.add(map);
			}
			
		}
		return treeData;
	}

	/**
	 * 增加菜单
	 * @param m
	 * @return
	 */
	public Boolean add(OaMenu m) {
			mDao.save(m);
			return true;
	}

	/**
	 * 分页查询菜单表格数据
	 * @param currentPage
	 * @param limit
	 * @return
	 */
	public Map<String, Object> getMenuTable(int currentPage, int limit) {
		//获取数据库所有菜单数据
		
		Pageable pageable=new PageRequest(currentPage-1, limit);
		Page<OaMenu> page = mDao.findAll(pageable);
		Map<String, Object> dataMap=new HashMap<>();
		List<OaMenu> list = page.getContent();
		dataMap.put("code", 0);
		dataMap.put("count", page.getTotalElements());
		dataMap.put("data", list);
		return dataMap;
	}

	/**
	 * 编辑数据
	 * @param m
	 * @return
	 */
	public Boolean edit(OaMenu m) {
		System.out.println(m.getMenuId());
		OaMenu menu = mDao.findOne(m.getMenuId());
		menu.setMenuFather(m.getMenuFather());
		menu.setMenuImg(m.getMenuImg());
		menu.setMenuIsvisible(m.getMenuIsvisible());
		menu.setMenuLink(m.getMenuLink());
		menu.setMeuName(m.getMeuName());
		mDao.save(menu);
		return null;
	}
	
	/**
	 * 删除数据
	 * @param m
	 * @return
	 */
	public Boolean del(OaMenu m) {
		mDao.delete(m);
		return null;
	}

	
	
	/**
	 * 查找主菜单
	 * @return
	 */
	public List<OaMenu> getMainMenu() {
		return mDao.findMianMenu();
	}

}
