package com.oa.controller.fwt;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oa.service.fwt.Empservice;
import com.xiaoleilu.hutool.http.HttpRequest;

@Controller
public class empcontroller {
	
	@Autowired
	Empservice es;
	
	@RequestMapping("/toEmp")
	public ModelAndView toEmp(){
		ModelAndView mv = new ModelAndView("emp");
		mv.addObject("dept", es.findDept());
		return mv;
	}
	
	@RequestMapping("/queryEmp")
	public @ResponseBody Map<String,Object> queryEmp(int page,int limit,String dept,String name,String type,String state,String begindate,String enddate){
		
		return es.findEmppage(page, limit,dept,name,type,state,begindate,enddate);
	}
	
	
}
