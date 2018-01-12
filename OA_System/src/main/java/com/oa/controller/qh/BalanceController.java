package com.oa.controller.qh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.vo.qh.BalanceVo;

@Controller
public class BalanceController {
	/**
	 * 进入加班结余主界面
	 * @return
	 */
	@RequestMapping("/to_balance")
	public String to_balance() {
		return "balance";
	}
	/**
	 * 查询加班结余信息
	 * @return
	 */
	@RequestMapping("/findBalanceList")
	public @ResponseBody Map<String, Object> findBalanceList() {
		List<BalanceVo> data=new ArrayList<>();
		data.add(new BalanceVo("人事部","樊文韬",1));
		data.add(new BalanceVo("人事部","黄琼",1));
		data.add(new BalanceVo("财务部","瞿红",0));
		data.add(new BalanceVo("总经部","曾梦园",0));
		data.add(new BalanceVo("采购部","何立贵",0));
		data.add(new BalanceVo("采购部","何志康",1));
		data.add(new BalanceVo("行政部","岳婷",0));
		Map<String, Object>map=new HashMap<>();
		map.put("data", data);
		map.put("count",data.size());
		map.put("code", 0);
		return map;
	}
	/**
	 * 分装数据到修改加班页面
	 * @param session
	 * @param balanceVo
	 */
	@RequestMapping("/to_Incoming_Data")
	public void to_Incoming_Data(HttpSession session,BalanceVo balanceVo) {
		session.setAttribute("to_balancevo", balanceVo);
	}
	/**
	 * 进入变更日志界面
	 * @return
	 */
	@RequestMapping("/to_Changelog")
	public String to_Changelog() {
		return "balance_Changelog";
	}
	/**
	 * 进入明细记录界面
	 * @return
	 */
	@RequestMapping("/to_Detailrecord")
	public String to_Detailrecord() {
		return "balance_Detailrecord";
	}
	/**
	 * 进入历年加班界面
	 * @return
	 */
	@RequestMapping("/to_Overtheyear")
	public String to_Overtheyear() {
		return "balance_Overtheyears";
	}
}
