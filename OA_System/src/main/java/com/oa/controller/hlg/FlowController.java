package com.oa.controller.hlg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.pojos.OaFlow;
import com.oa.service.hlg.FlowService;

@Controller
public class FlowController {
	
	@Autowired
	private FlowService flowService;
	/**
	 * 跳转到待办流程页面
	 */ 
	@RequestMapping("/tonodealFlow")
	public String toNodealFlow(){
		return "nodealFlow";
	}
	
	/**
	 * 查询待办流程
	 */
	@RequestMapping("/queryFlow")
	@ResponseBody
	public Map<String, Object> queryFlow(){
		int state=1;
		int step=1;
		List<OaFlow> list = flowService.queryFlowAll(state, step);
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 按条件查询待办流程
	 * 
	 */
	@RequestMapping("/queryToFlow")
	@ResponseBody
	public void queryToFlow(String flowName){
		System.out.println(flowName);
		
		/*int state=1;
		int step=1;
		List<OaFlow> list = flowService.queryFlowAll(state, step);
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("data", list);
		return map;*/
	}
}
