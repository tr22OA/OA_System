package com.oa.test.zmy;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.service.zmy.MenuService;

public class MenuTest {
	
	MenuService menuService;
	
	@Before
	public void loadContext(){
		ApplicationContext context =new ClassPathXmlApplicationContext("classpath:Spring-context.xml");
		menuService= context.getBean(MenuService.class);
	}
	
	/**
	 * 测试寻找所有菜单
	 * @throws Exception
	 */
	@Test
	public void findAll() throws Exception {
		/*List<Map<String,Object>> list = menuService.getMenuList();
		if(list==null)return;
		for (Map<String, Object> map : list) {
			for (Entry<String, Object> entry :  map.entrySet()) {
					System.out.println(entry.getKey()+":"+entry.getValue());
			}
		}*/
	}
}