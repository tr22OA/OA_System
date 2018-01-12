package com.oa.controller.zmy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oa.pojos.OaMenu;
import com.oa.service.zmy.MenuService;
/**
 * index页面控制器
 * @author Administrator
 *
 */
@Controller
public class IndexController {

	@Autowired
	MenuService mService;
	

	/**
	 * 首页界面
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView toIndex(){
		ModelAndView mv=new ModelAndView();
		List<OaMenu> menu = mService.getMainMenu();
		mv.addObject("menus",menu);
		return mv;
	}
	
	/**
	 * 菜单设置界面
	 * @return
	 */
	@RequestMapping("/powerSet")
	public String toPowerSet(){
		return "powerSet";
	}
	
}
