package com.oa.controller.hlg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.pojos.OaLeave;
import com.oa.service.hlg.LeaveService;

@Controller
public class LeaveController {
	SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private LeaveService leaveService;
	
	
	/**
	 * 跳转到请假申请表单页面
	 */
	@RequestMapping("/toLeave")
	public String toLeave(){
		return "leave";
	}
	
	/**
	 * 接收请假申请单传递过来的数据
	 */
	@RequestMapping("/getLeave")
	public @ResponseBody String getLeave(String leaName,String dept,String position,
			String lea_type,String startdate,String enddate,int leaDay,String leaContent,String deptApprove,
			String managerApprove,String personFile,String deptApprovePerson,String positionApprovePerson,String type){
		OaLeave oaLeave=new OaLeave();
		oaLeave.setLeaName(leaName);
	/*	oaLeave.setDept(dept);
		oaLeave.setPosition(position);
		oaLeave.setLeaType(lea_type);
			try {
				oaLeave.setStartdate(sdf.parse(startdate));
				oaLeave.setEnddate(sdf.parse(enddate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		oaLeave.setLeaDay(leaDay);
		oaLeave.setLeaContent(leaContent);
		oaLeave.setDeptApprove(deptApprove);
		oaLeave.setManagerApprove(managerApprove);
		oaLeave.setPersonFile(personFile);
		oaLeave.setDeptApprovePerson(deptApprovePerson);
		oaLeave.setPositionApprovePerson(positionApprovePerson);*/
		leaveService.addLeave(oaLeave,type);
		System.out.println(leaName);
		//System.out.println(applyDate);
		System.out.println(dept);
		System.out.println(position);
		System.out.println(startdate);
		System.out.println(enddate);
		System.out.println(lea_type);
		System.out.println(leaDay);
		System.out.println(leaContent);
		System.out.println(deptApprove);
		System.out.println(type);
		System.out.println(managerApprove);
		System.out.println(personFile);
		System.out.println(deptApprovePerson);
		System.out.println(positionApprovePerson);
		return "提交成功！";
	}
}
