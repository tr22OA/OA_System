package com.oa.controller.qh;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.vo.qh.attendanceCountVo;
import com.oa.vo.qh.attendanceNotesVo;
import com.oa.vo.qh.deptVo;

@Controller
public class KQTJController {
	/**
	 * 考勤统计界面
	 * @return
	 */
	@RequestMapping("/to_kqtj")
	public String to_kqtj() {
		return "KQ_kqtj";
	}
	/**
	 * 考勤统计数据表格
	 * @return
	 */
	@RequestMapping("/to_attendancesCount")
	public @ResponseBody Map<String, Object> to_attendancesCount(){
		List<attendanceCountVo> data=new ArrayList<>();
		data.add(new attendanceCountVo("1","张三",0,1,1,1,1,0,1,1,1,1,1,1,0,1,2));
		data.add(new attendanceCountVo("2","李四",0,1,1,1,1,1,1,1,1,1,0,0,0,0,0));
		data.add(new attendanceCountVo("3","王五",0,1,1,1,1,1,1,1,1,1,0,0,0,0,0));
		data.add(new attendanceCountVo("4","赵六",0,1,1,1,1,1,1,1,1,0,0,0,0,0,1));
		data.add(new attendanceCountVo("5","赵六",0,1,1,1,1,1,1,1,1,0,0,0,0,0,1));
		data.add(new attendanceCountVo("6","赵六",0,1,1,1,1,1,1,1,1,0,0,0,0,0,1));
		data.add(new attendanceCountVo("7","赵六",0,1,1,1,1,1,1,1,1,0,0,0,0,0,1));
		data.add(new attendanceCountVo("8","赵六",0,1,1,1,1,1,1,1,1,0,0,0,0,0,1));
		data.add(new attendanceCountVo("9","赵六",0,1,1,1,1,1,1,1,1,0,0,0,0,0,1));
		data.add(new attendanceCountVo("10","赵六",0,1,1,1,1,1,1,1,1,0,0,0,0,0,1));
		Map<String, Object> map=new HashMap<>();
		map.put("data", data);
		map.put("count",data.size());
		map.put("code", 0);
		System.out.println(data.size());
		return map;
	}
	
	/**
	 * 修改加班结余
	 * @return
	 */
	@RequestMapping("/to_balanceAmend")
	public String to_balanceAmend() {
		return "balance_Amendovertime";
	}
	/**
	 * 考勤记录界面
	 * @return
	 */
	@RequestMapping("/to_attendanceNotes")
	public String to_attendanceNotes() {
		return "attendanceNotes";
	}
	/**
	 * 考勤记录动态表格
	 * @return
	 */
	@RequestMapping("/toNotes")
	public @ResponseBody Map<String, Object> toNotes() {
		List<attendanceNotesVo> list=new ArrayList<>();
		list.add(new attendanceNotesVo("2018-1-7","星期一","登记","登记"));
		list.add(new attendanceNotesVo("2018-1-8","星期二","登记","登记"));
		list.add(new attendanceNotesVo("2018-1-9","星期三","登记","登记"));
		list.add(new attendanceNotesVo("2018-1-10","星期四","登记","登记"));
		list.add(new attendanceNotesVo("2018-1-11","星期五","登记","登记"));
		Map<String, Object> map=new HashMap<>();
		map.put("data", list);
		map.put("count",list.size());
		map.put("code", 0);
		return map;
	}
	/**
	 * 集中考勤界面
	 * @return
	 */
	@RequestMapping("to_focusAttendance")
	public String to_focusAttendance() {
		return "focusAttendance";
	}
	/**
	 * 集中考勤页面部门下拉列表
	 * @return
	 */
	@RequestMapping("/to_Select")
	public @ResponseBody List<deptVo> to_Select() {
		List<deptVo>list=new ArrayList<>();
		list.add(new deptVo("1","人事部"));
		list.add(new deptVo("2","总经办"));
		list.add(new deptVo("3","财务部"));
		list.add(new deptVo("4","采购部"));
		return list;
	}
	/*@RequestMapping("/getLastDayOfMonth")
	public @ResponseBody String getLastDayOfMonth(String da) {
		
		System.out.println("aa"+da);
		
		String aString="成功";
		return aString;
		
	}*/
	@RequestMapping("/to_form")
	public @ResponseBody String to_form(String dept,String time) {
		System.out.println(dept);
		System.out.println(time);
		String aString="成功";
		return aString;
	}
	
	
}
