package com.oa.controller.zmy;

import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.pojos.OaMenu;
import com.oa.service.zmy.MenuService;
import com.oa.utils.ResultMap;

@Controller
public class MenuController {

	/**
	 * 在使用前需要注入需要调用的业务层的类
	 * 
	 * 该类规范控制层的代码书写，只能写请求地址和返回的内容，以及转发的地址。不做任何逻辑的判断和操作， 逻辑的判断和操作交由业务层处理。
	 * 
	 * 请求地址命名规范如下，“操作类型”+“操作对象”
	 */

	@Autowired
	MenuService mService;

	/**
	 * 增加菜单URL
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/addMenu")
<<<<<<< HEAD
	public @ResponseBody Boolean addMenu(HttpServletRequest req){
		OaMenu m=new OaMenu(
				req.getParameter("menuId"),
				req.getParameter("meuName"),
				req.getParameter("menuLink"),
				req.getParameter("menuFather"),
				req.getParameter("menuIsvisible")
				);
		
		System.out.println(m);
		return mService.add(m);
		
=======
	public @ResponseBody HashMap<String, Object> addMenu(HttpServletRequest req) {
		/*
		 * OaMenu m=new OaMenu( req.getParameter("menuId"),
		 * req.getParameter("meuName"), req.getParameter("menuLink"),
		 * req.getParameter("menuFather"), req.getParameter("menuIsvisible") );
		 * 
		 */
		Boolean result = false;
		try {
			String meuName = req.getParameter("meuName");
			String menuFather = req.getParameter("menuFather");
			String menuLink = req.getParameter("menuLink");
			String menuImg = req.getParameter("menuImg");
			String menuIsvisible = req.getParameter("menuIsvisible");
			
			System.out.println(meuName+","
					+menuFather+","
					+menuLink+","
					+menuImg+","
					+menuIsvisible+",");
			OaMenu m=new OaMenu(Integer.parseInt( menuFather), menuImg, Integer.parseInt(menuIsvisible), menuLink, meuName);
			result = mService.addMenu(m);
			ResultMap.putObj("success", result);
			return ResultMap.putObj("msg", "添加成功");
		} catch (Exception e) {
			ResultMap.putObj("success", result);
			return ResultMap.putObj("msg", e.getMessage());
		}
>>>>>>> zmy
	}

	/**
	 * 编辑菜单URL
	 * 
	 * @param m
	 */
	@RequestMapping("/editMenu")
	public @ResponseBody HashMap<String, Object> editMenu(OaMenu m) {
		try {
			Boolean result = mService.editMenu(m);
			ResultMap.putObj("success", result);
			return ResultMap.putObj("msg", result?"修改成功":"修改失败");
		} catch (Exception e) {
			ResultMap.putObj("success", false);
			return ResultMap.putObj("msg", e.getMessage());
		}
	}

	/**
	 * 删除菜单URL
	 * 
	 * @param m
	 * @return
	 */
<<<<<<< HEAD
	@RequestMapping("/delMenu")
	public @ResponseBody Boolean delMenu(OaMenu m){
		return mService.del(m);
		
	}
	
	/**
	 * 菜单表单URL
	 * @param m
	 * @return
	 */
	@RequestMapping("/form")
	public String toFrom(OaMenu m){
		return "menuForm";
	}
	

	
=======
	@RequestMapping(value = "/delMenu", params = "menuId")
	public @ResponseBody HashMap<String, Object> delMenu(OaMenu m) {
		try {
			boolean result = mService.delMenu(m);
			ResultMap.putObj("success", result);
			return ResultMap.putObj("msg", result?"删除成功":"删除失败");
		} catch (Exception e) {
			ResultMap.putObj("success", false);
			return ResultMap.putObj("msg", e.getMessage());
		}
		
	}

>>>>>>> zmy
	/**
	 * 根据父级菜单获取菜单
	 * 
	 * @param req
	 * @return
	 */
<<<<<<< HEAD
	@RequestMapping("/menuList")
	public @ResponseBody List<Map<String,Object>> menuList(HttpServletRequest req){
		System.out.println(req.getParameter("fatherId"));
		return mService.getMenuList(Integer.parseInt(req.getParameter("fatherId")));
=======
	@RequestMapping(value = "/menuList", params = "fatherId")
	public @ResponseBody List<Map<String, Object>> menuList(HttpServletRequest req) {
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			String fatherId = req.getParameter("fatherId");
			Map<String, Object> map = new HashMap<>();
			if (fatherId.equals("")) {
				ResultMap.putObj("result", "fatherId为空");
				list.add(map);
				return list;
			}
			return mService.getMenuList(Integer.parseInt(fatherId));
		} catch (Exception e) {
			ResultMap.putObj("result", "非法请求");
			list.add(ResultMap.getResultMap());
			return list;
		}

>>>>>>> zmy
	}

	/**
	 * 获取表格数据
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/table", params = { "page", "limit" })
	public @ResponseBody Map<String, Object> menuTable(int page, int limit) {
		try{
			Map<String, Object> table = mService.getMenuTable(page, limit);
			return table;
		}catch(Exception e){
			return ResultMap.putObj("msg", e.getMessage());
		}
		
	}

}
