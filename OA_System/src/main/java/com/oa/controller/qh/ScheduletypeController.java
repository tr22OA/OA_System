package com.oa.controller.qh;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.pojos.OaScheduletype;
import com.oa.service.qh.ScheduletypeService;

/**
 * 排班类型controller
 * @author qh
 *
 */
@Controller
public class ScheduletypeController {
	@Autowired
	private ScheduletypeService scheduletypeService;
	/**
	 * 进入排班类型界面
	 * @return
	 */
	@RequestMapping("/to_Scheduletype")
	public String to_Scheduletype() {
		return "Scheduletype";
	}
	/**
	 * 分页查询排班类型
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/findScheduletTypeList")
	public @ResponseBody Map<String, Object> findTypeList(int page,int limit) {
		return scheduletypeService.queryAllScheduletype(page, limit);
	}
	/**
	 * 编辑排班类型表单
	 * @return
	 */
	@RequestMapping("/to_AddScheduletype")
	public String to_AddScheduletype() {
		return "AddScheduletype";
	}
	/**
	 * 新增一个排班类型
	 */
	@RequestMapping("/to_addScheduletype")
	public void to_addScheduletype(OaScheduletype oaScheduletype) {
		
	}
}
