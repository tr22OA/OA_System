package com.oa.controller.zmy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.pojos.OaMenu;
import com.oa.service.zmy.MenuService;

@Controller
public class MenuController {

	/**
	 * 在使用前需要注入需要调用的业务层的类
	 * 
	 * 该类规范控制层的代码书写，只能写请求地址和返回的内容，以及转发的地址。不做任何逻辑的判断和操作，
	 * 逻辑的判断和操作交由业务层处理。
	 * 
	 * 请求地址命名规范如下，“操作类型”+“操作对象”
	 */
	
	@Autowired
	MenuService mService;
	
	/**
	 * 增加菜单URL
	 * @param req
	 * @return
	 */
	@RequestMapping("/addMenu")
	public @ResponseBody Boolean addMenu(OaMenu m){
	/*	OaMenu m=new OaMenu(
				req.getParameter("menuId"),
				req.getParameter("meuName"),
				req.getParameter("menuLink"),
				req.getParameter("menuFather"),
				req.getParameter("menuIsvisible")
				);*/
		
		return mService.add(m);
		
	}
	
	/**
	 * 编辑菜单URL
	 * @param m
	 */
	@RequestMapping("/editMenu")
	public @ResponseBody void editMenu(OaMenu m){
		mService.edit(m);
		
	}
	
	/**
	 * 删除菜单URL
	 * @param m
	 * @return
	 */
	@RequestMapping(value="/delMenu",params="menuId")
	public @ResponseBody Boolean delMenu(OaMenu m){
		return mService.del(m);
	}
	
	/**
	 * 根据父级菜单获取菜单
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/menuList",params="fatherId")
	public @ResponseBody List<Map<String,Object>> menuList(HttpServletRequest req){
		String fatherId=req.getParameter("fatherId");
		List<Map<String,Object>> list=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();
		if(fatherId.equals("")){
			map.put("result", "fatherId为空");
			list.add(map);
			return list;
		}
		try{
			return mService.getMenuList(Integer.parseInt(fatherId));
		}catch(Exception e){
			map.put("result", "非法请求");
			list.add(map);
			return list;
		}
		
	}
	
	/**
	 * 获取表格数据
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/table")
	public @ResponseBody Map<String, Object> menuTable(int page,int limit){
		Map<String, Object> table = mService.getMenuTable(page,limit);
		return table;
	}
	
}
