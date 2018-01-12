package com.oa.service.zmy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.jpa.OaMenuDao;
import com.oa.pojos.OaMenu;

@Service
@Transactional
public class MenuService {

	/**
	 * 自动注入mDao 在使用之前，注入需要的dao层类
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
	public List<Map<String, Object>> getMenuList(int fatherId) {
		try {
			List<OaMenu> list = mDao.findMenus();
			return createTree(list, fatherId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 生成菜单树形结构
	 * 
	 * @param list
	 * @param fid
	 * @return
	 */
	public List<Map<String, Object>> createTree(List<OaMenu> list, int fid) {
		try {
			List<Map<String, Object>> treeData = new ArrayList<>();
			for (OaMenu meun : list) {
				if (meun.getMenuFather() == fid) {
					Map<String, Object> map = new HashMap<>();
					map.put("id", meun.getMenuId());
					map.put("text", meun.getMeuName());
					map.put("url", meun.getMenuLink());
					map.put("icon", meun.getMenuImg());
					map.put("children", createTree(list, meun.getMenuId()));
					treeData.add(map);
				}

			}
			return treeData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 增加菜单
	 * 
	 * @param m
	 * @return
	 */
	public Boolean addMenu(OaMenu m) {
		try {
			mDao.save(m);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 分页查询菜单表格数据
	 * 
	 * @param currentPage
	 * @param limit
	 * @return
	 */
	public Map<String, Object> getMenuTable(int currentPage, int limit) {
		// 获取数据库所有菜单数据

		Pageable pageable = new PageRequest(currentPage - 1, limit);
		Page<OaMenu> page = mDao.findAll(pageable);
		Map<String, Object> dataMap = new HashMap<>();
		List<OaMenu> list = page.getContent();
		dataMap.put("code", 0);
		dataMap.put("count", page.getTotalElements());
		dataMap.put("data", list);
		return dataMap;
	}

	/**
	 * 编辑数据
	 * 
	 * @param m
	 * @return
	 * @throws Exception 
	 */
	public Boolean editMenu(OaMenu m) throws Exception {
		try {
			OaMenu menu = mDao.findOne(m.getMenuId());
			if(menu==null){
				throw new Exception("没有找到匹配的数据");
			}
			menu.setMenuFather(m.getMenuFather());
			menu.setMenuImg(m.getMenuImg());
			menu.setMenuIsvisible(m.getMenuIsvisible());
			menu.setMenuLink(m.getMenuLink());
			menu.setMeuName(m.getMeuName());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * 删除数据
	 * 
	 * @param m
	 * @return
	 */
	public Boolean delMenu(OaMenu m) {
		try {
			mDao.delete(m);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 查找主菜单
	 * 
	 * @return
	 */
	public List<OaMenu> getMainMenu() {
		try {
			return mDao.findMianMenu();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
